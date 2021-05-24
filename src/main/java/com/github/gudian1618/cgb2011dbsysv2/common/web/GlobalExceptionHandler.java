package com.github.gudian1618.cgb2011dbsysv2.common.web;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/24 10:10 下午
 * 全局类
 * @ControllerAdvice 注解描述的类为springmvc中的一个全局异常处理类
 * 此类中可以定义多个全局异常处理方法,这些方法需要@ExceptionHandler注解进行修饰,
 * @ExceptionHandler 这个注解中定义的异常类型为此方法可以处理的异常类型
 * 局部异常类的异常处理方法优先级更高,覆盖全局异常类的异常处理方法
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    // 此处相当于方法的重载
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(IllegalArgumentException e) {
        System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
        e.printStackTrace();
        // 封装异常信息
        return new JsonResult(e);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        System.out.println("GlobalExceptionHandler.doHandleRuntimeException");
        e.printStackTrace();
        // 封装异常信息
        return new JsonResult(e);
    }

}
