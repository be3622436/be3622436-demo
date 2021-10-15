package com.example.kracedemo.entity.mysql;

import java.io.Serializable;

// one to one mapping
public class UserInfo extends User {
    private String email;
    private Integer sex;

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer newSex) {
        sex = newSex;
    }
}
