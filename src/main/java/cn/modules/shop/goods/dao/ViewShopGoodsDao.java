package cn.modules.shop.goods.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.goods.entity.ViewShopGoodsEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ViewShopGoodsDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-03-01 00:07:23
*/
@Mapper
public interface ViewShopGoodsDao extends BaseMapper<ViewShopGoodsEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ViewShopGoodsEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ViewShopGoodsEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ViewShopGoodsEntity>
    */
    public List<ViewShopGoodsEntity> selectListModel(@Param("e") ViewShopGoodsEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ViewShopGoodsEntity> 所有符合条件数据
    */
    public List<ViewShopGoodsEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ViewShopGoodsEntity entity, @Param("ew") Wrapper<ViewShopGoodsEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ViewShopGoodsEntity> 所有符合条件数据
    */
    public  List<ViewShopGoodsEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ViewShopGoodsEntity> wrapper);
}
