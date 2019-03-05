package cn.modules.base.annex.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.base.annex.entity.BaseAnnexEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* BaseAnnexDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-03-04 12:55:36
*/
@Mapper
public interface BaseAnnexDao extends BaseMapper<BaseAnnexEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") BaseAnnexEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") BaseAnnexEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<BaseAnnexEntity>
    */
    public List<BaseAnnexEntity> selectListModel(@Param("e") BaseAnnexEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<BaseAnnexEntity> 所有符合条件数据
    */
    public List<BaseAnnexEntity> selectPage(@Param("p") Pagination pagination, @Param("e") BaseAnnexEntity entity, @Param("ew") Wrapper<BaseAnnexEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<BaseAnnexEntity> 所有符合条件数据
    */
    public  List<BaseAnnexEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<BaseAnnexEntity> wrapper);
}
