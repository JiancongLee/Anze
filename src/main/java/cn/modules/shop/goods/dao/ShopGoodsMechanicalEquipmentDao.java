package cn.modules.shop.goods.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.goods.entity.ShopGoodsMechanicalEquipmentEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopGoodsMechanicalEquipmentDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-28 23:11:49
*/
@Mapper
public interface ShopGoodsMechanicalEquipmentDao extends BaseMapper<ShopGoodsMechanicalEquipmentEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopGoodsMechanicalEquipmentEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopGoodsMechanicalEquipmentEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopGoodsMechanicalEquipmentEntity>
    */
    public List<ShopGoodsMechanicalEquipmentEntity> selectListModel(@Param("e") ShopGoodsMechanicalEquipmentEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopGoodsMechanicalEquipmentEntity> 所有符合条件数据
    */
    public List<ShopGoodsMechanicalEquipmentEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopGoodsMechanicalEquipmentEntity entity, @Param("ew") Wrapper<ShopGoodsMechanicalEquipmentEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopGoodsMechanicalEquipmentEntity> 所有符合条件数据
    */
    public  List<ShopGoodsMechanicalEquipmentEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopGoodsMechanicalEquipmentEntity> wrapper);
}
