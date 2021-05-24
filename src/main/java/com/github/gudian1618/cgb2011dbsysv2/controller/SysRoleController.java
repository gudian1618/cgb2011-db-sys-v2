package com.github.gudian1618.cgb2011dbsysv2.controller;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysRole;
import com.github.gudian1618.cgb2011dbsysv2.service.SysRoleService;
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
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("doFindRoles")
    public JsonResult doFindObjects() {
        return new JsonResult(sysRoleService.findObjects());
    }

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Integer id) {
        return new JsonResult(sysRoleService.findObjectById(id));
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysRole entity, Integer[] menuIds) {
        sysRoleService.saveObject(entity, menuIds);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysRole entity, Integer[] menuIds) {
        sysRoleService.saveObject(entity, menuIds);
        return new JsonResult("update ok");
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id) {
        sysRoleService.deleteObject(id);
        return new JsonResult("delete ok");
    }

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name, Long pageCurrent) {
        return new JsonResult(sysRoleService.findPageObjects(name, pageCurrent));
    }

}
