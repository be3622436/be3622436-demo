package com.example.kracedemorocketmqconsumer;

import com.example.kracedemorocketmqconsumer.entity.BoardMessageRequest;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
public class KraceDemoRocketmqConsumerApplication implements CommandLineRunner {
//    TODO: wait to fix bug
//    @Resource
//    private RocketMQTemplate rocketMQTemplate;

    public static void main(String[] args) {
        SpringApplication.run(KraceDemoRocketmqConsumerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        List<BoardMessageRequest> messages = rocketMQTemplate.receive(BoardMessageRequest.class);
//        System.out.printf("receive from rocketMQTemplate, messages=%s", messages);
    }
}
