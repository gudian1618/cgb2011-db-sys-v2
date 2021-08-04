package com.github.gudian1618.cgb2011dbsysv2.dao;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.SysUserDeptVo;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:09 下午
 */

@Mapper
public interface SysUserDao {

    @Select("select * from sys_users where username=#{username}")
    SysUser findUserByUserName(String username);

    /**
     * 基于用户id查询用户以及用户对应的部门信息
     *
     * @param id
     * @return
     */
    SysUserDeptVo findObjectById(Long id);

    /**
     * 保存用户自身信息
     *
     * @param entity
     * @return
     */
    int insertObject(SysUser entity);

    /**
     * 更新用户自身信息
     *
     * @param entity
     * @return
     */
    int updateObject(SysUser entity);

    @Update("update sys_users set valid=#{valid},modifiedUser=#{username},modifiedTime=now() where id=#{id}")
    int validById(Long id, Integer valid, String username);

    /**
     * 基于条件查询总记录数
     *
     * @param username
     * @return
     */
    long getRowCount(String username);

    /**
     * 基于条件查询当前页记录
     *
     * @param username
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysUserDeptVo> findPageObjects(String username, long startIndex, int pageSize);

}
