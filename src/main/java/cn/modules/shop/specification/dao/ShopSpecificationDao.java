package cn.modules.shop.specification.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.specification.entity.ShopSpecificationEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopSpecificationDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 21:02:04
*/
@Mapper
public interface ShopSpecificationDao extends BaseMapper<ShopSpecificationEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopSpecificationEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopSpecificationEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopSpecificationEntity>
    */
    public List<ShopSpecificationEntity> selectListModel(@Param("e") ShopSpecificationEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopSpecificationEntity> 所有符合条件数据
    */
    public List<ShopSpecificationEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopSpecificationEntity entity, @Param("ew") Wrapper<ShopSpecificationEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopSpecificationEntity> 所有符合条件数据
    */
    public  List<ShopSpecificationEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopSpecificationEntity> wrapper);
}
