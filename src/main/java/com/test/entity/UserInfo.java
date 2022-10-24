package com.test.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "user_info")
@Entity
public class UserInfo implements Serializable {

    @Id
    private Integer id ;
    private String name;
    private Integer age;
    private Integer sex;
}
