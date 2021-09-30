package com.example.kracedemo.controller;

import com.example.kracedemo.entity.RedissonCache;
import com.example.kracedemo.entity.TestJsonEntity;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
public class TestController {
  @ResponseBody
  @PostMapping(value = {"/json-test"})
  public Object postJsonTest(@RequestBody TestJsonEntity json) {
    return json;
  }

  @PostMapping("/redis-test")
  public String postJsonToRedis(@RequestBody TestJsonEntity json) throws IOException {
    RedissonClient redisson = getRedissonClient();
    RMap<String, String> map = redisson.getMap("myMap");
    String key = json.geKey();
    String value = json.getValue();
    String returnCode = map.put(key, value);
    redisson.shutdown();
    System.out.printf("postJsonToRedis, key = %s, value = %s%n", key, value);
    return returnCode;
  }

  @PostMapping("/redis-test/key")
  public String getJsonFromRedis(@RequestBody TestJsonEntity json) throws IOException {
    RedissonClient redisson = getRedissonClient();
    RMap<String, String> map = redisson.getMap("myMap");
    Map<String, String> m = map.readAllMap();
    String key = json.geKey();
    String value = m.get(key);
    redisson.shutdown();
    System.out.printf("getJsonFromRedis, key = %s, value = %s%n", key, value);
    return value;
  }

  //  TODO: not work
  //  @PostMapping("/redis-test/cache")
  //  public String postCacheToRedis(@RequestBody TestJsonEntity json) throws IOException {
  //    RedissonCache cache = new RedissonCache("myCache");
  //    cache.setRedissonConfig("redisson.xml");
  //    String key = json.geKey();
  //    String value = json.getValue();
  //    cache.putObject(key, value);
  //    System.out.printf("postCacheToRedis, key = %s, value = %s%n", key, value);
  //    return "ok";
  //  }
  //
  //  @PostMapping("/redis-test/cache/key")
  //  public String getCacheToRedis(@RequestBody TestJsonEntity json) throws IOException {
  //    RedissonCache cache = new RedissonCache("myCache");
  //    cache.setRedissonConfig("redisson.xml");
  //    String key = json.geKey();
  //    String value = (String) cache.getObject(key);
  //    System.out.printf("getCacheToRedis, key = %s, value = %s%n", key, value);
  //    return value;
  //  }

  private RedissonClient getRedissonClient() throws IOException {
    ResourceLoader loader = new DefaultResourceLoader();
    Resource resource = loader.getResource("redisson.yml");
    Config config = Config.fromYAML(resource.getInputStream());
    config.useClusterServers();
    return Redisson.create(config);
  }
}
