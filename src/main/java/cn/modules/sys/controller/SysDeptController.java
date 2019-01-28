package cn.modules.sys.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.base.AbstractController;
import cn.common.factory.PageFactory;
import cn.common.utils.PageUtils;
import cn.common.utils.Result;
import cn.common.utils.ToolUtil;
import cn.common.vo.TreeVo;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.modules.sys.entity.SysDeptEntity;
import cn.modules.sys.service.SysDeptService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
* 部门表控制器
*
* @author zhangheng
* @date 2018-10-26 10:45:52
*/
@RestController
@RequestMapping("/sysdept")
public class SysDeptController extends AbstractController {


    @Autowired
    private SysDeptService sysDeptService;


    /**
     * 获取分页信息
     * @param entity 对象
     * @return Object 分页信息
     */
    @GetMapping(value = "/list")
    public Object list(SysDeptEntity entity) {
        Page<SysDeptEntity> page = new PageFactory<SysDeptEntity>().defaultPage();
        page.setRecords(sysDeptService.selectPage(page,entity,new EntityWrapper<>()));

        return Result.ok().put("page", new PageUtils(page));
    }



    /**
     * 获取所有信息
     * @param entity 对象
     * @return Object 所有部门
     */
    @GetMapping(value = "/all")
    public Object all(SysDeptEntity entity) {
       List<SysDeptEntity> list = sysDeptService.selectList(entity);

        return Result.ok().put("list",list);
    }

    /**
    * 新增
    * @param entity 对象
    * @return Object 执行结果
    */
    @PostMapping(value = "/add")
    @RequiresPermissions("sysdept:add")
    public Object add(@RequestBody SysDeptEntity entity) {
        if (StringUtils.isNoneBlank(entity.getSimplename())){
            if (StrUtil.isBlank(entity.getFullname())){
                entity.setFullname(entity.getSimplename());
            }
            //完善pids,根据pid拿到pid的pids
            deptSetPids(entity);
        }
        sysDeptService.insert(entity);
        return Result.ok();
    }

    @GetMapping(value = "/depttree")
    public Object tree(SysDeptEntity entity){

        TreeVo top = new TreeVo("-1","部门管理","fa fa-align-justify",false);
        List<SysDeptEntity> deptModels = sysDeptService.selectList(entity);
        List<TreeVo> jsTreeChildren = new ArrayList<>();
        for (SysDeptEntity res:deptModels) {
            if (StringUtils.isNoneBlank(res.getPid()) && res.getPid().equals("-1")){
                TreeVo node = new TreeVo(res.getId(),res.getFullname(),"fa fa-file-text-o",false);
                node.setChildren(this.getResChrild(deptModels,res));
                jsTreeChildren.add(node);
            }
        }
        top.setChildren(jsTreeChildren);
        return top;
    }

    /**
    * 删除多个
    * @param id 主键
    * @return Object 执行结果
    */
    @PostMapping(value = "/delete")
    @RequiresPermissions("sysdept:delete")
    public Object delete(@RequestBody String id) {
        sysDeptService.deleteDept(id);
        return Result.ok();
    }

    /**
    * 更新
    * @param entity 对象
    * @return Object
    */
    @PostMapping(value = "/update")
    public Object update(@RequestBody SysDeptEntity entity) {

        deptSetPids(entity);
        if (StrUtil.isBlank(entity.getFullname())){
            entity.setFullname(entity.getSimplename());
        }
        sysDeptService.updateById(entity);
        return Result.ok();
    }

    /**
    * 详情
    * @param entity 对象
    * @return Object 详细对象
    */
    @GetMapping(value = "/info")
    public Object info(SysDeptEntity entity) {

        SysDeptEntity deptEntity = sysDeptService.selectOne(entity);

        if (StrUtil.isNotBlank(deptEntity.getPid())){
            SysDeptEntity pentity = sysDeptService.selectById(deptEntity.getPid());
            if (pentity != null && StrUtil.isNotBlank(pentity.getSimplename())){
                deptEntity.setpName(pentity.getSimplename());
            }
        }

        return Result.ok().put("sysdept", deptEntity);
    }

    /**
    * 导出Excel文件
    * @param request http请求
    * @param response http返回
    * @param entity 对象
    */
    @GetMapping(value="/export")
    public void export(HttpServletRequest request, HttpServletResponse response, SysDeptEntity entity){

        try {
            int importNum  = sysDeptService.selectCount(entity);
            Workbook workbook = null;
            //第一个是导出的接口
            ExportParams exportParams = new ExportParams();
            if (importNum > EXPORT_MAX){
                for (int i = 0; i < importNum/EXPORT_MAX + 1; i++) {
                    Page<SysDeptEntity> page = new Page<>(i+1, EXPORT_MAX);
                    List<SysDeptEntity> result = sysDeptService.selectPage(page,entity,new EntityWrapper<SysDeptEntity>());
                    workbook = ExcelExportUtil.exportBigExcel(exportParams, SysDeptEntity.class,result);
                    result.clear();
                }
                ExcelExportUtil.closeExportBigExcel();
            }else {
                Page<SysDeptEntity> page = new Page<>(1, EXPORT_MAX);
                List<SysDeptEntity> result = sysDeptService.selectPage(page,entity,new EntityWrapper<SysDeptEntity>());
                workbook = ExcelExportUtil.exportExcel(exportParams,SysDeptEntity.class, result);
                }
                String filename = " 部门表("+ DateUtil.today()+")";
                renderExcel(request,response,filename,workbook);
        } catch (Exception e) {
                e.printStackTrace();
                response.setContentType("text/html;charset=utf-8");
            try {
                response.getWriter().write(e.getMessage());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    private void deptSetPids(SysDeptEntity dept) {
        if (ToolUtil.isEmpty(dept.getPid()) || dept.getPid().equals("-1")) {
            dept.setPid("-1");
            dept.setPids("[-1],");
        } else {
            String pid = dept.getPid();
            SysDeptEntity temp = sysDeptService.selectById(pid);
            String pids = temp.getPids();
            dept.setPid(pid);
            dept.setPids(pids + "[" + pid + "],");
        }
    }

    private List<TreeVo> getResChrild(List<SysDeptEntity> list, SysDeptEntity sysRes){

        List<TreeVo> treeVos = new ArrayList<>();
        for (SysDeptEntity res:list){
            if (StringUtils.isNoneBlank(res.getPid()) && sysRes.getId().equals(res.getPid()) ){
                TreeVo node = new TreeVo(res.getId(),res.getFullname(),"fa fa-file-text-o",false);
                node.setChildren(getResChrild(list,res));
                treeVos.add(node);
            }
        }
        return treeVos;
    }

}