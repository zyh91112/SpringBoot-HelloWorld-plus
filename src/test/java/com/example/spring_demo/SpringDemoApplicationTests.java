package com.example.spring_demo;

import com.example.spring_demo.po.User;
import com.example.spring_demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDemoApplicationTests {

    Logger logger = LoggerFactory.getLogger(SpringDemoApplicationTests.class);

    @Autowired
    UserService userService;

	@Test
	public void contextLoads() {
	    User user = new User();
	    user.setUsername("zyh");
        Example<User> example = Example.of(user);
	    logger.debug("userService.count():"+userService.count());
        logger.debug("userService.count(example)"+userService.count(example));
        userService.findById("zyh");
        Sort sort = Sort.by(Sort.Direction.DESC,"username");
        Pageable pageable = PageRequest.of(1,3);
        userService.findAll(example,pageable);
//        userService.`

    }

}
