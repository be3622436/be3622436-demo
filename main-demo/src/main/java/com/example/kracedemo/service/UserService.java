package com.example.kracedemo.service;

import com.example.kracedemo.entity.mysql.User;
import com.example.kracedemo.entity.mysql.UserInfo;

import java.util.List;

public interface UserService extends BaseService<User> {
    User findByName(String name);
    void insertUserList(List<User> userList);
    UserInfo findWithInfoById(Long id);
    void tranTest(boolean throwErr);
    void tranTestV2();
}
