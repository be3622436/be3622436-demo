package com.example.kracedemo.controller;

import com.example.kracedemo.entity.TestJsonEntity;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class TestController {
    @ResponseBody
    @PostMapping(value = {"/json-test"})
    public Object postJsonTest(@RequestBody TestJsonEntity json) {
        return json;
    }

    @PostMapping("/redis-test")
    public String redisTest(@RequestBody TestJsonEntity json) throws IOException {
        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource = loader.getResource("redisson.yml");
        Config config = Config.fromYAML(resource.getInputStream());
        config.useClusterServers();
        RedissonClient redisson = Redisson.create(config);
        RMap<String, String> map = redisson.getMap("myMap");
        String key = json.geKey();
        String value = json.getValue();
        System.out.printf("key = %s, value = %s%n", key, value);
        String returnCode = map.put(key, value);
        redisson.shutdown();
        return returnCode;
    }
}