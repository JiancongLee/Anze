package cn.modules.shop.category.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.category.entity.ShopCategoryEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopCategoryDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 21:13:26
*/
@Mapper
public interface ShopCategoryDao extends BaseMapper<ShopCategoryEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopCategoryEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopCategoryEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopCategoryEntity>
    */
    public List<ShopCategoryEntity> selectListModel(@Param("e") ShopCategoryEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopCategoryEntity> 所有符合条件数据
    */
    public List<ShopCategoryEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopCategoryEntity entity, @Param("ew") Wrapper<ShopCategoryEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopCategoryEntity> 所有符合条件数据
    */
    public  List<ShopCategoryEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopCategoryEntity> wrapper);
}
