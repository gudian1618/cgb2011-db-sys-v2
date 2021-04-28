package com.github.gudian1618.cgb2011dbsysv1.dao;

import com.github.gudian1618.cgb2011dbsysv1.entity.SysLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/21 9:23 下午
 */

@Mapper
public interface SysLogDao {

    /**
     * 基于id值执行删除操作
     * @param ids
     * @return mybatis中处理可变参数时, 底层默认会将可变参数存储到一个array对象中
     */
    // int deleteObjects(@Param("ids") int... ids);
    int deleteObjects(int... ids);

    /**
     * 基于查询条件统计用户行为的日志记录
     * @param username
     * @return
     */
    int getRowCount(String username);

    /**
     * 查询当前页要呈现的用户行为日志
     * @param username
     * @param startIndex 当前页的起始位置
     * @param pageSize 当前页的页面大小(每页最多显示多少条)
     * @return
     */
    List<SysLog> findPageObjects(@Param("username") String username, long startIndex, int pageSize);

}
