package com.example.spring_demo;

import com.example.spring_demo.entity.po.User;
import com.example.spring_demo.entity.vo.UserVO;
import org.dozer.DozerBeanMapper;
import org.junit.Test;

/**
 * @author yinghua
 * Created on 2018/6/5.
 */

public class DozerTest {

    @Test
    public void test1(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        User user = new User();
        user.setUsername("hollis");
        user.setPassword("123456");
        UserVO userVO = mapper.map(user, UserVO.class);
        System.out.println(userVO);
    }
}
