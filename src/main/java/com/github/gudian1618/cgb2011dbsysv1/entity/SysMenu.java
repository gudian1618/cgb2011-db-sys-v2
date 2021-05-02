package com.github.gudian1618.cgb2011dbsysv1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/30 12:27 下午
 * 持久化对象,与表中字段有映射关系
 */

@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 7576816137803696324L;
    private Integer id;
    /**菜单名称*/
    private String name;
    /**菜单url: log/doFindPageObjects*/
    private String url;
    /**菜单类型(两种:按钮,普通菜单)*/
    private Integer type=1;
    /**排序(序号)*/
    private Integer sort;
    /**备注*/
    private String note;
    /**上级菜单id*/
    private Integer parentId;
    /**菜单对应的权限标识(sys:log:delete)*/
    private String permission;
    /**创建用户*/
    private String createdUser;
    /**修改用户*/
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;

}
