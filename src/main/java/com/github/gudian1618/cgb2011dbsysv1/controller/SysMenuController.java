package com.github.gudian1618.cgb2011dbsysv1.controller;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv1.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/29 5:53 下午
 */

// @Controller
// @ResponseBody

@RestController
@RequestMapping("/menu/")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects() {
        return new JsonResult(sysMenuService.findObjects());
    }

}
