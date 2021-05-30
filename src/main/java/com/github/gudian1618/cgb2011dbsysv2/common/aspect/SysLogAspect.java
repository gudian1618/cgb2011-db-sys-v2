package com.github.gudian1618.cgb2011dbsysv2.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/24 5:07 下午
 * @Aspect 注解描述的类型为一个切面类型(AOP中的横切面类型),
 * 这样的切面通常会定义两部分内容:
 * 1.切入点: 切入扩展功能的点(例如一个业务对象中的一个或多个方法,或者多个业务对象中的一系列方法)
 * 2.通知: 在切入点对象的方法执行时,要织入的扩展功能
 */

@Order(1)
@Aspect
@Slf4j
@Component
public class SysLogAspect {

    /**
     * @Pointcut 此注解一般用于描述方法,在方法上定义切入点
     * bean(sysUserServiceImpl) 为一个切入点表达式
     */
    @Pointcut("bean(sysUserServiceImpl)")
    public void doPointCut() {
        // 方法内部不需要写任何内容
    }

    @Around("doPointCut()")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("SysLogAspect.around");
        // 记录方法执行时的开始时间
        long t1 = System.currentTimeMillis();
        try {
            // 调用目标方法
            // 调用本切面中其他通知或下一个切面的通知或目标方法
            Object result = jp.proceed();
            // 记录方法执行的结束时间以及总时长
            long t2 = System.currentTimeMillis();
            log.info("method execute time{}", (t2 - t1));
            return result;
        } catch (Throwable e) {
            log.error("error is {}", e.getMessage());
            throw e;
        }
        // 出现异常时还要输出错误日志
    }

}
