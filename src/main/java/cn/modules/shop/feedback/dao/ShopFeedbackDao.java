package cn.modules.shop.feedback.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.feedback.entity.ShopFeedbackEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopFeedbackDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 22:41:09
*/
@Mapper
public interface ShopFeedbackDao extends BaseMapper<ShopFeedbackEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopFeedbackEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopFeedbackEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopFeedbackEntity>
    */
    public List<ShopFeedbackEntity> selectListModel(@Param("e") ShopFeedbackEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopFeedbackEntity> 所有符合条件数据
    */
    public List<ShopFeedbackEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopFeedbackEntity entity, @Param("ew") Wrapper<ShopFeedbackEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopFeedbackEntity> 所有符合条件数据
    */
    public  List<ShopFeedbackEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopFeedbackEntity> wrapper);
}
