package com.example.spring_demo.dao.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 基础DAO，在这里定义公共方法
 * @author yinghua
 * Created on 2018/5/29.
 */
@NoRepositoryBean
public interface BaseDAO<T,ID> extends JpaRepository<T,ID> {
}
