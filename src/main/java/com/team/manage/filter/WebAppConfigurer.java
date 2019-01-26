package com.team.manage.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Create By tcyu
 * Create time 2019/1/26 下午5:42
 * Description 过滤器验证用户登录状态
 */
@Component
public class WebAppConfigurer extends WebMvcConfigurerAdapter {
    private static Logger logger = LoggerFactory.getLogger(WebAppConfigurer.class);
    public void addInterceptors(InterceptorRegistry interceptorRegistry){
        logger.info("进入拦截器");
        InterceptorRegistration ir = interceptorRegistry.addInterceptor(new LoginInterceptor());
        ir.addPathPatterns("/**");
        ir.excludePathPatterns("/login");
    }
}
