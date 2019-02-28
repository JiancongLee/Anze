package cn.modules.shop.goods.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.goods.entity.ShopGoodsFoodEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopGoodsFoodDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-28 23:07:20
*/
@Mapper
public interface ShopGoodsFoodDao extends BaseMapper<ShopGoodsFoodEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopGoodsFoodEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopGoodsFoodEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopGoodsFoodEntity>
    */
    public List<ShopGoodsFoodEntity> selectListModel(@Param("e") ShopGoodsFoodEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopGoodsFoodEntity> 所有符合条件数据
    */
    public List<ShopGoodsFoodEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopGoodsFoodEntity entity, @Param("ew") Wrapper<ShopGoodsFoodEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopGoodsFoodEntity> 所有符合条件数据
    */
    public  List<ShopGoodsFoodEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopGoodsFoodEntity> wrapper);
}
