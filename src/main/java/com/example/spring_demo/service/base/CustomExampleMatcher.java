package com.example.spring_demo.service.base;

import org.springframework.data.domain.ExampleMatcher;

/**
 * 自定义ExampleMatcher
 * @author yinghua
 * Created on 2018/6/5.
 */
final public class CustomExampleMatcher {
    // 所有字符串字段模糊查询且字段大小写不敏感
    public static final ExampleMatcher STRING_FIELD_LIKE = ExampleMatcher.matching()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
            .withIgnoreCase();
}
