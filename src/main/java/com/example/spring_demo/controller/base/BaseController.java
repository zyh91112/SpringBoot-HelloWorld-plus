package com.example.spring_demo.controller.base;

import com.example.spring_demo.service.base.BaseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 基础Controller
 * @author yinghua
 * Created on 2018/5/29.
 */
public abstract class BaseController<T,ID> {

    @Autowired
    BaseService<T,ID> baseService;

    /**
     * 获取所有该资源: GET /resources
     */
    @GetMapping
    @ApiOperation(value = "获取所有该资源")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "username", value = "用户账号", required = true, dataType = "String", paramType = "query"),
//            @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType = "query")
//    })
    public Iterable<T> findAll() {
        return baseService.findAll();
    }

    /**
     * 获取单个资源: GET /resources/{id}
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个资源")
    public Optional<T> findById(@PathVariable("id") ID id) {
        return baseService.findById(id);
    }

    /**
     * 获取指定id的父资源下的某种子资源: GET /resources/{id}/sub-resources
     */
    @GetMapping("/{id}/sub-resources")
    public String sub(@PathVariable("id") ID id) {
        return "[]";
    }

    // POST /resources
    // PUT /resources
    @RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})
    public <S extends T> S save(S s) {
        return baseService.create(s);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id")ID id) {
        baseService.deleteById(id);
    }

    // DELETE /resources
    @DeleteMapping
    public void deleteAll() {
        baseService.deleteAll();
    }

    /**
     * 获取该资源的数量: GET /resources/count/
     * 注意不要漏掉末尾的"/",该符号是与/resources/{id}区分开来。若id恰好为count也不会导致冲突。
     */
    @GetMapping("/count/")
    @ApiOperation(value = "获取改资源的数量")
    public long count() {
        return baseService.count();
    }



//    public <S extends T> Iterable<S> createAll(Iterable<S> iterable) {
//        return baseService.createAll(iterable);
//    }
//
//    public boolean existsById(ID id) {
//        return baseService.existsById(id);
//    }
//
//    public Iterable<T> findAllById(Iterable<ID> iterable) {
//        return baseService.findAllById(iterable);
//    }
//
//    public void delete(T t) {
//        baseService.delete(t);
//    }
//
//    public void deleteAll(Iterable<? extends T> iterable) {
//        baseService.deleteAll(iterable);
//    }
//
//    public Iterable<T> findAll(Sort sort) {
//        return baseService.findAll(sort);
//    }
//
//    public Page<T> findAll(Pageable pageable) {
//        return baseService.findAll(pageable);
//    }

}
