package com.github.gudian1618.cgb2011dbsysv1.controller;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv1.service.SysUserService;
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
