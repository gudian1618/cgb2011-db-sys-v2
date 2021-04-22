package com.github.gudian1618.cgb2011dbsysv1.service;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/22 10:27 下午
 */

@SpringBootTest
public class SysLogServiceTests {

    @Autowired
    private SysLogService sysLogService;

    @Test
    public void testFindPageObjects() {
        PageObject<SysLog> pageObject = sysLogService.findPageObjects("admin", 3L);
    }

}
