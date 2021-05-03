package com.github.gudian1618.cgb2011dbsysv1.service;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.Node;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysMenu;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/29 5:38 下午
 */

public interface SysMenuService {

    /**
     * 更新菜单信息
     * @param entity
     * @return
     */
    int updateObject(SysMenu entity);

    /**
     * 保存菜单信息
     * @param entity
     * @return
     */
    int saveObject(SysMenu entity);

    List<Node> findZtreeMenuNodes();

    int deleteObjects(Integer id);

    List<Map<String, Object>> findObjects();

}
