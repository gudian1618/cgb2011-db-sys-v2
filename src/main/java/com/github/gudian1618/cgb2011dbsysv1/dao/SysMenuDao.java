package com.github.gudian1618.cgb2011dbsysv1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/29 4:56 下午
 */

@Mapper
public interface SysMenuDao {

    /**
     * 获取所有菜单信息,包含当前菜单对应的上级菜单的菜单名称
     * @return
     */
    List<Map<String, Object>> findObjects();

}
