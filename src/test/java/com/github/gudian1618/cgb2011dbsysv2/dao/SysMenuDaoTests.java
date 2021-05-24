package com.github.gudian1618.cgb2011dbsysv2.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/29 5:12 下午
 */

@SpringBootTest
public class SysMenuDaoTests {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Test
    public void testFindObjects() {
        List<Map<String, Object>> list = sysMenuDao.findObjects();
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
        System.out.println(list.size());
    }

}
