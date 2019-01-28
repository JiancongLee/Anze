package cn.modules.sys.controller;

import cn.base.AbstractController;
import cn.common.annotation.SysLog;
import cn.common.factory.PageFactory;
import cn.common.constant.Constant;
import cn.common.utils.PageUtils;
import cn.common.utils.Result;
import cn.common.validator.Assert;
import cn.common.validator.ValidatorUtils;
import cn.common.validator.group.AddGroup;
import cn.common.validator.group.UpdateGroup;
import cn.modules.sys.entity.SysUserEntity;
import cn.modules.sys.form.PasswordForm;
import cn.modules.sys.service.SysUserRoleService;
import cn.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

import com.google.common.collect.Lists;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SysUserRoleService sysUserRoleService;


	/**
	 * 所有用户列表
	 */
	@GetMapping("/list")
	@RequiresPermissions("sys:user:list")
	public Result list(@RequestParam Map<String, Object> params){
		//只有超级管理员，才能查看所有管理员列表
		if(getUserId() != Constant.SUPER_ADMIN){
			params.put("createUserId", getUserId());
		}
		PageUtils page = sysUserService.queryPage(params);

		return Result.ok().put("page", page);
	}



	/**
	 * 获取用户表分页信息
	 * @param entity 对象
	 * @return Object 分页信息
	 */
	@GetMapping(value = "/deptlist")
	public Object listdept(SysUserEntity entity, String deptList) {

		Page<SysUserEntity> page = new PageFactory<SysUserEntity>().defaultPage();


		if (StringUtils.isBlank(deptList)){
			page.setRecords(sysUserService.selectPageDept(page,entity,new EntityWrapper<>(), Lists.newArrayList()));
		} else {
			page.setRecords(sysUserService.selectPageDept(page,entity,new EntityWrapper<>(), Arrays.asList(deptList.split("\\s*,\\s*"))));
		}
		return Result.ok().put("page", new PageUtils(page));
	}


	/**
     * 获取用户表分页信息
     * @param entity 对象
     * @return Object 分页信息
     */
    @GetMapping(value = "/rolelist")
    public Object rolelist(SysUserEntity entity,String roleList) {

        Page<SysUserEntity> page = new PageFactory<SysUserEntity>().defaultPage();
        if (StringUtils.isBlank(roleList)){
            page.setRecords(sysUserService.selectPage(page,entity,new EntityWrapper<>(), Lists.newArrayList()));
        } else {
            page.setRecords(sysUserService.selectPage(page,entity,new EntityWrapper<>(), Arrays.asList(roleList.split("\\s*,\\s*"))));
        }

        return Result.ok().put("page", new PageUtils(page));
    }

	/**
	 * 获取登录的用户信息
	 */
	@GetMapping("/info")
	public Result info(){
		return Result.ok().put("user", getUser());
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@PostMapping("/password")
	public Result password(@RequestBody PasswordForm form){
		Assert.isBlank(form.getNewpdw(), "新密码不为能空");
		
		//sha256加密
		String password = new Sha256Hash(form.getPdw(), getUser().getSalt()).toHex();
		//sha256加密
		String newPassword = new Sha256Hash(form.getNewpdw(), getUser().getSalt()).toHex();
				
		//更新密码
		boolean flag = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(!flag){
			return Result.error("原密码不正确");
		}
		
		return Result.ok();
	}
	
	/**
	 * 用户信息
	 */
	@GetMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public Result info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.selectById(userId);
		
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return Result.ok().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@PostMapping("/save")
	@RequiresPermissions("sys:user:save")
	public Result save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		
		user.setCreateUserId(getUserId());
		sysUserService.save(user);
		return Result.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@PostMapping("/update")
	@RequiresPermissions("sys:user:update")
	public Result update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);

		user.setCreateUserId(getUserId());
		sysUserService.update(user);
		
		return Result.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@PostMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public Result delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return Result.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return Result.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		return Result.ok();
	}
}
