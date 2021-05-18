package com.github.gudian1618.cgb2011dbsysv1.common.vo;

import com.github.gudian1618.cgb2011dbsysv1.entity.SysDept;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:06 下午
 */

@Data
public class SysUserDeptVo implements Serializable {

    private static final long serialVersionUID = -4936905170185229394L;
    private Integer id;
    private String username;
    //md5
    private String salt;
    private String password;
    private String email;
    private String mobile;
    private Integer valid=1;
    //private Integer deptId;
    private Date createdTime;
    private SysDept sysDept;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
