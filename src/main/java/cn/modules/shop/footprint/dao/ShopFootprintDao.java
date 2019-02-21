package cn.modules.shop.footprint.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.footprint.entity.ShopFootprintEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopFootprintDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 11:43:59
*/
@Mapper
public interface ShopFootprintDao extends BaseMapper<ShopFootprintEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopFootprintEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopFootprintEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopFootprintEntity>
    */
    public List<ShopFootprintEntity> selectListModel(@Param("e") ShopFootprintEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopFootprintEntity> 所有符合条件数据
    */
    public List<ShopFootprintEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopFootprintEntity entity, @Param("ew") Wrapper<ShopFootprintEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopFootprintEntity> 所有符合条件数据
    */
    public  List<ShopFootprintEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopFootprintEntity> wrapper);
}
