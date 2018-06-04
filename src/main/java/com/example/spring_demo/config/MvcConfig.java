package com.example.spring_demo.config;

import com.example.spring_demo.config.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author yinghua
 * Created on 2018/5/29.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    //提供跨域支持
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(false)
                .maxAge(3600);
    }

    // 添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor());
    }

    // 添加自定义MessageConverter
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add()
    }

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }
}
