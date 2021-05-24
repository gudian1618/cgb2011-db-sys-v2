package com.github.gudian1618.cgb2011dbsysv2.service;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.CheckBox;
import com.github.gudian1618.cgb2011dbsysv2.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv2.common.vo.SysRoleMenuVo;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysRole;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/16 10:10 下午
 */

public interface SysRoleService {

    /**
     * 获取所有角色的id和name
     * @return
     */
    List<CheckBox> findObjects();

    /**
     * 基于角色id查询角色以及对应的菜单id
     * @param id
     * @return
     */
    SysRoleMenuVo findObjectById(Integer id);

    /**
     * 保存角色以及角色对应的菜单信息
     * @param entity
     * @param menuIds
     * @return
     */
    int saveObject(SysRole entity, Integer[] menuIds);

    /**
     * 更新角色以及角色对应的菜单信息
     * @param entity
     * @param menuIds
     * @return
     */
    int updateObject(SysRole entity, Integer[] menuIds);

    int deleteObject(Integer id);

    PageObject<SysRole> findPageObjects(String name, Long pageCurrent);

}
