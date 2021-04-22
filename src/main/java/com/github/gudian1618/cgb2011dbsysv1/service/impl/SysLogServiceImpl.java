package com.github.gudian1618.cgb2011dbsysv1.service.impl;

import com.github.gudian1618.cgb2011dbsysv1.common.exception.ServiceException;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysLogDao;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysLog;
import com.github.gudian1618.cgb2011dbsysv1.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/22 9:59 下午
 */

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public PageObject<SysLog> findPageObjects(String username, Long pageCurrent) {
        // 1.参数校验
        if (pageCurrent == null || pageCurrent < 1) {
            throw new IllegalArgumentException("页码值不正确");
        }
        // 2.查询总记录数并校验
        long rowCount = sysLogDao.getRowCount(username);
        if (rowCount == 0) {
            // throw new NoSuchElementException("没有查找到对应的记录");
            throw new ServiceException("没有查找到对应的记录");
        }
        // 3.查询当前页记录
        int pageSize = 3;
        long startIndex = (pageCurrent - 1) * pageSize;
        List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
        // 4.对查询结果进行封装
        return new PageObject(records, rowCount, pageSize, pageCurrent);
    }
}
