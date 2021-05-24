package com.github.gudian1618.cgb2011dbsysv2.dao;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.CheckBox;
import com.github.gudian1618.cgb2011dbsysv2.common.vo.SysRoleMenuVo;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/16 10:03 下午
 */

@Mapper
public interface SysRoleDao {

    /**
     * 获取所有角色的id和name
     *
     * @return
     */
    @Select("select id,name from sys_roles")
    List<CheckBox> findObjects();

    SysRoleMenuVo findObjectById(Integer id);

    /**
     * 保存角色自身信息
     *
     * @param entity
     * @return
     */
    int insertObject(SysRole entity);

    /**
     * 更新角色自身信息
     *
     * @param entity
     * @return
     */
    @Update("update sys_roles set name=#{name},note=#{note},modifiedTime=now(),modifiedUser=#{modifiedUser} where id=#{id}")
    int updateObject(SysRole entity);

    /**
     * 查询总记录数
     *
     * @param name
     * @return
     */
    long getRowCount(String name);

    /**
     * 查询当前页记录数
     *
     * @param name
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysRole> findPageObjects(String name, long startIndex, int pageSize);

}
