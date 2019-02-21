package cn.modules.shop.feedback.service;
import cn.base.AbstractService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.feedback.entity.ShopFeedbackEntity;
import cn.modules.shop.feedback.dao.ShopFeedbackDao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* 商品反馈表Service  业务接口
*
* @author jianconglee
* @date 2019-02-21 22:41:09
*/
@Service
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public class ShopFeedbackService extends AbstractService<ShopFeedbackDao,ShopFeedbackEntity> {

    /**
    * <p>
    * 根据 model 条件，查询总记录数
    * </p>
    *
    * @param model 实体对象
    * @return int
    */
    public Integer selectCount(ShopFeedbackEntity model){
        return dao.selectCountByModel(model);
    }

    /**
    * 根据 model 条件，删除
    *
    * @param model 实体对象
    * @return boolean
    */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByModel(ShopFeedbackEntity model){
        return SqlHelper.delBool(dao.deleteByModel(model));
    }

    /**
    * <p>
    * 根据 entity 条件，查询全部记录
    * </p>
    *
    * @param model 实体对象封装操作类（可以为 null）
    * @return List<ShopFeedbackEntity>
    */
    public List<ShopFeedbackEntity> selectList(ShopFeedbackEntity model){
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
    * @return List<ShopFeedbackEntity>
    */
    public List<ShopFeedbackEntity> selectPage(Pagination pagination, ShopFeedbackEntity model,Wrapper<ShopFeedbackEntity> wrapper){
        return dao.selectPage(pagination,model,wrapper);

    }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param pagination 分页查询条件
    * @param wrapper   SQL包装
    * @return List<ShopFeedbackEntity>
    */
    public List<ShopFeedbackEntity> selectPage(Pagination pagination,Wrapper<ShopFeedbackEntity> wrapper){
        return dao.queryPage(pagination,wrapper);
    }

}
