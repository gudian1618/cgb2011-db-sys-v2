package com.github.gudian1618.cgb2011dbsysv2.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/24 7:19 下午
 */

@Slf4j
@Aspect
@Component
public class SysExceptionAspect {

    /**
     * 通过如下方法进行异常信息的记录,但不会截断异常
     * @param ex
     */
    @AfterThrowing(value = "bean(sysUserServiceImpl)", throwing = "ex")
    public void doLogError(JoinPoint jp, Exception ex) throws NoSuchMethodException {
        // 获取目标方法签名
        MethodSignature ms = (MethodSignature) jp.getSignature();
        // String methodName = ms.getDeclaringTypeName() + "." + ms.getName();
        Class<?> targetClass = jp.getTarget().getClass();
        Method targetMethod = targetClass.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
        String methodName = targetClass.getName() + "." + targetMethod.getName();
        // log.error("SysExceptionAspect ---> {}'s exception {}", methodName, ex.getMessage());
        log.error("SysExceptionAspect ---> {}'s exception {}", methodName, ex.getMessage());
    }

}
