package com.example.kracedemo.controller;

import com.example.kracedemo.entity.TestJsonEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @ResponseBody
    @PostMapping(value = {"/test"})
    public Object postJsonTest(@RequestBody TestJsonEntity json) {
        return json;
    }
}