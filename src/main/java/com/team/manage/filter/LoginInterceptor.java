package com.team.manage.filter;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("-----开始处理登录拦截请求判断-----> 暂时没有写,后期处理请求");
//        Object obj = request.getSession().getAttribute("userName");
//        if (obj == null || !(obj instanceof String)){
//            log.info("----未登录----");
//            response.sendRedirect("/team_manage/login");
//            return false;
//        }
//        log.info("用户名为:"+obj);
        return true;
    }
}
