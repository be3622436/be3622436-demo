package com.example.kracedemo.mapper;

import com.example.kracedemo.entity.mysql.Role;
import com.example.kracedemo.entity.mysql.UserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    List<Role> findRolesByUserId(Integer userId);

    List<UserRole> findAll();
}
