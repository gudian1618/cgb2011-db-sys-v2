package com.github.gudian1618.cgb2011dbsysv2.dao;

import com.github.gudian1618.cgb2011dbsysv2.entity.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/21 9:44 下午
 */

@SpringBootTest
public class SysLogDaoTests {

    @Autowired
    private SysLogDao sysLogDao;

    @Test
    public void testGetRowCount() {
        int rowCount = sysLogDao.getRowCount(null);
        System.out.println("rowCount=" + rowCount);
    }

    @Test
    public void testFindPageObjects() {
        List<SysLog> list = sysLogDao.findPageObjects("admin", 0L, 5);
        for (SysLog log : list) {
            System.out.println(log);
        }
    }

}
