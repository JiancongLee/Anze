package cn.modules.sys.service.impl;

import cn.common.utils.JwtUtils;
import cn.common.utils.RedisUtils;
import cn.common.utils.Result;
import cn.modules.sys.dao.SysUserTokenDao;
import cn.modules.sys.entity.SysUserTokenEntity;
import cn.modules.sys.service.SysUserTokenService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author dgzhangheng
 */
@Service("sysUserTokenService")
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenDao, SysUserTokenEntity> implements SysUserTokenService {
	/**
	 * 12小时后过期
	 */
	public final static int EXPIRE = 3600 * 3;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private RedisUtils redisUtils;

	@Override
	public Result createToken(long userId) {
		//生成一个token
		String token = jwtUtils.generateToken(userId);

		if (redisUtils.exists(String.valueOf(userId))){
			redisUtils.get(String.valueOf(userId),EXPIRE);
		} else {
			redisUtils.set(String.valueOf(userId),token,EXPIRE);
		}
/*		//当前时间
		Date now = new Date();
		//过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

		//判断是否生成过token
		SysUserTokenEntity tokenEntity = this.selectById(userId);
		if(tokenEntity == null){
			tokenEntity = new SysUserTokenEntity();
			tokenEntity.setUserId(userId);
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);

			//保存token
			this.insert(tokenEntity);
		}else{
			tokenEntity.setToken(token);
			tokenEntity.setUpdateTime(now);
			tokenEntity.setExpireTime(expireTime);
			//更新token
			this.updateById(tokenEntity);
		}*/
		Result r = Result.ok().put("token", token).put("expire", EXPIRE);

		return r;
	}

	@Override
	public void logout(long userId) {
		//生成一个token
	/*	String token = TokenGenerator.generateValue();

		//修改token
		SysUserTokenEntity tokenEntity = new SysUserTokenEntity();
		tokenEntity.setUserId(userId);
		tokenEntity.setToken(token);
		this.updateById(tokenEntity);*/
		redisUtils.delete(String.valueOf(userId));
	}
}
