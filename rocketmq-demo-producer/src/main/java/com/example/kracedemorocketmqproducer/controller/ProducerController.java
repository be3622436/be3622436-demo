package com.example.kracedemorocketmqproducer.controller;

import com.example.kracedemorocketmqproducer.entity.BoardMessageRequest;
import com.example.kracedemorocketmqproducer.entity.Response;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/producer")
public class ProducerController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @Value("${config.rocketmq.boardTopic}")
    private String boardTopic;
    @Value("${config.rocketmq.boardTopicTag}")
    private String boardTopicTag;

    @ResponseBody
    @PostMapping(value = {"/board/message"})
    public Response create(@RequestBody BoardMessageRequest request) {
        // TODO: check parameter

        // sync send message
        String topic = String.format("%s:%s", boardTopic, boardTopicTag);
        SendResult sendResult = rocketMQTemplate.syncSend(topic, request);
        System.out.printf("syncSend to topic '%s' sendResult=%s", boardTopic, sendResult);

        int statusCode = 500;
        String resultMsg = String.format("syncSend to topic '%s' failed!", boardTopic);
        if (sendResult != null) {
            statusCode = 200;
            resultMsg = String.format("syncSend to topic '%s' success, RocketMQ-MsgId = '%s'", boardTopic, sendResult.getMsgId());
        }
        Response response = new Response();
        response.setStatusCode(statusCode);
        response.setMessage(resultMsg);
        return response;
    }
}
