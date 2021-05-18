package com.github.gudian1618.cgb2011dbsysv1.dao;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.SysUserDeptVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/18 9:09 下午
 */

@Mapper
public interface SysUserDao {

    /**
     * 基于条件查询总记录数
     * @param username
     * @return
     */
    long getRowCount(String username);

    /**
     * 基于条件查询当前页记录
     * @param username
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<SysUserDeptVo> findPageObjects(String username, long startIndex, int pageSize);

}
