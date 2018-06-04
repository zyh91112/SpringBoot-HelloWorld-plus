package com.example.spring_demo.po;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Time getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Time createAt) {
        this.createAt = createAt;
    }

    public Time getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Time updateAt) {
        this.updateAt = updateAt;
    }
}
