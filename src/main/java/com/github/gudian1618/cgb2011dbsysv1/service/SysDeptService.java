package com.github.gudian1618.cgb2011dbsysv1.service;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.Node;
import com.github.gudian1618.cgb2011dbsysv1.entity.SysDept;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/4 11:35 上午
 */

public interface SysDeptService {

    List<Map<String,Object>> findObjects();
    List<Node> findZTreeNodes();
    int saveObject(SysDept entity);
    int updateObject(SysDept entity);
    int deleteObject(Integer id);

}
