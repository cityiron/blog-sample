package com.funnycode.pm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tc
 * @date 2020/11/4
 */
@Order(1)
public class BlackListInterceptor implements HandlerInterceptor {

    @Autowired
    private BlackListMBean blackListMBean;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String ip = request.getRemoteAddr();
        System.out.printf("[info] check ip address {}...", ip);
        System.out.println();
        // 是否在黑名单中:
        if (blackListMBean.shouldBlock(ip)) {
            System.out.printf("[warn] will block ip {} for it is in blacklist.", ip);
            System.out.println();
            // 发送403错误响应:
            response.sendError(403);
            return false;
        }
        return true;
    }

}
