package cn.modules.shop.brand.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.brand.entity.ShopBrandEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopBrandDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-03-06 12:41:38
*/
@Mapper
public interface ShopBrandDao extends BaseMapper<ShopBrandEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopBrandEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopBrandEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopBrandEntity>
    */
    public List<ShopBrandEntity> selectListModel(@Param("e") ShopBrandEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopBrandEntity> 所有符合条件数据
    */
    public List<ShopBrandEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopBrandEntity entity, @Param("ew") Wrapper<ShopBrandEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopBrandEntity> 所有符合条件数据
    */
    public  List<ShopBrandEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopBrandEntity> wrapper);
}
