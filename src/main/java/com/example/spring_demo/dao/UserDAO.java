package com.example.spring_demo.dao;

import com.example.spring_demo.dao.base.BaseDAO;
import com.example.spring_demo.entity.po.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yinghua
 * Created on 2018/5/29.
 */
public interface UserDAO extends BaseDAO<User, String> {

    @Query("select u from User u where u.username=?1")
    User findByUsername(String username);

    // 通过id列表删除多条记录
    @Modifying
    @Query("delete from User u where u.username in ?1")
    @Transactional
    void deleteByIds(List<String> usernameList);

//    void deleteAll(Example<User> example);
}
