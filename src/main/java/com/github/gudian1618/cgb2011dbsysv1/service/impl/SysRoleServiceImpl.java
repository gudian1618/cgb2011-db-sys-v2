package com.github.gudian1618.cgb2011dbsysv1.service.impl;

import com.github.gudian1618.cgb2011dbsysv1.common.exception.ServiceException;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysRoleDao;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysRole;
import com.github.gudian1618.cgb2011dbsysv1.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
