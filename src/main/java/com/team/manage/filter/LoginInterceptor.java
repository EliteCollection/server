package com.team.manage.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create By tcyu
 * Create time 2019/1/26 下午5:52
 * Description 登录控制器
 */
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("-----开始处理登录拦截请求判断-----");
        Object obj = request.getSession().getAttribute("userName");
        if (obj == null || !(obj instanceof String)){
            logger.info("----未登录----");
            response.sendRedirect("/login");
            return false;
        }
        logger.info("用户名为:"+obj);
        return true;
    }
}
