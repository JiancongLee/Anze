package cn.modules.shop.searchHistory.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.searchHistory.entity.ShopSearchHistoryEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopSearchHistoryDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 11:52:35
*/
@Mapper
public interface ShopSearchHistoryDao extends BaseMapper<ShopSearchHistoryEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopSearchHistoryEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopSearchHistoryEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopSearchHistoryEntity>
    */
    public List<ShopSearchHistoryEntity> selectListModel(@Param("e") ShopSearchHistoryEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopSearchHistoryEntity> 所有符合条件数据
    */
    public List<ShopSearchHistoryEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopSearchHistoryEntity entity, @Param("ew") Wrapper<ShopSearchHistoryEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopSearchHistoryEntity> 所有符合条件数据
    */
    public  List<ShopSearchHistoryEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopSearchHistoryEntity> wrapper);
}
