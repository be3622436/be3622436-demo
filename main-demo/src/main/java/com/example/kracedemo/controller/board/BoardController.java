package com.example.kracedemo.controller.board;

import com.example.kracedemo.entity.BoardMessage;
import com.example.kracedemo.entity.Response;
import com.example.kracedemo.entity.User;
import com.example.kracedemo.service.BoardService;
import com.example.kracedemo.utility.SessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
  @Autowired private BoardService boardService;
  @Autowired private HttpSession session;

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
      Long newMessageId = boardService.create(new BoardMessage(user.getId(), message));
      return new Response(200, newMessageId.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return new Response(400, "register error");
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
  // view
  @GetMapping(value = {"", "/"})
  public ModelAndView page() {
    return new ModelAndView("board/index");
  }
}
