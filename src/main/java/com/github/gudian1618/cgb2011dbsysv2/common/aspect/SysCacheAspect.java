package com.github.gudian1618.cgb2011dbsysv2.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/24 8:52 下午
 */

@Aspect
@Component
public class SysCacheAspect {

    private Map<Object, Object> cache = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.github.gudian1618.cgb2011dbsysv2.common.annotation.RequiredCache)")
    public void doCache() {}

    @Pointcut("@annotation(com.github.gudian1618.cgb2011dbsysv2.common.annotation.ClearCache)")
    public void doClear() {}

    /**
     * 正常业务执行之后执行
     */
    @AfterReturning("doClear()")
    public void doAfterReturning() {
        cache.clear();
    }

    @Around("doCache()")
    public Object doAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("Get Data from Cache");
        Object result = cache.get("data");
        if (result!=null) {
            return result;
        }
        result = jp.proceed();
        System.out.println("Put Data to Cache");
        cache.put("dataKey", result);
        return result;
    }

}
