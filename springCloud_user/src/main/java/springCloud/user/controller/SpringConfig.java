package springCloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springCloud.user.interceptor.JwtInterceptor;

/**
 * springMVC配置类
 */
@Configuration
public class SpringConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtInterceptor interceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry){
        //指定拦截器对象和该拦截器要拦截的路径
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login/**");
    }



}
