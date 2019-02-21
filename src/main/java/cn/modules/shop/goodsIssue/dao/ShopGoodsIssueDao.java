package cn.modules.shop.goodsIssue.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import cn.modules.shop.goodsIssue.entity.ShopGoodsIssueEntity;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
* ShopGoodsIssueDao 模型，对应的xml 的一些数据
*
* @author jianconglee
* @date 2019-02-21 22:31:00
*/
@Mapper
public interface ShopGoodsIssueDao extends BaseMapper<ShopGoodsIssueEntity>{


    /**
    * 删除数据
    * @param entity
    * @return Integer
    */
    public Integer deleteByModel(@Param("e") ShopGoodsIssueEntity entity);

    /**
    * 统计数量
    * @param entity 实体对象
    * @return Integer
    */
    public Integer selectCountByModel(@Param("e") ShopGoodsIssueEntity entity);
    /**
    * 查询列表
    * @param entity 实体对象
    * @return  List<ShopGoodsIssueEntity>
    */
    public List<ShopGoodsIssueEntity> selectListModel(@Param("e") ShopGoodsIssueEntity entity);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param entity 实体对象
    * @param wrapper 查询条件
    * @return List<ShopGoodsIssueEntity> 所有符合条件数据
    */
    public List<ShopGoodsIssueEntity> selectPage(@Param("p") Pagination pagination, @Param("e") ShopGoodsIssueEntity entity, @Param("ew") Wrapper<ShopGoodsIssueEntity> wrapper);
    /**
    * 分页查询信息
    * @param pagination 分页信息
    * @param wrapper 查询条件
    * @return List<ShopGoodsIssueEntity> 所有符合条件数据
    */
    public  List<ShopGoodsIssueEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<ShopGoodsIssueEntity> wrapper);
}
