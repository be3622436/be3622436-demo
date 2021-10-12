package com.example.kracedemo.service;

import com.example.kracedemo.entity.mysql.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    User findByName(String name);
    void insertUserList(List<User> userList);
}
