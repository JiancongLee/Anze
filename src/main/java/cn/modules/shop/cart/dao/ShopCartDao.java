package cn.modules.shop.cart.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.cart.entity.ShopCartEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopCartDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 12:42:14
*/
@Mapper
public interface ShopCartDao extends BaseMapper<ShopCartEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopCartEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopCartEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopCartEntity>
    */
    public List<ShopCartEntity> selectListModel(@Param("e") ShopCartEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopCartEntity> 所有符合条件数据
    */
    public List<ShopCartEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopCartEntity entity, @Param("ew") Wrapper<ShopCartEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopCartEntity> 所有符合条件数据
    */
    public  List<ShopCartEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopCartEntity> wrapper);
}
