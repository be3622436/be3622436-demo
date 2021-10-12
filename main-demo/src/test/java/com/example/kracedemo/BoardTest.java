package com.example.kracedemo;

import com.example.kracedemo.controller.api.v1.BoardController;
import com.example.kracedemo.service.BoardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(BoardController.class)
public class BoardTest {

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;
  @MockBean private BoardService boardService;

  // TODO: wait to mock RestTemplate
  @Test
  public void createShouldReturnIdFromService() throws Exception {
//    when(boardService.create(new BoardMessage(0L, "test-msg"))).thenReturn(99L);

//    HashMap<String, Object> sessionAttr = new HashMap<>();
//    sessionAttr.put("user", new User());
//
//    MvcResult result =
//        mockMvc
//            .perform(
//                post("/board/message")
//                    .contentType(MediaType.MULTIPART_FORM_DATA)
//                    .param("message", "test-msg")
//                    .sessionAttrs(sessionAttr))
//            .andExpect(status().isOk())
//            .andReturn();
//    Response response =
//        objectMapper.readValue(result.getResponse().getContentAsString(), Response.class);
//    Assertions.assertNotNull(response);
//    Assertions.assertEquals(response.getStatusCode(), 200);
//    Assertions.assertEquals(response.getMessage(), "0");
  }
}
