package com.github.gudian1618.cgb2011dbsysv2.dao;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.Node;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysDept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/4 11:28 上午
 */

@Mapper
public interface SysDeptDao {

    /**
     * 查询所有部门以及部门的上级菜单信息
     * @return
     */
    @Select("select c.*,p.name parentName from sys_depts c left join sys_depts p on c.parentId=p.id")
    List<Map<String,Object>> findObjects();

    @Select("select id,name,parentId from sys_depts")
    List<Node> findZTreeNodes();

    int updateObject(SysDept entity);
    int insertObject(SysDept entity);

    @Select("select count(*) from sys_depts where parentId=#{id}")
    int getChildCount(Integer id);

    @Delete("delete from sys_depts where id=#{id}")
    int deleteObject(Integer id);

}
