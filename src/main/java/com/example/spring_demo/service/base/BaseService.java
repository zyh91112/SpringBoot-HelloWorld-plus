package com.example.spring_demo.service.base;

import com.example.spring_demo.dao.base.BaseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * 基础Service,对DAO层的方法做一次封装。
 *
 * @author yinghua
 * Created on 2018/5/29.
 */
public abstract class BaseService<T, ID>{

    @Autowired
    protected BaseDAO<T, ID> baseDAO;

    public Iterable<T> findAll(Sort sort) {
        return baseDAO.findAll(sort);
    }

    public Page<T> findAll(Pageable pageable) {
        return baseDAO.findAll(pageable);
    }

    /**
     * 保存一个实体
     * 会先根据id查询一次记录是否存在，如果数据库中不存在，则生成insert语句插入。已经存在则生成update语句进行更新。
     * 注意：更新的时候属性若为null则会将表中记录的字段也设置为空！
     */
    public <S extends T> S save(S s) {
        return baseDAO.save(s);
    }

    public <S extends T> Iterable<S> saveAll(Iterable<S> iterable) {
        return baseDAO.saveAll(iterable);
    }

    public Optional<T> findById(ID id) {
        return baseDAO.findById(id);
    }

    public boolean existsById(ID id) {
        return baseDAO.existsById(id);
    }

    public Iterable<T> findAll() {
        return baseDAO.findAll();
    }

    public Iterable<T> findAllById(Iterable<ID> iterable) {
        return baseDAO.findAllById(iterable);
    }

    public long count() {
        return baseDAO.count();
    }

    public void deleteById(ID id) {
        baseDAO.deleteById(id);
    }

    public void delete(T t) {
        baseDAO.delete(t);
    }

    public void deleteAll(Iterable<? extends T> iterable) {
        baseDAO.deleteAll(iterable);
    }

    public void deleteAll() {
        baseDAO.deleteAll();
    }

    public void flush() {
        baseDAO.flush();
    }

    public <S extends T> S saveAndFlush(S entity) {
        return baseDAO.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<T> entities) {
        baseDAO.deleteInBatch(entities);
    }

    public void deleteAllInBatch() {
        baseDAO.deleteAllInBatch();
    }

    public T getOne(ID id) {
        return baseDAO.getOne(id);
    }

    public <S extends T> List<S> findAll(Example<S> example) {
        return baseDAO.findAll(example);
    }

    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return baseDAO.findAll(example,sort);
    }

    public <S extends T> Optional<S> findOne(Example<S> example) {
        return baseDAO.findOne(example);
    }

    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return baseDAO.findAll(example,pageable);
    }

    public <S extends T> long count(Example<S> example) {
        return baseDAO.count(example);
    }

    public <S extends T> boolean exists(Example<S> example) {
        return baseDAO.exists(example);
    }
}
