package com.example.spring_demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * MVC全局异常类型处理
 * @author yinghua
 * Created on 2018/6/4.
 */
@ControllerAdvice
public class GlobalMVCHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalMVCHandler.class);

    // TODO 资源不存在
    // TODO 参数类型错误
    // TODO 参数不符合格式（范围，长度等）
    // TODO 服务器错误 500

    // 优先级别最低
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String, Object> ajaxError(Throwable error, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", error.getMessage());
        map.put("result", "error");
        return map;
    }
}
