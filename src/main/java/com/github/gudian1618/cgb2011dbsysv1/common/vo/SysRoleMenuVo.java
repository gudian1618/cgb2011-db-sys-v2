package com.github.gudian1618.cgb2011dbsysv1.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/17 5:04 下午
 * 基于角色id从数据库中获取数据然后封装到此对象
 * 1.业务层发起多次查询,最后将会结果封装到SysRoleMenuVo (简单多次查询)
 * 2.业务层只发起一次请求,数据层执行多次嵌套查询,最后将会结果封装到SysRoleMenuVo (嵌套查询)
 * 3.业务层只发起一次请求,数据层执行多表关联查询,最后将会结果封装到SysRoleMenuVo (多表关联查询)
 */

@Data
public class SysRoleMenuVo implements Serializable {

    private static final long serialVersionUID = 459637682879501775L;
    private Integer id;
    private String name;
    private String note;
    // 基于角色id从角色菜单中间表中进行获取
    private List<Integer> menuIds;

}
