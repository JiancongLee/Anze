package cn.modules.shop.footprint.service;
import cn.base.AbstractPureService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.footprint.entity.ShopFootprintEntity;
import cn.modules.shop.footprint.dao.ShopFootprintDao;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
* 会员足迹表Service  业务接口
*
* @author jianconglee
* @date 2019-02-21 11:43:59
*/
@Service
@Transactional(readOnly = true,rollbackFor={RuntimeException.class})
public class ShopFootprintService extends AbstractPureService<ShopFootprintDao,ShopFootprintEntity> {

    /**
    * <p>
    * 根据 model 条件，查询总记录数
    * </p>
    *
    * @param model 实体对象
    * @return int
    */
    public Integer selectCount(ShopFootprintEntity model){
        return dao.selectCountByModel(model);
    }

    /**
    * 根据 model 条件，删除
    *
    * @param model 实体对象
    * @return boolean
    */
    @Transactional(rollbackFor={RuntimeException.class})
    public boolean deleteByModel(ShopFootprintEntity model){
        return SqlHelper.delBool(dao.deleteByModel(model));
    }

    /**
    * <p>
    * 根据 entity 条件，查询全部记录
    * </p>
    *
    * @param model 实体对象封装操作类（可以为 null）
    * @return List<ShopFootprintEntity>
    */
    public List<ShopFootprintEntity> selectList(ShopFootprintEntity model){
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
    * @return List<ShopFootprintEntity>
    */
    public List<ShopFootprintEntity> selectPage(Pagination pagination, ShopFootprintEntity model,Wrapper<ShopFootprintEntity> wrapper){
        return dao.selectPage(pagination,model,wrapper);

    }

    /**
    * 根据 entity 条件，查询全部记录（并翻页）
    *
    * @param pagination 分页查询条件
    * @param wrapper   SQL包装
    * @return List<ShopFootprintEntity>
    */
    public List<ShopFootprintEntity> selectPage(Pagination pagination,Wrapper<ShopFootprintEntity> wrapper){
        return dao.queryPage(pagination,wrapper);
    }

}
