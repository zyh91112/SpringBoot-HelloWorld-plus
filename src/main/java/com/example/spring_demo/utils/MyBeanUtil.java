package com.example.spring_demo.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yinghua
 * Created on 2018/6/5.
 */
public class MyBeanUtil {

    public static String[] getNullPropNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    /**
     * 复制source中的非null字段到target中
     *
     * @param source 复制源
     * @param target 复制目的
     */
    public static void copyNotNullPropFromSource(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropNames(source));
    }

    /**
     * 获取实体类的Id(有@Id注解的属性)在数据库中的字段名
     *
     * @param object 实体类对象
     * @return id的字段名，若有@Column且name不为空则为该值，否则为类的Id字段名
     */
    public static String getEntityIdColnum(Object object) {
        // 先检查该类是不是@Entity
        if (object.getClass().getDeclaredAnnotation(Entity.class) == null) {
            throw new IllegalArgumentException(object.getClass().getName() + " 没有@Entity注解，不是一个实体类。");
        }
        for (Field field : object.getClass().getDeclaredFields()) {
            if (field.getDeclaredAnnotation(Id.class) != null) {
                Column column = field.getDeclaredAnnotation(Column.class);
                if (column != null && !StringUtils.isEmpty(column.name())) {
                    return column.name();
                } else {
                    // TODO 应该把name由驼峰转换成_分割的形式
                    return field.getName();
                }
            }
        }
        // 不存在@Id字段
        throw new IllegalArgumentException(object.getClass().getName() + " 不存在被@Id注解的字段。");
    }
}
