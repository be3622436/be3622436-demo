package com.example.kracedemo.controller.user;

import com.example.kracedemo.entity.User;
import com.example.kracedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired private UserService userService;

  @GetMapping("/findAll")
  public List<User> findAll() {
    return userService.findAll();
  }
}
