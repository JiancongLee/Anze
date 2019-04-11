package cn.modules.security.oauth2;

import cn.common.exception.DefaultException;
import cn.common.utils.JwtUtils;
import cn.common.utils.RedisUtils;
import cn.modules.shop.member.entity.ShopMemberEntity;
import cn.modules.sys.entity.SysUserEntity;
import cn.modules.sys.service.ShiroService;
import com.alibaba.druid.util.StringUtils;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 认证
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-05-20 14:00
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RedisUtils redisUtils;
    /**
     * 12小时后过期
     */
    public final static int EXPIRE = 3600 * 3;

    public static final String USRE = "user";
    public static final String MEMBER = "member";

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {


//        object instanceof class
        if (principals.getPrimaryPrincipal() instanceof SysUserEntity) {
            System.out.println("3333");
        } else if (principals.getPrimaryPrincipal() instanceof ShopMemberEntity){
            System.out.println("4444");
        }


        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        Long userId = user.getUserId();

        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();
        //根据accessToken，查询用户信息
//        SysUserTokenEntity tokenEntity = shiroService.queryByToken(accessToken);
        //token失效
       /* if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }*/
        //查询用户信息

        Claims claims = jwtUtils.getClaimByToken(accessToken);
        if(claims == null ){
            throw new DefaultException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }

        if (!redisUtils.exists(claims.getSubject())){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        } else {
            redisUtils.get(claims.getSubject(),EXPIRE);
        }

        //todo 区分是user表还是member表数据
        String tokenId = claims.getSubject();
        String flag = tokenId.split("_")[0];
        Long id = Long.parseLong(tokenId.split("_")[1]);
        SysUserEntity user = null;
        ShopMemberEntity member = null;

        if (StringUtils.equals(USRE,flag)) {
            user = shiroService.queryUser(id);
        } else if (StringUtils.equals(MEMBER,flag)){
            member = shiroService.queryMember(id);
        }
//        SysUserEntity user = shiroService.queryUser(Long.parseLong(claims.getSubject()));
//        ShopMemberEntity member = shiroService.queryMember(Long.parseLong(claims.getSubject()));

        SimpleAuthenticationInfo info = null;
        if (user != null) {
            //账号锁定
            if(user.getStatus() == 0){
                throw new LockedAccountException("账号已被锁定,请联系管理员");
            } else {
                info = new SimpleAuthenticationInfo(user, accessToken, getName());
            }
        } else if (member != null) {
            info = new SimpleAuthenticationInfo(member, accessToken, getName());
        }
        return info;
    }
}
