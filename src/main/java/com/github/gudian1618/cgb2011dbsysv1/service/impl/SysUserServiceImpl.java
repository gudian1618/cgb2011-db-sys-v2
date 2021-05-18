package com.github.gudian1618.cgb2011dbsysv1.service.impl;

import com.github.gudian1618.cgb2011dbsysv1.common.exception.ServiceException;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.SysUserDeptVo;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysUserDao;
import com.github.gudian1618.cgb2011dbsysv1.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:41 下午
 */

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent) {
        // 1.参数校验
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("当前页码值无效");
        }
        // 2.查询总记录数并校验
        long rowCount = sysUserDao.getRowCount(username);
        if (rowCount==0) {
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
