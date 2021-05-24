package com.github.gudian1618.cgb2011dbsysv2.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/22 9:46 下午
 */

@SpringBootTest
public class TestIntegerPool01 {

    @Test
    public void testIntegerCache() {
        Integer t1 = 100;
        Integer t2 = 100;

        // 对于Integer类有一个整数池(-128~127)
        System.out.println(t1 == t2);
        Integer t3 = 200;
        Integer t4 = 200;
        System.out.println(t3 == t4);
    }

    @Test
    public void testLongCache() {
        Long t1 = 100L;
        Long t2 = 100L;

        // 对于Long类有一个长整数池
        System.out.println(t1 == t2);
        Long t3 = 200L;
        Long t4 = 200L;
        System.out.println(t3 == t4);
    }

}
