package com.github.gudian1618.cgb2011dbsysv2.dao;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.SysUserDeptVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:32 下午
 */

@SpringBootTest
public class SysUserDaoTests {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void testGetRoeCount() {
        long rowCount = sysUserDao.getRowCount("admin");
        System.out.println("rowCount=" + rowCount);
    }

    @Test
    public void testFindObjects() {
        List<SysUserDeptVo> list = sysUserDao.findPageObjects(null, 0, 3);
        for (SysUserDeptVo user : list) {
            System.out.println(user);
        }
    }

}
