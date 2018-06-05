package com.example.spring_demo.entity.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Time;

/**
 * @author yinghua
 * Created on 2018/5/29.
 */
@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    String username;
    @Column(nullable = false)
    String content;

    @Column(nullable = false)
    Time createAt;
    @Column(nullable = false)
    Time updateAt;
}
