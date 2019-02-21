package cn.modules.sys.service;

import cn.base.AbstractPureService;
import cn.modules.sys.dao.BatchBaseinfoAttachDao;
import cn.modules.sys.entity.BatchBaseinfoAttachEntity;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 基本附件表Service  业务接口
*
* @author zhangheng
* @date 2018-10-31 17:22:03
*/
@Service
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public class BatchBaseinfoAttachService extends AbstractPureService<BatchBaseinfoAttachDao, BatchBaseinfoAttachEntity> {


    /**
    * <p>
    * 根据 model 条件，查询总记录数
    * </p>
    *
    * @param model 实体对象
    * @return int
    */
    public Integer selectCount(BatchBaseinfoAttachEntity model){
        return dao.selectCountByModel(model);
    }

    /**
    * 根据 model 条件，删除
    *
    * @param model 实体对象
    * @return boolean
    */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByModel(BatchBaseinfoAttachEntity model){
        return SqlHelper.delBool(dao.deleteByModel(model));
    }

    /**
    * <p>
    * 根据 entity 条件，查询全部记录
    * </p>
    *
    * @param model 实体对象封装操作类（可以为 null）
    * @return List<BatchBaseinfoAttachEntity>
    */
    public List<BatchBaseinfoAttachEntity> selectList(BatchBaseinfoAttachEntity model){
        return dao.selectListModel(model);
    }
    /**
    * <p>
    * 根据 entity 条件，查询全部记录（并翻页）
    * </p>
    *
    * @param pagination 分页查询条件
    * @param model   实体对象封装操作可以为 null）
    * @param wrapper   SQL包装
    * @return List<BatchBaseinfoAttachEntity>
    */
    public List<BatchBaseinfoAttachEntity> selectPage(Pagination pagination, BatchBaseinfoAttachEntity model, Wrapper<BatchBaseinfoAttachEntity> wrapper){
        return dao.selectPage(pagination,model,wrapper);

    }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param pagination 分页查询条件
    * @param wrapper   SQL包装
    * @return List<BatchBaseinfoAttachEntity>
    */
    public List<BatchBaseinfoAttachEntity> selectPage(Pagination pagination, Wrapper<BatchBaseinfoAttachEntity> wrapper){
        return dao.queryPage(pagination,wrapper);
    }

}
