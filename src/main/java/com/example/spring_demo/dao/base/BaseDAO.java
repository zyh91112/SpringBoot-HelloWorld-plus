package com.example.spring_demo.dao.base;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

/**
 * 基础DAO，在这里定义公共方法
 * @param <T> 实体类
 * @param <ID> 实体类的ID类型
 * @author yinghua
 * 参考 {@link org.springframework.data.jpa.repository.support.SimpleJpaRepository}
 * https://docs.spring.io/spring-data/data-jpa/docs/current/api/index.html?org/springframework/data/jpa/repository/support/SimpleJpaRepository.html
 * Created on 2018/5/29.
 */
@NoRepositoryBean
public interface BaseDAO<T,ID> extends JpaRepository<T,ID> {
    // 增一个
    @Override
    <S extends T> S save(S entity);

    // 增多个
    @Override
    <S extends T> List<S> saveAll(Iterable<S> entities);

    // 通过id删除
    @Override
    void deleteById(ID id);

    // 删一个
    @Override
    void delete(T entity);

    @Override
    void deleteAll(Iterable<? extends T> entities);

    @Override
    void deleteInBatch(Iterable<T> entities);

//    // 通过多个Id删除多个 (貌似行不通，并非所有方法的标识字段都叫id)
//    @Query("delete from #{#entityName} t where t.id in ?1 ")
//    void deleteByIds(List<ID> ids);

    // 全部删除(先用select语句把所有记录查出来，根据查出来的各个记录的Id生成多条delete语句去删除)
    @Override
    void deleteAll();

    // 全部删除（一条delete语句）
    @Override
    void deleteAllInBatch();

    // 通过Id查一个
    @Override
    Optional<T> findById(ID id);

    // Example内的泛型对象，如果字段非null则生成为一个“=”的查询字段
    // 简单条件查询一个
    @Override
    <S extends T> Optional<S> findOne(Example<S> example);

    // 通过多个Id批量查询
    @Override
    List<T> findAllById(Iterable<ID> ids);

    // 通用条件查询
    @Override
    <S extends T> List<S> findAll(Example<S> example);

    // 通用条件查询并排序
    @Override
    <S extends T> List<S> findAll(Example<S> example, Sort sort);

    // 通用条件查询并分页(分页之内可以包含排序)
    @Override
    <S extends T> Page<S> findAll(Example<S> example, Pageable pageable);

    // 无条件查询
    @Override
    List<T> findAll();
    @Override
    List<T> findAll(Sort sort);
    @Override
    Page<T> findAll(Pageable pageable);

    // 数量查询
    @Override
    long count();

    // 通用条件数量查询
    @Override
    <S extends T> long count(Example<S> example);

    // 其它
    @Override
    void flush();
}
