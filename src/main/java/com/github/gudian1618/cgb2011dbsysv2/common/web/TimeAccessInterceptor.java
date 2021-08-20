package com.github.gudian1618.cgb2011dbsysv2.common.web;

import com.github.gudian1618.cgb2011dbsysv2.common.exception.ServiceException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * @author gudian1618
 * @version v1.0
 * @date 2021/8/20 7:35 下午
 */

public class TimeAccessInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===preHandle===");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 9);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        long start = c.getTimeInMillis();
        c.set(Calendar.HOUR_OF_DAY, 22);
        long end = c.getTimeInMillis();
        long current = System.currentTimeMillis();
        if (current < start || current > end) {
            throw new ServiceException("不在访问时间");
        }
        // true表示放行,false表示拦截
        return true;
    }
}
