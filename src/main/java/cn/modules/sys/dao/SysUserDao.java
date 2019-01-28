package cn.modules.sys.dao;

import cn.modules.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:34:11
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {
	
	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	

	/**
	 *  查询用户的所有菜单ID
	 * @param userId
	 * @return
	 */
	List<Long> queryAllMenuId(Long userId);





	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);


	/**
	 * 删除数据
	 * @param entity
	 * @return Integer
	 */
	public Integer deleteByModel(@Param("e") SysUserEntity entity);

	/**
	 * 统计数量
	 * @param entity 实体对象
	 * @return Integer
	 */
	public Integer selectCountByModel(@Param("e") SysUserEntity entity);
	/**
	 * 查询列表
	 * @param entity 实体对象
	 * @return  List<SysUserEntity>
	 */
	public List<SysUserEntity> selectListModel(@Param("e") SysUserEntity entity);


	/**
	 * 分页查询信息
	 * @param pagination 分页信息
	 * @param entity 实体对象
	 * @param wrapper 查询条件
	 * @param deptid 部门ID
	 * @return List<SysUserEntity> 所有符合条件数据
	 */
	public List<SysUserEntity> selectPageDept(@Param("p") Pagination pagination, @Param("e") SysUserEntity entity, @Param("ew") Wrapper<SysUserEntity> wrapper, @Param("deptid") List deptid);

	/**
	 * 分页查询信息
	 * @param pagination 分页信息
	 * @param entity 实体对象
	 * @param wrapper 查询条件
	 * @param roleid
	 * @return List<SysUserEntity> 所有符合条件数据
	 */
	public List<SysUserEntity> selectPageRole(@Param("p") Pagination pagination, @Param("e") SysUserEntity entity, @Param("ew") Wrapper<SysUserEntity> wrapper, @Param("roleid") List roleid);
	/**
	 * 分页查询信息
	 * @param pagination 分页信息
	 * @param wrapper 查询条件
	 * @return List<SysUserEntity> 所有符合条件数据
	 */
	public  List<SysUserEntity> queryPage(@Param("p") Pagination pagination, @Param("ew") Wrapper<SysUserEntity> wrapper);


}
