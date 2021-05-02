package com.github.gudian1618.cgb2011dbsysv1.service.impl;

import com.github.gudian1618.cgb2011dbsysv1.common.exception.ServiceException;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.Node;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysMenuDao;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysRoleMenuDao;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysMenu;
import com.github.gudian1618.cgb2011dbsysv1.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/29 5:40 下午
 */

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public int saveObject(SysMenu entity) {
        // 1.参数校验
        if (entity==null) {
            throw new IllegalArgumentException("保存对象不能为空");
        }
        // 2.保存菜单对象
        int rows = sysMenuDao.insertObject(entity);
        // TODO
        return rows;
    }

    @Override
    public List<Node> findZtreeMenuNodes() {

        return sysMenuDao.findZtreeMenuNodes();
    }

    @Override
    public int deleteObjects(Integer id) {
        // 1.验证数据的合法性
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("清先选择");
        }
        // 2.基于id进行子元素查询
        int count = sysMenuDao.getChildCount(id);
        if (count>0) {
            throw new ServiceException("清先删除子菜单");
        }
        // 3.删除角色,菜单关系数据
        int rows = sysRoleMenuDao.deleteObjectsByMenuId(id);
        // 4.删除菜单元素
        if (rows==0) {
            throw new ServiceException("此菜单可能已经不存在了");
        }
        // 5.返回结果
        return rows;
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        return sysMenuDao.findObjects();
    }
}
