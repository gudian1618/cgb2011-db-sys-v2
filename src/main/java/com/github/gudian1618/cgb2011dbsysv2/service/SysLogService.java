package com.github.gudian1618.cgb2011dbsysv2.service;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.PageObject;
import com.github.gudian1618.cgb2011dbsysv2.entity.SysLog;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/22 9:41 下午
 */

public interface SysLogService {

    /**
     * 基于id删除信息
     * @param ids
     * @return
     */
    int deleteObjects(int... ids);

    /**
     * 基于条件进行日志信息的分页查询操作
     * @param username 查询条件
     * @param pageCurrent 当前页码值
     * @return 当前页记录+分页信息
     */
    PageObject<SysLog> findPageObjects(String username, Long pageCurrent);

}
