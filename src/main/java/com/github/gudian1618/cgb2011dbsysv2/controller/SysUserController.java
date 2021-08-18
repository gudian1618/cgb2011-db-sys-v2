package com.github.gudian1618.cgb2011dbsysv2.controller;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysUser;
import com.github.gudian1618.cgb2011dbsysv2.service.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:57 下午
 */

@RestController
@RequestMapping("/user/")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("doLogin")
    public JsonResult doLogin(String username, String password, boolean isRememberMe) {
        // 1.获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 2.提交用户请求
        UsernamePasswordToken token = new UsernamePasswordToken();
        token.setUsername(username);
        token.setPassword(password.toCharArray());
        // if (isRememberMe != null) {
        //     token.setRememberMe(isRememberMe);
        // }
        token.setRememberMe(isRememberMe);
        subject.login(token);
        return new JsonResult("login ok");
    }

    @RequestMapping("doFindObjectById")
    public JsonResult doFindObjectById(Long id) {
        return new JsonResult(sysUserService.findObjectById(id));
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysUser entity, Integer[] roleIds) {
        sysUserService.saveObject(entity, roleIds);
        return new JsonResult("save ok");
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysUser entity, Integer[] roleIds) {
        sysUserService.updateObject(entity, roleIds);
        return new JsonResult("update ok");
    }

    @RequestMapping("doValidById")
    public JsonResult doValidById(Long id, Integer valid) {
        sysUserService.validById(id, valid);
        return new JsonResult("update ok");
    }

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String username, Long pageCurrent) {
        return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
    }

}
