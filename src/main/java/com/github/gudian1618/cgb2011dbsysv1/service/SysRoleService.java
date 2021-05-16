package com.github.gudian1618.cgb2011dbsysv1.service;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysRole;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/16 10:10 下午
 */

public interface SysRoleService {

    PageObject<SysRole> findPageObjects(String name, Long pageCurrent);

}
