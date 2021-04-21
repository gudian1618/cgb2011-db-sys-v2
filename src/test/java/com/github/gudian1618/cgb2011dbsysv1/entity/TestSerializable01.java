package com.github.gudian1618.cgb2011dbsysv1.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.Date;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/21 8:38 下午
 */

@SpringBootTest
public class TestSerializable01 {

    @Test
    public void testSerializable() throws IOException {
        SysLog log = new SysLog();
        log.setId(100L);
        log.setIp("192.168.1.1");
        log.setUsername("admin");
        log.setOperation("update");
        log.setMethod("xx.deleteObject");
        log.setParams("1");
        log.setTime(10L);
        log.setCreatedTime(new Date());
        // 将log对象序列化
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("f1.txt")));
        out.writeObject(log);
        out.close();
        System.out.println("序列化ok");

    }

    @Test
    public void testDeserialize() throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("f1.txt")));
        Object obj = in.readObject();
        System.out.println(obj);
        in.close();

    }

}
