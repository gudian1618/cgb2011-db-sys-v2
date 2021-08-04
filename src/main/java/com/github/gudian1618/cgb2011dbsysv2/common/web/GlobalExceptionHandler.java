package com.github.gudian1618.cgb2011dbsysv2.common.web;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.JsonResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

// @ControllerAdvice
// @ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ShiroException.class)
    // @ResponseBody
    public JsonResult doHandleShiroException(
        ShiroException e) {
        JsonResult r = new JsonResult();
        r.setState(0);
        if (e instanceof UnknownAccountException) {
            r.setMessage("账户不存在");
        } else if (e instanceof LockedAccountException) {
            r.setMessage("账户已被禁用");
        } else if (e instanceof IncorrectCredentialsException) {
            r.setMessage("密码不正确");
        } else if (e instanceof AuthorizationException) {
            r.setMessage("没有此操作权限");
        } else {
            r.setMessage("系统维护中");
        }
        e.printStackTrace();
        return r;
    }

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
