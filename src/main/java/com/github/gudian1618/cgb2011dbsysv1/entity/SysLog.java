package com.github.gudian1618.cgb2011dbsysv1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/21 8:27 下午
 * pojo对象实体类
 */

@Data
public class SysLog implements Serializable {

    private static final long serialVersionUID = -8948267298680796389L;
    /** 用户id */
    private Long id;
    /** 用户名 */
    private String username;
    /** 用户操作 */
    private String operation;
    /** 请求方法 */
    private String method;
    // 请求参数
    private String params;
    // 执行时长(毫秒)
    private Long time;
    // IP地址
    private String ip;
    // 创建时间
    private Date createdTime;


}
