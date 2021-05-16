package com.github.gudian1618.cgb2011dbsysv1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/16 9:58 下午
 */

@Data
public class SysRole implements Serializable {

    private static final long serialVersionUID = 4890507590685458386L;
    private Integer id;
    private String name;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
