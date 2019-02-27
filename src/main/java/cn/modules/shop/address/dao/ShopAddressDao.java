package cn.modules.shop.address.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.address.entity.ShopAddressEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopAddressDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 12:53:46
*/
@Mapper
public interface ShopAddressDao extends BaseMapper<ShopAddressEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopAddressEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopAddressEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopAddressEntity>
    */
    public List<ShopAddressEntity> selectListModel(@Param("e") ShopAddressEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopAddressEntity> 所有符合条件数据
    */
    public List<ShopAddressEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopAddressEntity entity, @Param("ew") Wrapper<ShopAddressEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopAddressEntity> 所有符合条件数据
    */
    public  List<ShopAddressEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopAddressEntity> wrapper);
    /**
     *
     * @param entity
     * @return
     */
    public ShopAddressEntity selectInfo(@Param("e") ShopAddressEntity entity);
}
