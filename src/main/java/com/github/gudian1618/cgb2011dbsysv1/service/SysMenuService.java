package com.github.gudian1618.cgb2011dbsysv1.service;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.Node;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/29 5:38 下午
 */

public interface SysMenuService {

    List<Node> findZtreeMenuNodes();

    int deleteObjects(Integer id);

    List<Map<String, Object>> findObjects();

}
