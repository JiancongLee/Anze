package cn.modules.shop.member.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.member.entity.ShopMemberEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopMemberDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-19 23:08:44
*/
@Mapper
public interface ShopMemberDao extends BaseMapper<ShopMemberEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopMemberEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopMemberEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopMemberEntity>
    */
    public List<ShopMemberEntity> selectListModel(@Param("e") ShopMemberEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopMemberEntity> 所有符合条件数据
    */
    public List<ShopMemberEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopMemberEntity entity, @Param("ew") Wrapper<ShopMemberEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopMemberEntity> 所有符合条件数据
    */
    public  List<ShopMemberEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopMemberEntity> wrapper);
}
