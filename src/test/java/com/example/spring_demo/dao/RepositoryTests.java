package com.example.spring_demo.dao;

import com.example.spring_demo.entity.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author yinghua
 * Created on 2018/6/4.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class RepositoryTests {
    private Logger logger = LoggerFactory.getLogger(RepositoryTests.class);

    @Autowired
    UserDAO userDAO;

    Random random = new Random();

    // 数量查询测试
    @Test
    public void count() {
        User user = new User();
        user.setUsername("zyh");
        Example<User> example = Example.of(user);

        logger.info("userDAO.count():" + userDAO.count());
        logger.info("userDAO.count(example)" + userDAO.count(example));
    }

    // 创建测试
    @Test
    public void save() {
        saveUser("able" + random.nextInt(100000),"123456");
    }

    private void saveUser(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDAO.save(user);
    }

    @Test
    public void saveAll() {
        saveAll(50);
    }

    public void saveAll(int count) {
        List<User> userList = new ArrayList<>();

        for (int i = 1,r = random.nextInt(10000); i <= count; i++) {
            User userR = new User();
            userR.setUsername("createAll" + r + "_" + i);
            userR.setPassword("123456");
            userList.add(userR);
        }
        userDAO.saveAll(userList);

        userDAO.flush();
        logger.info("createAll!");
    }

    @Test
    public void deleteOne() {
        // 单个删除
        userDAO.deleteById("able96042");

        // 删除不存在的单个资源:
        // org.springframework.dao.EmptyResultDataAccessException: No class com.example.spring_demo.entity.po.User entity with id not this user exists!
        userDAO.deleteById("not this user");
    }

    @Test
    public void deleteMulti() {
        // 多个删除即时不存在任何被删除的资源也不会有异常

        userDAO.deleteAll();
        saveAll(50);
        long endTime;
        long startTime;
        startTime = System.currentTimeMillis();
        // 全部删除 deleteAll会先用一条select语句把所有对象查找出来，然后根据查找出来对象Id，生成多条delete语句
        userDAO.deleteAll();
        userDAO.flush();
        endTime = System.currentTimeMillis();
        logger.info("deleteAll删除50个对象时候耗费时间:" + (endTime - startTime));

        saveAll(50);
        startTime = System.currentTimeMillis();
        // 全部删除 deleteAllInBatch就直接用一条delete语句将所有记录删除
        userDAO.deleteAllInBatch();
        userDAO.flush();
        endTime = System.currentTimeMillis();
        logger.info("deleteAllInBatch删除50个对象时候耗费时间:" + (endTime - startTime));
    }

    // TODO 通过条件删除
    // TODO 通过多个Id删除多个资源
    @Test
    public void deleteAll() {
        // 多个删除即时不存在任何被删除的资源也不会有异常
//        saveUser("testForDel","12345864");
//        User userForExample = new User();
//        userForExample.setUsername("testForDel");
//        Example<User> example  = Example.of(userForExample);
//        userDAO.deleteAll(example);
        List<String> ids = new ArrayList<>();
        ids.add("saveAll7531_7");
        ids.add("saveAll7531_8");
        User user = userDAO.findByUsername("saveAll7531_8");
        logger.info("findByUsername:"+user);
        userDAO.deleteByIds(ids);
    }




    @Test
    public void findOne() {
//                org.assertj.core.api.Assertions.assertThat()
        User user1 = new User();
        user1.setUsername("zyh");
        user1.setPassword("1232");
        userDAO.save(user1);
        logger.info("user1:"+user1);

        User user2;
        Optional<User> optionalUser = userDAO.findById("zyh");
        if (optionalUser.isPresent()){
            user2 = optionalUser.get();
            logger.info("findById(): user2:"+user2);
        }else{
            logger.info("findById(): no such user username=\"zyh\"");
        }

        User exampleUser = new User();
        exampleUser.setPassword("1232");
        Example<User> example = Example.of(exampleUser);
        optionalUser = userDAO.findOne(example);
        // org.springframework.dao.IncorrectResultSizeDataAccessException if the Example yields more than one result.
        if (optionalUser.isPresent()){
            user2 = optionalUser.get();
            logger.info("findOne(): user2:"+user2);
        }else{
            logger.info("findOne(): no such user username=\"zyh\"");
        }

//        User user3;
//        user3 = userDAO.getOne("zyh");
//        if (user3 != null) {
//            logger.info("getOne(): user3:"+user3);
//        }else{
//            logger.info("getOne(): no such user username=\"zyh\"");
//        }
    }

    @Test
    public void findAll(){
        saveAll(10);

        User user = new User();
        user.setPassword("123456");
//        user.setUsername("zyh");
        Example<User> example = Example.of(user);

        Sort sort = Sort.by(Sort.Direction.DESC, "username");

        List<User> userList1;
        userList1 = userDAO.findAll(example);
        logger.info("userDAO.findAll(example)"+Arrays.toString(userList1.toArray()));

        Pageable pageable = PageRequest.of(1,5,sort);
        userList1 = userDAO.findAll(example,sort);
        logger.info("userDAO.findAll(example)"+Arrays.toString(userList1.toArray()));

//        userList1 = userDAO.findAll(example,pageable).getContent();
        Page<User> userPage = userDAO.findAll(example,pageable);
        logger.info("当前页数getNumber:"+userPage.getNumber());
        logger.info("当前页内真正数量（小于等于每页预期数量）getNumberOfElements:"+userPage.getNumberOfElements());
        logger.info("每页预期数量getSize:"+userPage.getSize());

        logger.info("getTotalPages:"+userPage.getTotalPages());
        logger.info("getTotalElements:"+userPage.getTotalElements());
        userPage.forEach(user1 -> logger.info("user:"+ user1));



        // 2个条件username，password都是DESC排序
        pageable = PageRequest.of(0,15,Sort.Direction.DESC,"username","password");
        userPage = userDAO.findAll(example,pageable);
        logger.info("当前页数getNumber:"+userPage.getNumber());
        logger.info("当前页内真正数量（小于等于每页预期数量）getNumberOfElements:"+userPage.getNumberOfElements());
        logger.info("每页预期数量getSize:"+userPage.getSize());

        logger.info("getTotalPages:"+userPage.getTotalPages());
        logger.info("getTotalElements:"+userPage.getTotalElements());

        userPage.forEach(user1 -> logger.info("user:"+ user1));


//        user.setPassword(null);
//        userDAO.findAll(example,sort);
//        userDAO.findAll(example,Sort.unsorted());
//
//
//        Pageable pageable = PageRequest.of(1, 3);
//        userDAO.findAll(example, pageable);
    }

    @Test
    public void findAllById(){
        List<String> ids = new ArrayList<>();
        ids.add("saveAll3637_9");
        ids.add("saveAll3637_10");

        userDAO.findAllById(ids).forEach(user->logger.info("user:"+user));
    }
}
