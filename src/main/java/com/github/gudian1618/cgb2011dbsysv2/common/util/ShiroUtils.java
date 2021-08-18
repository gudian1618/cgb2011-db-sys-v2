package com.github.gudian1618.cgb2011dbsysv2.common.util;

import com.github.gudian1618.cgb2011dbsysv2.entity.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/8/18 9:42 下午
 */

public class ShiroUtils {

    public static String getUsername() {
        return getUser().getUsername();
    }

    public static SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

}
