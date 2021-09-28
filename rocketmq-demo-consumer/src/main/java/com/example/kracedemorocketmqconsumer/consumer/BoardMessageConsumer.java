package com.example.kracedemorocketmqconsumer.consumer;

import com.example.kracedemorocketmqconsumer.entity.BoardMessageRequest;
import com.example.kracedemorocketmqconsumer.entity.Response;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RocketMQMessageListener(
        topic = "${config.rocketmq.boardTopic}",
        consumerGroup = "${rocketmq.consumer.group}"
        //accessKey = "AK" // It will read by `rocketmq.consumer.access-key` key
        //secretKey = "SK" // It will read by `rocketmq.consumer.secret-key` key
)
public class BoardMessageConsumer implements RocketMQListener<BoardMessageRequest> {
    @Value("${config.boardMessageCreateUrl}")
    private String boardMessageCreateUrl;

    @Override
    public void onMessage(BoardMessageRequest request) {
        System.out.printf("------- BoardMessageRequest received: %s \n", request);
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<BoardMessageRequest> postRequest = new HttpEntity<>(request);
            Response response = restTemplate.postForObject(boardMessageCreateUrl, postRequest, Response.class);
            if (response != null && response.getStatusCode() == 200) {
                System.out.printf("------- BoardMessageRequest process success, response message: %s \n", response.getMessage());
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
                System.out.printf("------- BoardMessageRequest process failed, error message: %s \n", e.getMessage());
        }
    }
}
