package com.github.gudian1618.cgb2011dbsysv2.controller;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.JsonResult;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysDept;
import com.github.gudian1618.cgb2011dbsysv2.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/4 8:36 下午
 */

@RestController
@RequestMapping("/dept/")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;
    @RequestMapping("doFindObjects")
    public JsonResult doFindObjects() {
        return new JsonResult(sysDeptService.findObjects());
    }
    @RequestMapping("doFindZTreeNodes")
    public JsonResult doFindZTreeNodes() {
        return new JsonResult(sysDeptService.findZTreeNodes());
    }

    @RequestMapping("doUpdateObject")
    public JsonResult doUpdateObject(SysDept entity){
        sysDeptService.updateObject(entity);
        return new JsonResult("update ok");
    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObject(SysDept entity){
        sysDeptService.saveObject(entity);
        return new JsonResult("save ok");
    }
    @RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id){
        sysDeptService.deleteObject(id);
        return new JsonResult("delete ok");
    }

}
