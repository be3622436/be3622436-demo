package com.example.kracedemo.mapper;

import com.example.kracedemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> findAll();

    User findById(Long id);

    Long create(User user);

    void delete(Long id);

    void update(User user);

    User findByName(String name);
}