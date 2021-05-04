package com.github.gudian1618.cgb2011dbsysv1.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/4 11:23 上午
 */

@Data
public class SysDept implements Serializable {

    private static final long serialVersionUID = -8711075234657548935L;
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sort;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;

}
