package com.github.gudian1618.cgb2011dbsysv1.dao;

import com.github.gudian1618.cgb2011dbsysv1.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/16 10:03 下午
 */

@Mapper
public interface SysRoleDao {

    /**
     * 保存角色自身信息
     * @param entity
     * @return
     */
    int insertObject(SysRole entity);

    /**
     * 查询总记录数
     * @param name
     * @return
     */
    long getRowCount(String name);

    /**
     * 查询当前页记录数
     * @param name
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysRole> findPageObjects(String name, long startIndex, int pageSize);

}
