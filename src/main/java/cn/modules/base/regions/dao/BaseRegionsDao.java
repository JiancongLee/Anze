package cn.modules.base.regions.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.base.regions.entity.BaseRegionsEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* BaseRegionsDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-26 21:19:23
*/
@Mapper
public interface BaseRegionsDao extends BaseMapper<BaseRegionsEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") BaseRegionsEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") BaseRegionsEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<BaseRegionsEntity>
    */
    public List<BaseRegionsEntity> selectListModel(@Param("e") BaseRegionsEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<BaseRegionsEntity> 所有符合条件数据
    */
    public List<BaseRegionsEntity> selectPage(@Param("p") Pagination pagination, @Param("e") BaseRegionsEntity entity, @Param("ew") Wrapper<BaseRegionsEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<BaseRegionsEntity> 所有符合条件数据
    */
    public  List<BaseRegionsEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<BaseRegionsEntity> wrapper);
}
