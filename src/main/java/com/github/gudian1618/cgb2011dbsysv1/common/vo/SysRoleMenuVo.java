package com.github.gudian1618.cgb2011dbsysv1.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/17 5:04 下午
 */

@Data
public class SysRoleMenuVo implements Serializable {

    private static final long serialVersionUID = 459637682879501775L;
    private Integer id;
    private String name;
    private String note;
    private List<Integer> menuIds;

}
