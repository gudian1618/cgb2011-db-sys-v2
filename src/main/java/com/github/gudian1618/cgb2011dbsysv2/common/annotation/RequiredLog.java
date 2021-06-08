package com.github.gudian1618.cgb2011dbsysv2.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/6/8 8:12 下午
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequiredLog {
    String operation() default "operation";
}
