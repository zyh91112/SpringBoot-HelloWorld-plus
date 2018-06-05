package com.example.spring_demo.service.base;

import com.example.spring_demo.dao.base.BaseDAO;
import com.example.spring_demo.utils.MyBeanUtil;
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
public abstract class BaseService<T, ID> {

    @Autowired
    protected BaseDAO<T, ID> baseDAO;

    // ********************* 自定义方法 ***********************

    // 所有字符串字段模糊查询且字段大小写不敏感
    public List<T> findAllByFiledLike(T t) {
        return baseDAO.findAll(Example.of(t, CustomExampleMatcher.STRING_FIELD_LIKE));
    }

    // TODO 通过Id查找一个并修改其除了Id之外的属性
    public void updateById(ID id, T ObjOfUpdateFiled) {
        Optional<T> optionalT = baseDAO.findById(id);
        if (optionalT.isPresent()) {
            T persistenceEntity = optionalT.get();
            // 先查询出持久化对象，然后合并properties，再save。
            MyBeanUtil.copyNotNullPropFromSource(ObjOfUpdateFiled, persistenceEntity);
            baseDAO.save(persistenceEntity);
        }
    }

    // TODO 多ID删除
    public void deleteAll(List<ID> ids) {
        // 获取资源的Id字段和表名

        // 构建一个Query，一次性删除
    }

    // TODO 通过多个Id查找多个并修改其除了Id之外的属性(暂时不做)
    public void updateByIds(List<ID> ids, T ObjOfUpdateFiled) {
        // 获取资源的Id字段和表名

        // 构建一个Query，一次性更新
    }

    // TODO 通用条件删除(暂不实现)
    public void deleteAll(Example<T> example) {
        // 自行构建一个Query然后遍历所有属性，然后获取
    }

    // TODO 通过通用条件查询多个(或1个)并修改所有对象的多个属性(暂时不做,其实好像不应该提供这样的接口。)
    public void updateAll(T probe, T ObjOfUpdateFiled) {
    }

    //*******对DAO层方法做简单封装*********************
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
    public <S extends T> S create(S s) {
//        ID id =
//        if (baseDAO.existsById())
        return baseDAO.save(s);
    }

    public <S extends T> Iterable<S> createAll(Iterable<S> iterable) {
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
    public void deleteAll() {
        baseDAO.deleteAllInBatch();
    }

    public void deleteAll(Iterable<T> entities) {
        baseDAO.deleteInBatch(entities);
    }

    public void flush() {
        baseDAO.flush();
    }

    public <S extends T> S saveAndFlush(S entity) {
        return baseDAO.saveAndFlush(entity);
    }

    public T getOne(ID id) {
        return baseDAO.getOne(id);
    }

    public <S extends T> List<S> findAll(Example<S> example) {
        return baseDAO.findAll(example);
    }

    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return baseDAO.findAll(example, sort);
    }

    public <S extends T> Optional<S> findOne(Example<S> example) {
        return baseDAO.findOne(example);
    }

    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return baseDAO.findAll(example, pageable);
    }

    public <S extends T> long count(Example<S> example) {
        return baseDAO.count(example);
    }

    public <S extends T> boolean exists(Example<S> example) {
        return baseDAO.exists(example);
    }
}
