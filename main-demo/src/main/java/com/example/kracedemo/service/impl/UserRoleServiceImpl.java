package com.example.kracedemo.service.impl;

import com.example.kracedemo.entity.mysql.Role;
import com.example.kracedemo.entity.mysql.UserRole;
import com.example.kracedemo.mapper.UserRoleMapper;
import com.example.kracedemo.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;

    public List<Role> findRolesByUserId(Integer userId) {
        return userRoleMapper.findRolesByUserId(userId);
    }

    public List<UserRole> findAll() {
        return userRoleMapper.findAll();
    }
}
