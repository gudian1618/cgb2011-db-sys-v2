package com.github.gudian1618.cgb2011dbsysv2.dao;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.Node;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
     * 更新修改对象
     * @param entity
     * @return
     */
    int updateObject(SysMenu entity);

    /**
     * 持久化菜单对象
     * @param entity
     * @return
     */
    int insertObject(SysMenu entity);

    /**
     * 查询菜单的id,name,parentName
     * @return
     */
    @Select("select id,name,parentId from sys_menus")
    List<Node> findZtreeMenuNodes();

    /**
     * 基于查询的id,删除菜单自身信息
     * @param id
     * @return
     */
    @Select("delete from sys_menus where id=#{id}")
    int deleteObject(Integer id);

    /**
     * 基于菜单统计子菜单的个数
     * @param id
     * @return
     */
    @Select("select count(*) from sys_menus where parentId=#{id}")
    int getChildCount(Integer id);

    /**
     * 获取所有菜单信息,包含当前菜单对应的上级菜单的菜单名称
     * @return
     */
    List<Map<String, Object>> findObjects();

}
