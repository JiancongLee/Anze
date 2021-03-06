package cn.modules.shop.category.service;
import cn.base.AbstractPureService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.category.entity.ShopCategoryEntity;
import cn.modules.shop.category.dao.ShopCategoryDao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* 商品类型表Service  业务接口
*
* @author jianconglee
* @date 2019-03-12 17:15:31
*/
@Service
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public class ShopCategoryService extends AbstractPureService<ShopCategoryDao,ShopCategoryEntity> {

    /**
    * <p>
    * 根据 model 条件，查询总记录数
    * </p>
    *
    * @param model 实体对象
    * @return int
    */
    public Integer selectCount(ShopCategoryEntity model){
        return dao.selectCountByModel(model);
    }

    /**
    * 根据 model 条件，删除
    *
    * @param model 实体对象
    * @return boolean
    */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByModel(ShopCategoryEntity model){
        return SqlHelper.delBool(dao.deleteByModel(model));
    }

    /**
    * <p>
    * 根据 entity 条件，查询全部记录
    * </p>
    *
    * @param model 实体对象封装操作类（可以为 null）
    * @return List<ShopCategoryEntity>
    */
    public List<ShopCategoryEntity> selectList(ShopCategoryEntity model){
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
    * @return List<ShopCategoryEntity>
    */
    public List<ShopCategoryEntity> selectPage(Pagination pagination, ShopCategoryEntity model,Wrapper<ShopCategoryEntity> wrapper){
        return dao.selectPage(pagination,model,wrapper);

    }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param pagination 分页查询条件
    * @param wrapper   SQL包装
    * @return List<ShopCategoryEntity>
    */
    public List<ShopCategoryEntity> selectPage(Pagination pagination,Wrapper<ShopCategoryEntity> wrapper){
        return dao.queryPage(pagination,wrapper);
    }

}
