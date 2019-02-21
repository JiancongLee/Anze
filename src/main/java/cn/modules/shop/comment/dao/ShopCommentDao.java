package cn.modules.shop.comment.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.comment.entity.ShopCommentEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopCommentDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 23:11:21
*/
@Mapper
public interface ShopCommentDao extends BaseMapper<ShopCommentEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopCommentEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopCommentEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopCommentEntity>
    */
    public List<ShopCommentEntity> selectListModel(@Param("e") ShopCommentEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopCommentEntity> 所有符合条件数据
    */
    public List<ShopCommentEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopCommentEntity entity, @Param("ew") Wrapper<ShopCommentEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopCommentEntity> 所有符合条件数据
    */
    public  List<ShopCommentEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopCommentEntity> wrapper);
}
