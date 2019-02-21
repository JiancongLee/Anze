package cn.modules.shop.specification.service;
import cn.base.AbstractService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.specification.entity.ShopSpecificationEntity;
import cn.modules.shop.specification.dao.ShopSpecificationDao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* 商品规格表Service  业务接口
*
* @author jianconglee
* @date 2019-02-21 21:02:04
*/
@Service
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public class ShopSpecificationService extends AbstractService<ShopSpecificationDao,ShopSpecificationEntity> {

    /**
    * <p>
    * 根据 model 条件，查询总记录数
    * </p>
    *
    * @param model 实体对象
    * @return int
    */
    public Integer selectCount(ShopSpecificationEntity model){
        return dao.selectCountByModel(model);
    }

    /**
    * 根据 model 条件，删除
    *
    * @param model 实体对象
    * @return boolean
    */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByModel(ShopSpecificationEntity model){
        return SqlHelper.delBool(dao.deleteByModel(model));
    }

    /**
    * <p>
    * 根据 entity 条件，查询全部记录
    * </p>
    *
    * @param model 实体对象封装操作类（可以为 null）
    * @return List<ShopSpecificationEntity>
    */
    public List<ShopSpecificationEntity> selectList(ShopSpecificationEntity model){
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
    * @return List<ShopSpecificationEntity>
    */
    public List<ShopSpecificationEntity> selectPage(Pagination pagination, ShopSpecificationEntity model,Wrapper<ShopSpecificationEntity> wrapper){
        return dao.selectPage(pagination,model,wrapper);

    }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param pagination 分页查询条件
    * @param wrapper   SQL包装
    * @return List<ShopSpecificationEntity>
    */
    public List<ShopSpecificationEntity> selectPage(Pagination pagination,Wrapper<ShopSpecificationEntity> wrapper){
        return dao.queryPage(pagination,wrapper);
    }

}
