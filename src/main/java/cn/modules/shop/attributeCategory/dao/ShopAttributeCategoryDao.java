package cn.modules.shop.attributeCategory.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.attributeCategory.entity.ShopAttributeCategoryEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopAttributeCategoryDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 20:50:08
*/
@Mapper
public interface ShopAttributeCategoryDao extends BaseMapper<ShopAttributeCategoryEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopAttributeCategoryEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopAttributeCategoryEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopAttributeCategoryEntity>
    */
    public List<ShopAttributeCategoryEntity> selectListModel(@Param("e") ShopAttributeCategoryEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopAttributeCategoryEntity> 所有符合条件数据
    */
    public List<ShopAttributeCategoryEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopAttributeCategoryEntity entity, @Param("ew") Wrapper<ShopAttributeCategoryEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopAttributeCategoryEntity> 所有符合条件数据
    */
    public  List<ShopAttributeCategoryEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopAttributeCategoryEntity> wrapper);
}
