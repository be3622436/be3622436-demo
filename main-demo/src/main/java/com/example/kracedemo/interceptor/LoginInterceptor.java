package com.example.kracedemo.interceptor;

import com.example.kracedemo.entity.mysql.User;
import com.example.kracedemo.exception.common.NotLoginAccessException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class LoginInterceptor {
  @Autowired private HttpSession session;

  @Pointcut(
      "within(com.example.kracedemo.controller.HomeController) || "
          + "within(com.example.kracedemo.controller.board.*) || "
          + "within(com.example.kracedemo.controller.user.*)")
  public void requiredLoginPointCut() {}

  @Before("requiredLoginPointCut()")
  public void checkLogin(JoinPoint joinPoint) {
    User user = (User) session.getAttribute("user");
    if (user == null) {
      System.out.println("-----------user did not login-----------");
      throw new NotLoginAccessException();
    } else {
      System.out.println("-----------user already login-----------");
    }
  }
}
