package cn.modules.shop.keywords.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.keywords.entity.ShopKeywordsEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopKeywordsDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 22:50:43
*/
@Mapper
public interface ShopKeywordsDao extends BaseMapper<ShopKeywordsEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopKeywordsEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopKeywordsEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopKeywordsEntity>
    */
    public List<ShopKeywordsEntity> selectListModel(@Param("e") ShopKeywordsEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopKeywordsEntity> 所有符合条件数据
    */
    public List<ShopKeywordsEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopKeywordsEntity entity, @Param("ew") Wrapper<ShopKeywordsEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopKeywordsEntity> 所有符合条件数据
    */
    public  List<ShopKeywordsEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopKeywordsEntity> wrapper);
}
