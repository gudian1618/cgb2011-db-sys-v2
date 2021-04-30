package com.github.gudian1618.cgb2011dbsysv1.service.impl;

import com.github.gudian1618.cgb2011dbsysv1.common.vo.Node;
import com.github.gudian1618.cgb2011dbsysv1.dao.SysMenuDao;
import com.github.gudian1618.cgb2011dbsysv1.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/4/29 5:40 下午
 */

@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    @Override
    public List<Node> findZtreeMenuNodes() {

        return sysMenuDao.findZtreeMenuNodes();
    }

    @Override
    public int deleteObjects(Integer id) {
        return 0;
    }

    @Override
    public List<Map<String, Object>> findObjects() {
        return sysMenuDao.findObjects();
    }
}
