package com.github.gudian1618.cgb2011dbsysv1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/20 8:25 下午
 * http://localhost/doIndexUI
 */

@RequestMapping("/")
@Controller
public class PageController {

    @RequestMapping("doIndexUI")
    public String doIndexUI() {
        return "starter";
        // 1.starter会返回给DispatcherServlet对象
        // 2.DispatcherServlet会将viewname交给视图解析器
        // 3.视图解析会在viewname的基础之上添加前缀,后缀并进行解析
        // 4.视图解析器会将解析结果返回给DispatcherServlet
        // 5.DispatcherServlet会将页面响应到客户端
    }

}
