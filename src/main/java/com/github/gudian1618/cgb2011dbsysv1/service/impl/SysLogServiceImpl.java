package com.github.gudian1618.cgb2011dbsysv1.service.impl;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysLogDao;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysLog;
import com.github.gudian1618.cgb2011dbsysv1.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PageObject<SysLog> findPageObjects(String username, String pageCurrent) {
        // 1.参数校验
        
        // 2.查询总记录数并校验

        // 3.查询当前页记录

        // 4.对查询结果进行封装

        return null;
    }
}
