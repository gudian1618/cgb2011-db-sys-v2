package com.github.gudian1618.cgb2011dbsysv1.service;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.common.vo.SysUserDeptVo;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:39 下午
 */

public interface SysUserService {

    int validById(Long id, Integer valid);

    /**
     * 查询当前页要呈现的信息以及分页信息
     * @param username
     * @param pageCurrent
     * @return
     */
    PageObject<SysUserDeptVo> findPageObjects(String username, Long pageCurrent);

}
