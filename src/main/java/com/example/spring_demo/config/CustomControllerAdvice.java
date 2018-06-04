package com.example.spring_demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器进行全局配置
 * @author yinghua
 * Created on 2018/5/29.
 */
@ControllerAdvice
public class CustomControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(CustomControllerAdvice.class);

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Map<String, Object> ajaxError(Throwable error, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        map.put("error", error.getMessage());
        map.put("result", "error");
        return map;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("sdfdsusername");
    }
}
