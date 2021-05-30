package com.github.gudian1618.cgb2011dbsysv2.common.aspect;

import com.github.gudian1618.cgb2011dbsysv2.common.annotation.RequiredCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
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
        // Object key = "dataKey";
        MethodSignature ms = (MethodSignature) jp.getSignature();
        // 代理方式不同,结果不同.
        // JDK代理获取的是接口
        // Method targetMethod = ms.getMethod();

        Class<?> targetCls = jp.getTarget().getClass();
        Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), ms.getParameterTypes());

        System.out.println("targetMethod=" + targetMethod);

        // 获取目标方法对象上的注解
        RequiredCache requiredCache = targetMethod.getAnnotation(RequiredCache.class);
        String key = requiredCache.key();
        System.out.println("Cache.key=" + key);

        // ================================================

        System.out.println("Get Data from Cache");
        Object result = cache.get(key);
        if (result!=null) {
            return result;
        }
        result = jp.proceed();
        System.out.println("Put Data to Cache");
        cache.put(key, result);
        return result;
    }

}
