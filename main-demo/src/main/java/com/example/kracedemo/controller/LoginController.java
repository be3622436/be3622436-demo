package com.example.kracedemo.controller;

import com.example.kracedemo.entity.Response;
import com.example.kracedemo.entity.User;
import com.example.kracedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

  @Autowired private UserService userService;
  @Autowired private HttpSession session;

  // api

  @ResponseBody
  @PostMapping("/login")
  public Response login(
      @RequestParam("username") String username, @RequestParam("password") String password) {
    System.out.println("username:" + username + ", password:" + password);

    User user = (User) session.getAttribute("user");
    // check user already login
    if (user != null) {
      return new Response(200, "already login");
    }
    user = userService.findByName(username);
    if (user != null) {
      if (user.getPassword().equals(password)) {
        session.setAttribute("user", user);
        return new Response(200, user.getId().toString());
      } else {
        return new Response(400, "incorrect password");
      }
    } else {
      return new Response(400, "user not exist");
    }
  }

  @PostMapping("/logout")
  public ModelAndView logout() {
    session.removeAttribute("user");
    return new ModelAndView("redirect:/index");
  }

  @ResponseBody
  @PostMapping("/register")
  public Response register(
      @RequestParam("username") String username, @RequestParam("password") String password) {
    try {
      User newUser = new User(username, password);
      userService.create(newUser);
      session.setAttribute("user", newUser);
      return new Response(200, username);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Response(400, "register error");
  }

  // view
  @GetMapping("/login")
  public ModelAndView login() throws Exception {
    User user = (User) session.getAttribute("user");
    if (user != null) {
      return new ModelAndView("redirect:/index");
    }
    return new ModelAndView("home/login");
  }

  @GetMapping("/redirect_login")
  public ModelAndView redirectLogin() {
    return new ModelAndView("home/redirect_login");
  }

  @GetMapping("/register")
  public ModelAndView register() {
    return new ModelAndView("home/register");
  }
}
