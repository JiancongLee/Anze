package cn.modules.shop.coupon.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.coupon.entity.ShopCouponEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopCouponDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 11:03:10
*/
@Mapper
public interface ShopCouponDao extends BaseMapper<ShopCouponEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopCouponEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopCouponEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopCouponEntity>
    */
    public List<ShopCouponEntity> selectListModel(@Param("e") ShopCouponEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopCouponEntity> 所有符合条件数据
    */
    public List<ShopCouponEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopCouponEntity entity, @Param("ew") Wrapper<ShopCouponEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopCouponEntity> 所有符合条件数据
    */
    public  List<ShopCouponEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopCouponEntity> wrapper);
}
