package com.example.kracedemo.service;

import com.example.kracedemo.entity.mysql.Role;
import com.example.kracedemo.entity.mysql.UserRole;

import java.util.List;

public interface UserRoleService {
    public List<Role> findRolesByUserId(Integer userId);
    public List<UserRole> findAll();
}
