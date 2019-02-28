package cn.modules.shop.goods.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.goods.entity.ShopGoodsGeneralMerchandiseEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopGoodsGeneralMerchandiseDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-28 23:11:44
*/
@Mapper
public interface ShopGoodsGeneralMerchandiseDao extends BaseMapper<ShopGoodsGeneralMerchandiseEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopGoodsGeneralMerchandiseEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopGoodsGeneralMerchandiseEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopGoodsGeneralMerchandiseEntity>
    */
    public List<ShopGoodsGeneralMerchandiseEntity> selectListModel(@Param("e") ShopGoodsGeneralMerchandiseEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopGoodsGeneralMerchandiseEntity> 所有符合条件数据
    */
    public List<ShopGoodsGeneralMerchandiseEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopGoodsGeneralMerchandiseEntity entity, @Param("ew") Wrapper<ShopGoodsGeneralMerchandiseEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopGoodsGeneralMerchandiseEntity> 所有符合条件数据
    */
    public  List<ShopGoodsGeneralMerchandiseEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopGoodsGeneralMerchandiseEntity> wrapper);
}
