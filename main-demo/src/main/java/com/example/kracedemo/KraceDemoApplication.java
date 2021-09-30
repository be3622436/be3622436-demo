package com.example.kracedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@SpringBootApplication
public class KraceDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(KraceDemoApplication.class, args);
  }
}
