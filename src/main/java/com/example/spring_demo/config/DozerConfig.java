package com.example.spring_demo.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Dozer配置
 * Dozer is a Java Bean to Java Bean mapper that recursively copies data from one object to another.
 * Typically, these Java Beans will be of different complex types.
 * @author yinghua
 * Created on 2018/6/5.
 */
@Configuration
public class DozerConfig {
    @Bean
    DozerBeanMapper dozerBeanMapper(){
        List<String> mappingList = new ArrayList<>();
        mappingList.add("classpath:dozer/dozer-mapping.xml");
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.setMappingFiles(mappingList);
        return dozerBeanMapper;
    }
}
