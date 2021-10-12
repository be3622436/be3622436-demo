package com.example.kracedemo.controller.api.v1;

import com.example.kracedemo.entity.mysql.BoardMessage;
import com.example.kracedemo.entity.BoardMessageRequest;
import com.example.kracedemo.entity.Response;
import com.example.kracedemo.entity.mysql.User;
import com.example.kracedemo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/board")
public class BoardController {
  @Autowired private BoardService boardService;
  @Autowired private HttpSession session;
  @Value("${rocketmq.producer-board-message-url}")
  private String producerPort;
  // api
  @GetMapping(value = {"/getMessageByDate"})
  public List<BoardMessage> board(
      @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startDate,
      @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endDate) {
    return boardService.findByDatetime(startDate, endDate);
  }

  @ResponseBody
  @PostMapping("/message")
  public Response create(@RequestParam("message") String message) {
    try {
      User user = (User) session.getAttribute("user");

//      // insert directly
//      Long newMessageId = boardService.create(new BoardMessage(user.getId(), message));
//      return new Response(200, newMessageId.toString());

      // forward insert job to producer-server
      RestTemplate restTemplate = new RestTemplate();
      HttpEntity<BoardMessageRequest> request = new HttpEntity<>(new BoardMessageRequest(user.getId(), message));
      ResponseEntity<Response> response = restTemplate.exchange(producerPort, HttpMethod.POST, request, Response.class);
      Response r = response.getBody();
      int code = 400;
      String msg = "";
      if (r != null) {
        code = r.getStatusCode();
        msg = r.getMessage();
      }
      return new Response(code, msg);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Response(400, "create error");
  }

  @ResponseBody
  @GetMapping("/message")
  public List<BoardMessage> read() {
    // default last 1 year message
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.YEAR, -1);
    Date startDate = calendar.getTime();
    Date endDate = new Date();
    return boardService.findByDatetime(startDate, endDate);
  }

}
