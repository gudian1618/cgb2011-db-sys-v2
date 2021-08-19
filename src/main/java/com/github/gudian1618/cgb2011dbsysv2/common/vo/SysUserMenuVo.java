package com.github.gudian1618.cgb2011dbsysv2.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/8/19 S:36 下午
 */

@Getter
@Setter
@ToString
public class SysUserMenuVo implements Serializable {

    private static final long serialVersionUID = 1412553207148178628L;
    private Long id;
    private String name;
    private String url;
    // 二级菜单
    private List<SysUserMenuVo> childs;

}
