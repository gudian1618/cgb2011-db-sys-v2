package com.github.gudian1618.cgb2011dbsysv1.service.impl;

import com.github.gudian1618.cgb2011dbsysv1.common.exception.ServiceException;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysRoleDao;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysRoleMenuDao;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysRole;
import com.github.gudian1618.cgb2011dbsysv1.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/16 10:14 下午
 */

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public int saveObject(SysRole entity, Integer[] menuIds) {
        // 1.参数校验
        if (entity==null) {
            throw new IllegalArgumentException("保存对象不能为空");
        }
        if (StringUtils.isEmpty(entity.getName())) {
            throw new IllegalArgumentException("角色名不能为空");
        }
        if (menuIds==null||menuIds.length==0) {
            throw new IllegalArgumentException("必须为角色授权权限");
        }
        // 2.保存数据
        // 2.1.保存角色自身信息
        int rows = sysRoleDao.insertObject(entity);
        // 2.2.保存角色额菜单关系数据
        sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
        return rows;
    }

    @Override
    public int deleteObject(Integer id) {
        // 1.参数校验
        if (id==null||id<1) {
            throw new IllegalArgumentException("参数值不正确");
        }
        // 2.删除数据
        sysRoleMenuDao.deleteObjectsByRoleId(id);
        // 2.1 删除角色菜单关系数据

        // 2.2 删除用户角色关系数据

        // 2.3 删除角色自身信息
        return 0;
    }

    @Override
    public PageObject<SysRole> findPageObjects(String name, Long pageCurrent) {
        // 1.参数校验
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("页码值不正确");
        }
        // 2.查询总记录数并进行判断
        long rowCount = sysRoleDao.getRowCount(name);
        if (rowCount == 0) {
            throw new ServiceException("没有查询到记录");
        }
        // 3.查询当前页记录
        int pageSize = 3;
        long startIndex = (pageCurrent - 1) * pageSize;
        List<SysRole> records = sysRoleDao.findPageObjects(name, startIndex, pageSize);
        // 4.封装查询结果
        return new PageObject<>(records, rowCount, pageSize, pageCurrent);
    }
}
