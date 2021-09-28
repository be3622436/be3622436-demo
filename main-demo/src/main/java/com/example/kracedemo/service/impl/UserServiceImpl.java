package com.example.kracedemo.service.impl;

import com.example.kracedemo.entity.User;
import com.example.kracedemo.mapper.UserMapper;
import com.example.kracedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserMapper userMapper;

  @Override
  public List<User> findAll() {
    return userMapper.findAll();
  }

  @Override
  public User findById(Long id) {
    return userMapper.findById(id);
  }

  @Override
  public Long create(User user) {
    return userMapper.create(user);
  }

  @Override
  public void delete(Long... ids) {
    for (Long id : ids) {
      userMapper.delete(id);
    }
  }

  @Override
  public void update(User user) {
    userMapper.update(user);
  }

  @Override
  public User findByName(String name) {
    return userMapper.findByName(name);
  }
}
