package com.github.gudian1618.cgb2011dbsysv2.common.aspect;

import com.github.gudian1618.cgb2011dbsysv2.common.annotation.RequiredLog;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysLog;
import com.github.gudian1618.cgb2011dbsysv2.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

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
     * @Pointcut 此注解一般用于描述方法, 在方法上定义切入点
     * bean(sysUserServiceImpl) 为一个切入点表达式
     */
    // @Pointcut("bean(*ServiceImpl)")
    @Pointcut("@annotation(com.github.gudian1618.cgb2011dbsysv2.common.annotation.RequiredLog)")
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
            // 将用户的正常行为写入到数据库中
            saveLog(jp, t2 - t1);
            return result;
        } catch (Throwable e) {
            log.error("error is {}", e.getMessage());
            throw e;
        }
        // 出现异常时还要输出错误日志
    }

    @Autowired
    private SysLogService sysLogService;

    private void saveLog(ProceedingJoinPoint jp, long time) throws NoSuchMethodException {
        // 1.获取用户行为数据
        // 获取目标方法所在类的类型
        Class<?> targetCls = jp.getTarget().getClass();
        String targetClsName = targetCls.getName();
        MethodSignature ms = (MethodSignature) jp.getSignature();
        // 获取目标类中的目标方法信息
        String targetClsMethodName = targetClsName + "." + ms.getName();

        // 获取操作名operation
        Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
        RequiredLog requiredLog = targetMethod.getAnnotation(RequiredLog.class);
        String operation = "operation";
        if (requiredLog!=null) {
            operation = requiredLog.operation();
        }

        // 获取调用目标方法时传递的参数
        String params = Arrays.toString(jp.getArgs());
        // 2.封装用户息行为数据
        SysLog entity = new SysLog();
        entity.setIp("192.168.1.1");
        entity.setUsername("admin");
        entity.setOperation(operation);
        entity.setMethod(targetClsMethodName);
        entity.setParams(params);
        entity.setTime(time);
        entity.setCreatedTime(new Date());
        // 3.保存用户行为数据(写入到数据库中)
        sysLogService.saveObject(entity);
    }

}
