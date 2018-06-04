package com.example.spring_demo.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * @author yinghua
 * Created on 2018/5/28.
 */
//@XmlRootElement 有该注解则该实体作为controller方法返回值时，可被转换成xml格
@Entity
public class User {
    @Id
    private String username;
    private String nickname;
    @Column(nullable = false)
    private String password;
    private Date createAt;
    private Date updateAt;

    public User() { }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
