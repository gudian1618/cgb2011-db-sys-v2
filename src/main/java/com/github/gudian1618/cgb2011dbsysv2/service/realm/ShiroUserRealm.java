package com.github.gudian1618.cgb2011dbsysv2.service.realm;

import com.github.gudian1618.cgb2011dbsysv2.dao.SysUserDao;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/8/4 8:49 下午
 */

@Service
public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 基于此方法的返回值告诉shiro框架我们采用什么加密算法
     *
     * @return
     */
    @Override
    public CredentialsMatcher getCredentialsMatcher() {
        HashedCredentialsMatcher cMatcher = new HashedCredentialsMatcher();
        cMatcher.setHashAlgorithmName("MD5");
        cMatcher.setHashIterations(1);
        return cMatcher;
    }

    /**
     * 此方法中负责认证信息的获取以及封装
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 1.获取登录用户信息(页面上用户输入的用户名)
        UsernamePasswordToken uToken = (UsernamePasswordToken) authenticationToken;
        // 2.基于用户名查询数据库获取对象信息并进行判定
        String username = uToken.getUsername();
        // 2.1.获取用户对象
        SysUser user = sysUserDao.findUserByUserName(username);
        // 2.2.验证对象是否存在
        if (user==null) {
            throw new UnknownAccountException();
        }
        // 2.3.检查用户是否被禁用
        if (user.getValid()==0) {
            throw new LockedAccountException();
        }
        // 3.封装用户信息并返回
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt().getBytes());
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
            user,   // 用户身份
            user.getPassword(),   // 已经加密的密码
            credentialsSalt,       // 盐值随机加密
            this.getName()
        );
        // 返回给认证管理器
        return info;
    }
}
