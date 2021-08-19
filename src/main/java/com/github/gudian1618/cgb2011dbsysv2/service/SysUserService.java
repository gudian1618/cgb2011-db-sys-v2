package com.github.gudian1618.cgb2011dbsysv2.service;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv2.common.vo.SysUserDeptVo;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysUser;

import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:39 下午
 */

public interface SysUserService {

    int updatePassword(String password, String newPassword, String cfgPassword);

    /**
     * 封装查询到的用户信息以及用户对应的角色信息
     * @param id
     * @return
     */
    Map<String, Object> findObjectById(Long id);

    /**
     * 保存用户及对应的用户的信息
     * @param entity
     * @param roleIds
     * @return
     */
    int saveObject(SysUser entity, Integer[] roleIds);

    /**
     * 更新用户及对应的用户的信息
     * @param entity
     * @param roleIds
     * @return
     */
    int updateObject(SysUser entity, Integer[] roleIds);

    int validById(Long id, Integer valid);

    /**
     * 查询当前页要呈现的信息以及分页信息
     * @param username
     * @param pageCurrent
     * @return
     */
    PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent);

}
