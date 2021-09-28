package com.example.kracedemo.exception;

import com.example.kracedemo.exception.common.TestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// TODO:
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

  public static final String TRACE = "trace";

//    @Value("${reflectoring.trace:false}")
//    private boolean printStackTrace;

//  // example
//  @ExceptionHandler({TestException.class})
//  public ResponseEntity<Object> handleTestException(TestException exception, WebRequest request) {
//    Map<String, Object> jsonMap = new HashMap<>();
//    jsonMap.put("code", TestException.errCode);
//    jsonMap.put("message", TestException.errMsg);
//    return new ResponseEntity<Object>(jsonMap, new HttpHeaders(), HttpStatus.FORBIDDEN);
//  }
}
