package cn.modules.shop.goods.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.goods.entity.ShopGoodsEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopGoodsDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 23:00:48
*/
@Mapper
public interface ShopGoodsDao extends BaseMapper<ShopGoodsEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopGoodsEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopGoodsEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopGoodsEntity>
    */
    public List<ShopGoodsEntity> selectListModel(@Param("e") ShopGoodsEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopGoodsEntity> 所有符合条件数据
    */
    public List<ShopGoodsEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopGoodsEntity entity, @Param("ew") Wrapper<ShopGoodsEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopGoodsEntity> 所有符合条件数据
    */
    public  List<ShopGoodsEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopGoodsEntity> wrapper);
}
