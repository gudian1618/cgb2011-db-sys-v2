package com.github.gudian1618.cgb2011dbsysv2.dao;

import com.github.gudian1618.cgb2011dbsysv2.common.vo.SysRoleMenuVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/5/17 5:16 下午
 */

@SpringBootTest
public class SysRoleDaoTests {

    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    // 单表多次查询
    @Test
    public void testFindObjectById01() {
        SysRoleMenuVo rm = sysRoleDao.findObjectById(47);
        List<Integer> menuIds = sysRoleMenuDao.findMenuIdsByRoleId(47);
        rm.setMenuIds(menuIds);
        System.out.println(rm);
    }

    // 嵌套查询
    @Test
    public void testFindObjectById02() {
        SysRoleMenuVo rm = sysRoleDao.findObjectById(47);
        System.out.println(rm);
    }

}
