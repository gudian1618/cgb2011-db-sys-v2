package com.github.gudian1618.cgb2011dbsysv2.service.impl;

import com.github.gudian1618.cgb2011dbsysv2.common.exception.ServiceException;
import com.github.gudian1618.cgb2011dbsysv2.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv2.dao.SysLogDao;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysLog;
import com.github.gudian1618.cgb2011dbsysv2.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * @Async 描述的方法会运行在一个异步线程中
     * @param entity
     */
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void saveObject(SysLog entity) {
        String tName = Thread.currentThread().getName();
        System.out.println("SysLogServiceImpl.saveObject-->" + tName);
        // ...
        // 模拟写日志操作
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sysLogDao.insertObject(entity);
    }

    @Override
    public int deleteObjects(int... ids) {
        if (ids == null || ids.length == 0) {
            throw new IllegalArgumentException("请选择");
        }
        int rows = sysLogDao.deleteObjects(ids);
        if (rows == 0) {
            throw new ServiceException("记录可能已经不存在");
        }

        // 统一aop监控异常处理
        // int rows = 0;
        // try {
        //     rows = sysLogDao.deleteObjects(ids);
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     // 给运维人员通知,告警(电话,邮件,短信)
        //     throw new ServiceException("服务端维护中,稍等片刻访问");
        // }

        return rows;
    }

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
        int pageSize = 10;
        long startIndex = (pageCurrent - 1) * pageSize;
        List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
        // 4.对查询结果进行封装
        return new PageObject(records, rowCount, pageSize, pageCurrent);
    }
}
