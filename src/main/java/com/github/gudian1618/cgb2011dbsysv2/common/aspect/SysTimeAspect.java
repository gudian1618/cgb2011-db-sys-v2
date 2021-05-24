package com.github.gudian1618.cgb2011dbsysv2.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/24 6:32 下午
 */

@Aspect
@Component
public class SysTimeAspect {

    @Pointcut("bean(sysUserServiceImpl)")
    public void doTime() {}

    @Before("doTime()")
    public void doBefore() {
        System.out.println("@Before");
    }

    @After("doTime()")
    public void doAfter() {
        System.out.println("@After");
    }

    @AfterReturning("doTime()")
    public void doAfterReturning() {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing("doTime()")
    public void doAfterThrowing() {
        System.out.println("@AfterThrowing");
    }

    /**
     * 环绕通知
     * @param jp 连接点对象,ProceedingJoinPoint只能用于环绕通知
     * @return
     * @throws Throwable
     */
    @Around("doTime()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around.before");
        try {
            Object result = jp.proceed();
            System.out.println("around.after");
            return result;
        } catch (Throwable e) {
            System.out.println("around.exception");
            throw e;
        }
    }

}
