package com.example.kracedemo.controller.mq;

import com.example.kracedemo.entity.Response;
import com.example.kracedemo.entity.BoardMessage;
import com.example.kracedemo.entity.BoardMessageRequest;
import com.example.kracedemo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mq")
public class ConsumerController {
  @Autowired private BoardService boardService;

  @ResponseBody
  @PostMapping("/board/message")
  public Response create(@RequestBody BoardMessageRequest request) {
    //    TODO: check privilege
    String s = String.format("%s, %s", request.getPostUserId(), request.getMessage());
    System.out.println(s);

    try {
      Long newMessageId =
          boardService.create(new BoardMessage(request.getPostUserId(), request.getMessage()));
      return new Response(200, newMessageId.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Response(400, "register error");
  }
}
