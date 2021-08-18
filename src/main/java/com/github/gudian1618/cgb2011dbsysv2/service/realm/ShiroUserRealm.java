package com.github.gudian1618.cgb2011dbsysv2.service.realm;

import com.github.gudian1618.cgb2011dbsysv2.dao.SysMenuDao;
import com.github.gudian1618.cgb2011dbsysv2.dao.SysRoleMenuDao;
import com.github.gudian1618.cgb2011dbsysv2.dao.SysUserDao;
import com.github.gudian1618.cgb2011dbsysv2.dao.SysUserRoleDao;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysUser;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/8/4 8:49 下午
 */

@Service
public class ShiroUserRealm extends AuthorizingRealm {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * 负责获取登录用户的权限信息并进行封装
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("==doGetAuthorizationInfo==");
        // 1.获取登录用户身份信息
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        // 2.基于用户id获取角色id
        List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(user.getId());
        if (roleIds == null || roleIds.size() == 0) {
            throw new AuthorizationException();
        }
        Integer[] array = {};
        // 3.基于角色id获取对应的菜单id
        List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleIds(roleIds.toArray(array));
        if (menuIds == null || menuIds.size() == 0) {
            throw new AuthorizationException();
        }
        // 4.基于菜单id获取授权标识
        List<String> permissions = sysMenuDao.findPermissions(menuIds.toArray(array));
        if (permissions == null || permissions.size() == 0) {
            throw new AuthorizationException();
        }
        // 5.对用户权限信息进行封装
        Set<String> stringPermissions = new HashSet<>();
        for (String per : permissions) {
            if (!StringUtils.isEmpty(per)) {
                stringPermissions.add(per);
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(stringPermissions);
        // 此对象会返回给SecurityManager
        return info;
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
        if (user == null) {
            throw new UnknownAccountException();
        }
        // 2.3.检查用户是否被禁用
        if (user.getValid() == 0) {
            throw new LockedAccountException();
        }
        // 3.封装用户信息并返回
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
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
