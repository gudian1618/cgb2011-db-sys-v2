package com.github.gudian1618.cgb2011dbsysv2.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/30 11:47 上午
 */

@Mapper
public interface SysRoleMenuDao {

    @Select("select menu_id from sys_role_menus where role_id=#{id}")
    List<Integer> findMenuIdsByRoleId(Integer id);

    List<Integer> findMenuIdsByRoleIds(@Param("roleIds") Integer[] roleIds);

    /**
     * 保存角色和菜单的关系数据
     *
     * @param roleId
     * @param menuIds
     * @return
     */
    int insertObjects(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

    /**
     * 基于角色id删除角色菜单关系数据
     *
     * @param roleId
     * @return
     */
    @Delete("delete from sys_role_menus where role_id=#{roleId}")
    int deleteObjectsByRoleId(Integer roleId);

    /**
     * 基于菜单id删除角色菜单关系数据
     *
     * @param menuId
     * @return
     */
    int deleteObjectsByMenuId(Integer menuId);

}
