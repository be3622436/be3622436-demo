package com.example.kracedemo.controller.api;

import com.example.kracedemo.entity.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class HealthController {
    @RequestMapping(value = {"/healthCheck"})
    public Response healthCheck() {
        return new Response(200, "server is health");
    }
}
