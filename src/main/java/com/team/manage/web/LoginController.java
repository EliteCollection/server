package com.team.manage.web;

import com.team.manage.common.SimpleResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Create By tcyu
 * Create time 2019/1/26 下午6:41
 * Description 登录控制器
 */
@RestController
public class LoginController {
    private SimpleResult result;
    @RequestMapping("/login")
    public SimpleResult login(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("userName","张三");
        result = new SimpleResult(false);
        return result;
    }
}
