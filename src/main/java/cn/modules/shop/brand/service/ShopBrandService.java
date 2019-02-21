package cn.modules.shop.brand.service;
import cn.base.AbstractService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.brand.entity.ShopBrandEntity;
import cn.modules.shop.brand.dao.ShopBrandDao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* 品牌制造商Service  业务接口
*
* @author jianconglee
* @date 2019-02-21 22:20:34
*/
@Service
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public class ShopBrandService extends AbstractService<ShopBrandDao,ShopBrandEntity> {

    /**
    * <p>
    * 根据 model 条件，查询总记录数
    * </p>
    *
    * @param model 实体对象
    * @return int
    */
    public Integer selectCount(ShopBrandEntity model){
        return dao.selectCountByModel(model);
    }

    /**
    * 根据 model 条件，删除
    *
    * @param model 实体对象
    * @return boolean
    */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByModel(ShopBrandEntity model){
        return SqlHelper.delBool(dao.deleteByModel(model));
    }

    /**
    * <p>
    * 根据 entity 条件，查询全部记录
    * </p>
    *
    * @param model 实体对象封装操作类（可以为 null）
    * @return List<ShopBrandEntity>
    */
    public List<ShopBrandEntity> selectList(ShopBrandEntity model){
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
    * @return List<ShopBrandEntity>
    */
    public List<ShopBrandEntity> selectPage(Pagination pagination, ShopBrandEntity model,Wrapper<ShopBrandEntity> wrapper){
        return dao.selectPage(pagination,model,wrapper);

    }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param pagination 分页查询条件
    * @param wrapper   SQL包装
    * @return List<ShopBrandEntity>
    */
    public List<ShopBrandEntity> selectPage(Pagination pagination,Wrapper<ShopBrandEntity> wrapper){
        return dao.queryPage(pagination,wrapper);
    }

}
