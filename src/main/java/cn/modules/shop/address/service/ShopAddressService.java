package cn.modules.shop.address.service;
import cn.base.AbstractPureService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.address.entity.ShopAddressEntity;
import cn.modules.shop.address.dao.ShopAddressDao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* 收货地址表Service  业务接口
*
* @author jianconglee
* @date 2019-02-21 12:53:46
*/
@Service
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public class ShopAddressService extends AbstractPureService<ShopAddressDao,ShopAddressEntity> {

    /**
    * <p>
    * 根据 model 条件，查询总记录数
    * </p>
    *
    * @param model 实体对象
    * @return int
    */
    public Integer selectCount(ShopAddressEntity model){
        return dao.selectCountByModel(model);
    }

    /**
    * 根据 model 条件，删除
    *
    * @param model 实体对象
    * @return boolean
    */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByModel(ShopAddressEntity model){
        return SqlHelper.delBool(dao.deleteByModel(model));
    }

    /**
    * <p>
    * 根据 entity 条件，查询全部记录
    * </p>
    *
    * @param model 实体对象封装操作类（可以为 null）
    * @return List<ShopAddressEntity>
    */
    public List<ShopAddressEntity> selectList(ShopAddressEntity model){
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
    * @return List<ShopAddressEntity>
    */
    public List<ShopAddressEntity> selectPage(Pagination pagination, ShopAddressEntity model,Wrapper<ShopAddressEntity> wrapper){
        return dao.selectPage(pagination,model,wrapper);

    }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param pagination 分页查询条件
    * @param wrapper   SQL包装
    * @return List<ShopAddressEntity>
    */
    public List<ShopAddressEntity> selectPage(Pagination pagination,Wrapper<ShopAddressEntity> wrapper){
        return dao.queryPage(pagination,wrapper);
    }

    /**
     * 根据 entity 条件
     */
    public ShopAddressEntity selectInfo(ShopAddressEntity model){
        return dao.selectInfo(model);
    }

}
