package com.example.spring_demo.config.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * @author yinghua
 * Created on 2018/5/29.
 */
public class DemoInterceptor extends HandlerInterceptorAdapter{
    private static final Logger logger = LoggerFactory.getLogger(DemoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        long startTime = (Long) request.getAttribute("startTime");
        logger.debug("本次请求处理时间为"+ (endTime - startTime) +"ms");
//        System.out.println();
        request.removeAttribute("startTime");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
