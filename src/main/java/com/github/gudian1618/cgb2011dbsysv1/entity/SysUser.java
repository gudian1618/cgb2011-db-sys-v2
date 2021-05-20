package com.github.gudian1618.cgb2011dbsysv1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/20 8:12 下午
 */

@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = -8575736934181928744L;
    private Integer id;
    private String username;
    private String password;
    private String salt;//盐值
    private String email;
    private String mobile;
    private Integer valid=1;
    private Integer deptId;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
