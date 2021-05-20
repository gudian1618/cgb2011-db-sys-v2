package com.github.gudian1618.cgb2011dbsysv1.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/20 8:23 下午
 */

@Mapper
public interface SysUserRoleDao {

    /**
     * 基于用户id查询角色id
     * @param id
     * @return
     */
    @Select("select role_id from sys_user_roles where user_id=#{id}")
    List<Integer> findRoleIdsByUserId(Long id);

    /**
     * 保存用户和关系的数据
     * @param userId
     * @param roleIds
     * @return
     */
    int insertObjects(@Param("userId")Integer userId, @Param("roleIds")Integer[] roleIds);

    /**
     * 基于角色id删除角色用户关系数据
     * @param roleId
     * @return
     */
    @Delete("delete from sys_userroles where role_id=#{roleId}")
    int deleteObjectsByRoleId(Integer roleId);

}
