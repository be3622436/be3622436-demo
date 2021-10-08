package com.example.kracedemo.exception;

import com.example.kracedemo.exception.common.NotLoginAccessException;
import com.example.kracedemo.view.JsonResponseView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * handle global exception exclude controller's exception
 */
@Component
public class GlobalServerExceptionHandler extends AbstractHandlerExceptionResolver {

  private static final Logger logger =
      LoggerFactory.getLogger(GlobalServerExceptionHandler.class);

  @Override
  protected ModelAndView doResolveException(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      Exception exception) {
    try {
      Map<String, Object> jsonMap = new HashMap<>();
      if (exception instanceof NotLoginAccessException) {
        jsonMap.put("code", NotLoginAccessException.errCode);
        jsonMap.put("message", NotLoginAccessException.errMsg);
        return new JsonResponseView(jsonMap);
      }
    } catch (Exception handlerException) {
      logger.warn(
          "Handling of [{}] resulted in Exception",
          exception.getClass().getName(),
          handlerException);
    }
    return null;
  }
}
