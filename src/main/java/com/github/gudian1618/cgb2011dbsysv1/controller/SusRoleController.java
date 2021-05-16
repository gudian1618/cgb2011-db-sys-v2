package com.github.gudian1618.cgb2011dbsysv1.controller;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv1.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/16 10:36 下午
 */

@RestController
@RequestMapping("/role/")
public class SusRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name, Long pageCurrent) {
        return new JsonResult(sysRoleService.findPageObjects(name, pageCurrent));
    }

}
