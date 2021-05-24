package com.github.gudian1618.cgb2011dbsysv2.service.impl;

import com.github.gudian1618.cgb2011dbsysv2.common.exception.ServiceException;
import com.github.gudian1618.cgb2011dbsysv2.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv2.common.vo.SysUserDeptVo;
import com.github.gudian1618.cgb2011dbsysv2.dao.SysUserDao;
import com.github.gudian1618.cgb2011dbsysv2.dao.SysUserRoleDao;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysUser;
import com.github.gudian1618.cgb2011dbsysv2.service.SysUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:41 下午
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Override
    public Map<String, Object> findObjectById(Long id) {
        // 1.参数校验
        if (id == null || id < 1) {
            throw new IllegalArgumentException("id值无效");
        }
        // 2.基于id执行查询操作
        SysUserDeptVo user = sysUserDao.findObjectById(id);
        if (user == null) {
            throw new ServiceException("记录可能已经不存在");
        }
        List<Integer> roleIds = sysUserRoleDao.findRoleIdsByUserId(id);
        // 3.封装结果并返回
        Map<String, Object> map = new HashMap<>();
        map.put("user", user);
        map.put("roleIds", roleIds);
        return map;
    }

    @Override
    public int saveObject(SysUser entity, Integer[] roleIds) {
        // 1.参数校验
        if (entity == null) {
            throw new IllegalArgumentException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(entity.getUsername())) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        if (StringUtils.isEmpty(entity.getPassword())) {
            throw new IllegalArgumentException("密码不能为空");
        }
        // 各种正则表达式验证
        if (roleIds == null || roleIds.length == 0) {
            throw new ServiceException("必须为用户制定角色");
        }
        // 2.保存用户信息
        // 2.1. 对密码进行加密(md5盐值加密)
        // md5一种消息摘要算法,第一不可逆,第二相同内容加密结果也相同
        String salt = UUID.randomUUID().toString();
        // String hashedPassword = DigestUtils.md5DigestAsHex((salt + entity.getPassword()).getBytes());
        SimpleHash sh = new SimpleHash("MD5", entity.getPassword(), salt, 1);
        // 将加密结果转换成16进制
        String hashedPassword = sh.toHex();
        entity.setSalt(salt);
        entity.setPassword(hashedPassword);
        // 2.2. 保护用户对象
        int rows = sysUserDao.insertObject(entity);
        // 3.保存用户和角色关系数据
        sysUserRoleDao.insertObjects(entity.getId(), roleIds);
        // 4.返回结果
        return rows;
    }

    @Override
    public int updateObject(SysUser entity, Integer[] roleIds) {
        // 1.参数校验
        if (entity == null) {
            throw new IllegalArgumentException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(entity.getUsername())) {
            throw new IllegalArgumentException("用户名不能为空");
        }
        // 各种正则表达式验证
        if (roleIds == null || roleIds.length == 0) {
            throw new ServiceException("必须为用户制定角色");
        }
        // 2.更新用户信息
        int rows = sysUserDao.updateObject(entity);
        // 3.更新用户和角色关系数据
        // 3.1. 基于原有的用户id删除原有的关系数据
        sysUserRoleDao.deleteObjectsByUserId(entity.getId());
        // 3.2. 查询用户和角色新的关系数据
        sysUserRoleDao.insertObjects(entity.getId(), roleIds);
        // 4.返回结果
        return rows;
    }

    @Override
    public int validById(Long id, Integer valid) {
        // 1.参数校验
        if (id == null || id < 1) {
            throw new IllegalArgumentException("id值无效");
        }
        if (valid != 0 && valid != 1) {
            throw new IllegalArgumentException("状态值不正确");
        }
        // 2.更新状态
        int rows = sysUserDao.validById(id, valid, "admin");
        if (rows == 0) {
            throw new ServiceException("记录可能已经不存在了");
        }
        // 3.返回结果
        return rows;
    }

    @Override
    public PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent) {
        // 1.参数校验
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("当前页码值无效");
        }
        // 2.查询总记录数并校验
        long rowCount = sysUserDao.getRowCount(username);
        if (rowCount == 0) {
            throw new ServiceException("记录不存在");
        }
        // 3.查询当前页记录
        int pageSize = 3;
        long startIndex = (pageCurrent - 1) * pageSize;
        List<SysUserDeptVo> records = sysUserDao.findPageObjects(username, startIndex, pageSize);
        // 4.封装查询结果
        return new PageObject<>(records, rowCount, pageSize, pageCurrent);
    }
}
