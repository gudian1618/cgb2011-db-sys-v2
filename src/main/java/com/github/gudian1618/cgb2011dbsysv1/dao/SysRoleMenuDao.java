package com.github.gudian1618.cgb2011dbsysv1.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/30 11:47 上午
 */

@Mapper
public interface SysRoleMenuDao {

    int deleteObjectsByMenuId(Integer menuId);

}
