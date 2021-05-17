package com.github.gudian1618.cgb2011dbsysv1.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/17 5:04 下午
 * 基于角色id从数据库中获取数据然后封装到此对象
 * 1.业务层发起多次查询,最后将会结果封装到SysRoleMenuVo
 * 2.数据层发起多次查询,最后将会结果封装到SysRoleMenuVo
 * 3.数据层执行多表关联查询,最后将会结果封装到SysRoleMenuVo
 */

@Data
public class SysRoleMenuVo implements Serializable {

    private static final long serialVersionUID = 459637682879501775L;
    private Integer id;
    private String name;
    private String note;
    private List<Integer> menuIds;

}
