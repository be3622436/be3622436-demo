package com.example.kracedemo.controller;

import com.example.kracedemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
  @Autowired private HttpSession session;

  @GetMapping(value = {"/", "/index"})
  public String index() {
    return "home/index";
  }
}
