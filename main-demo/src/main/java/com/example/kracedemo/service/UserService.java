package com.example.kracedemo.service;

import com.example.kracedemo.entity.mysql.User;

public interface UserService extends BaseService<User> {
    User findByName(String name);
}
