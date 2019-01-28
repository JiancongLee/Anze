package cn.modules.sys.service.impl;

import cn.common.constant.Constant;
import cn.common.utils.RedisUtils;
import cn.modules.sys.dao.SysMenuDao;
import cn.modules.sys.dao.SysUserDao;
import cn.modules.sys.dao.SysUserTokenDao;
import cn.modules.sys.entity.SysMenuEntity;
import cn.modules.sys.entity.SysUserEntity;
import cn.modules.sys.entity.SysUserTokenEntity;
import cn.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import static cn.modules.sys.service.impl.SysUserTokenServiceImpl.EXPIRE;


@Service
public class ShiroServiceImpl implements ShiroService {

    public static final String USRE_PIX = "user_";

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysUserTokenDao sysUserTokenDao;

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;

        //系统管理员，拥有最高权限
        if(userId == Constant.SUPER_ADMIN){
            List<SysMenuEntity> menuList = sysMenuDao.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(SysMenuEntity menu : menuList){
                permsList.add(menu.getPerms());
            }
        }else{
            permsList = sysUserDao.queryAllPerms(userId);
        }
        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for(String perms : permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

    @Override
    public SysUserTokenEntity queryByToken(String token) {
        return sysUserTokenDao.queryByToken(token);
    }

    @Override
    public SysUserEntity queryUser(Long userId) {

        SysUserEntity entity = null;
        if (!redisUtils.exists(USRE_PIX + userId)){
            entity = sysUserDao.selectById(userId);
            redisUtils.set(USRE_PIX + userId, entity, EXPIRE);
        } else {

            entity = redisUtils.get(USRE_PIX + userId, SysUserEntity.class, EXPIRE);
        }
        return entity;
    }
}
