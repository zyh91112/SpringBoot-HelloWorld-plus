package com.example.spring_demo.controller;

import com.example.spring_demo.controller.base.BaseController;
import com.example.spring_demo.po.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinghua
 * Created on 2018/5/29.
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController<User,String>{
}
