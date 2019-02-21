package cn.modules.shop.collect.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.collect.entity.ShopCollectEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopCollectDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 11:31:58
*/
@Mapper
public interface ShopCollectDao extends BaseMapper<ShopCollectEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopCollectEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopCollectEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopCollectEntity>
    */
    public List<ShopCollectEntity> selectListModel(@Param("e") ShopCollectEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopCollectEntity> 所有符合条件数据
    */
    public List<ShopCollectEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopCollectEntity entity, @Param("ew") Wrapper<ShopCollectEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopCollectEntity> 所有符合条件数据
    */
    public  List<ShopCollectEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopCollectEntity> wrapper);
}
