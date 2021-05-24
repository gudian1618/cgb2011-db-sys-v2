package com.github.gudian1618.cgb2011dbsysv2.controller;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysMenu;
import com.github.gudian1618.cgb2011dbsysv2.service.SysMenuService;
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

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysMenu entity) {
        sysMenuService.updateObject(entity);
        return new JsonResult(entity);
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysMenu entity) {
        sysMenuService.saveObject(entity);
        return new JsonResult(entity);
    }

    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult doFindZtreeMenuNodes() {
        return new JsonResult(sysMenuService.findZtreeMenuNodes());
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        sysMenuService.deleteObjects(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects() {
        return new JsonResult(sysMenuService.findObjects());
    }

}
