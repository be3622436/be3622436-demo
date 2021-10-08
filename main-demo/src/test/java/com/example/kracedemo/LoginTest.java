package com.example.kracedemo;

import com.example.kracedemo.controller.LoginController;
import com.example.kracedemo.entity.Response;
import com.example.kracedemo.entity.mysql.User;
import com.example.kracedemo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.HashMap;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoginController.class)
public class LoginTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private UserService userService;

  @Test
  public void alreadyLoginTest() throws Exception {
    HashMap<String, Object> sessionAttr = new HashMap<>();
    User user = new User();
    user.setId(3L);
    user.setUsername("krace");
    user.setPassword("123");
    sessionAttr.put("user", user);
    loginTest(3L, "krace", "123", "123", 200, "already login", sessionAttr);
  }

  @Test
  public void loginWithWrongPasswordTest() throws Exception {
    loginTest(3L, "krace", "123", "456", 400, "incorrect password", null);
  }

  @Test
  public void loginWithCorrectPasswordTest() throws Exception {
    loginTest(3L, "krace", "123", "123", 200, "3", null);
  }

  public void loginTest(
      Long userId,
      String inputName,
      String inputPwd,
      String CorrectPwd,
      int statusCode,
      String message,
      HashMap<String, Object> sessionAttr)
      throws Exception {

    MockHttpServletRequestBuilder postRequest =
        post("/login")
            .contentType(MediaType.MULTIPART_FORM_DATA)
            .param("username", inputName)
            .param("password", inputPwd);

    if (sessionAttr != null) {
      postRequest.sessionAttrs(sessionAttr);
    }

    User user = new User();
    user.setId(userId);
    user.setPassword(CorrectPwd);
    when(userService.findByName(inputName)).thenReturn(user);
    ObjectMapper objectMapper = new ObjectMapper();
    MvcResult result = mockMvc.perform(postRequest).andExpect(status().isOk()).andReturn();
    Response response =
        objectMapper.readValue(result.getResponse().getContentAsString(), Response.class);
    Assertions.assertNotNull(response);
    Assertions.assertEquals(response.getStatusCode(), statusCode);
    Assertions.assertEquals(response.getMessage(), message);
  }
}
