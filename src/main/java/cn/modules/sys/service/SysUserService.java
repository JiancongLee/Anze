package cn.modules.sys.service;

import cn.common.utils.PageUtils;
import cn.modules.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;


/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年9月18日 上午9:43:39
 */
public interface SysUserService extends IService<SysUserEntity> {

	PageUtils queryPage(Map<String, Object> params);

	/**
	 * 查询用户的所有权限
	 * @param userId  用户ID
	 */
	List<String> queryAllPerms(Long userId);
	
	/**
	 * 查询用户的所有菜单ID
	 */
	List<Long> queryAllMenuId(Long userId);

	/**
	 * 根据用户名，查询系统用户
	 */
	SysUserEntity queryByUserName(String username);

	/**
	 * 保存用户
	 */
	void save(SysUserEntity user);
	
	/**
	 * 修改用户
	 */
	void update(SysUserEntity user);
	
	/**
	 * 删除用户
	 */
	void deleteBatch(Long[] userIds);

	/**
	 * 修改密码
	 * @param userId       用户ID
	 * @param password     原密码
	 * @param newPassword  新密码
	 */
	boolean updatePassword(Long userId, String password, String newPassword);

	/**
	 * 根据 entity 和部门条件，查询全部记录（并翻页）
	 * @param pagination 分页查询条件
	 * @param model   实体对象封装操作可以为 null）
	 * @param wrapper   SQL包装
	 * @param deptid  部门ID
	 * @return
	 */
	public List<SysUserEntity> selectPageDept(Pagination pagination, SysUserEntity model, Wrapper<SysUserEntity> wrapper, List deptid);
    /**
     * <p>
     * 根据 entity 条件，查询全部记录（并翻页）
     * </p>
     *
     * @param pagination 分页查询条件
     * @param model   实体对象封装操作可以为 null）
     * @param wrapper   SQL包装
     * @return List<SysUserEntity>
     */
    public List<SysUserEntity> selectPage(Pagination pagination, SysUserEntity model, Wrapper<SysUserEntity> wrapper, List roleid);
    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @param pagination 分页查询条件
     * @param wrapper   SQL包装
     * @return List<SysUserEntity>
     */
    public List<SysUserEntity> selectPage(Pagination pagination, Wrapper<SysUserEntity> wrapper);


}
