package com.example.kracedemo.service.impl;

import com.example.kracedemo.entity.mysql.User;
import com.example.kracedemo.entity.mysql.UserInfo;
import com.example.kracedemo.mapper.UserMapper;
import com.example.kracedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PlatformTransactionManager transactionManager;

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
    public void insertUserList(List<User> userList) {
        userMapper.insertUserList(userList);
    }

    @Override
    public UserInfo findWithInfoById(Long id) {
        return userMapper.findWithInfoById(id);
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

    @Override
    public void tranTest(boolean throwErr) {
        TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
          userMapper.create(new User("vesta", "argon"));
          if (throwErr) {
              throw new Exception("tranTest throw new Exception");
          }
          transactionManager.commit(txStatus);
        } catch (Exception e) {
          transactionManager.rollback(txStatus);
//          throw e;
        }
    }
}
