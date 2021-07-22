package cn.itsource.springboot.web;

import cn.itsource.springboot.web.interceptor.LoginInterceptor;
import cn.itsource.springboot.web.interceptor.PermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private PermissionInterceptor permissionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login").excludePathPatterns("/assets/**");

        registry.addInterceptor(permissionInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login").excludePathPatterns("/assets/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/nopermission").setViewName("/views/nopermission");
    }
}
