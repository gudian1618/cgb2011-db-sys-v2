package com.github.gudian1618.cgb2011dbsysv2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("doLoginUI")
    public String doLoginUI() {
        return "login";
    }

    @RequestMapping("doIndexUI")
    public String doIndexUI() {
        return "starter";
        // 1.starter会返回给DispatcherServlet对象
        // 2.DispatcherServlet会将viewname交给视图解析器
        // 3.视图解析会在viewname的基础之上添加前缀,后缀并进行解析
        // 4.视图解析器会将解析结果返回给DispatcherServlet
        // 5.DispatcherServlet会将页面响应到客户端
    }

    @RequestMapping("log/log_list")
    public String doLogUI() {
        return "sys/log_list";
    }

    @RequestMapping("menu/menu_list")
    public String doMenuUI() {
        return "sys/menu_list";
    }

    @RequestMapping("doPageUI")
    public String doPageUI() {
        return "common/page";
    }

    /**
     * REST风格的url映射:REST是一种软件架构编码风格,在这种风格下的url定义,
     * 可以使用{变量}的方式让url更加简单通用.
     * 在方法参数中需要url中的{变量}值时,需要使用@PathVariable注解对方法参数进行描述,
     * 并且要求方法参数的名字要与{变量}表达式中的变量名相同
     * @param module
     * @param moduleUI
     * @return
     */
    @RequestMapping("{module}/{moduleUI}")
    public String doModuleUI(@PathVariable String module, @PathVariable String moduleUI) {
        return "sys/" + moduleUI;
    }

}
