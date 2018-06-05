package com.example.spring_demo.entity.po;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;


/**
 * @author yinghua
 * Created on 2018/5/28.
 */
//@XmlRootElement 有该注解则该实体作为controller方法返回值时，可被转换成xml格式
@Entity
@Data
public class User {
    @Id
    private String username;

    private String nickname;

    @Column(nullable = false)
    private String password;

    @CreatedDate @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @LastModifiedDate
    private Date updateAt;
}
