package com.example.spring_demo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinghua
 * Created on 2018/5/28.
 */
@RestController
@Api(description = "测试")
public class TestController {

    @GetMapping("/example/error/IllegalArgumentException")
    String error(@ModelAttribute("msg") String msg) {
        throw new IllegalArgumentException("msg:"+msg);
    }

    @GetMapping("/test")
    String test() {
        return "hello world2!";
    }

}
