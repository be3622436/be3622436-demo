package com.example.kracedemo.service;

import com.example.kracedemo.entity.User;

public interface UserService extends BaseService<User> {
    User findByName(String name);
}
