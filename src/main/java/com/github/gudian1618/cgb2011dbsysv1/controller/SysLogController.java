package com.github.gudian1618.cgb2011dbsysv1.controller;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysLog;
import com.github.gudian1618.cgb2011dbsysv1.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/24 9:35 下午
 */

@Controller
@RequestMapping("/log/")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    // http://localhost/log/doDeleteObjects?ids=1,2,3
    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(int... ids) {
        sysLogService.deleteObjects(ids);
        return new JsonResult("delete ok");
    }

    // http://localhost/log/doFindPageObjects?pageCurrent=1
    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult doFindPageObjects(String username, Long pageCurrent) {
        PageObject<SysLog> pageObject = sysLogService.findPageObjects(username, pageCurrent);
        // JsonResult jsonResult = new JsonResult();
        // jsonResult.setData(pageObject);
        return new JsonResult(pageObject);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException e) {
        System.out.println("SysLogController.doHandleRuntimeException");
        e.printStackTrace();
        return new JsonResult(e);
    }
}

