package cn.modules.sys.dao;

import cn.modules.sys.entity.BatchBaseinfoAttachEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* BatchBaseinfoAttachDao 模型，对应的xml 的一些数据
*
* @author zhangheng
* @date 2018-10-31 17:22:02
*/
@Mapper
public interface BatchBaseinfoAttachDao extends BaseMapper<BatchBaseinfoAttachEntity> {


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") BatchBaseinfoAttachEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") BatchBaseinfoAttachEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<BatchBaseinfoAttachEntity>
    */
    public List<BatchBaseinfoAttachEntity> selectListModel(@Param("e") BatchBaseinfoAttachEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<BatchBaseinfoAttachEntity> 所有符合条件数据
    */
    public List<BatchBaseinfoAttachEntity> selectPage(@Param("p") Pagination pagination, @Param("e") BatchBaseinfoAttachEntity entity, @Param("ew") Wrapper<BatchBaseinfoAttachEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<BatchBaseinfoAttachEntity> 所有符合条件数据
    */
    public  List<BatchBaseinfoAttachEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<BatchBaseinfoAttachEntity> wrapper);
}
