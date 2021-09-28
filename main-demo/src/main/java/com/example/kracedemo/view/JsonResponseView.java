package com.example.kracedemo.view;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Map;

public class JsonResponseView extends ModelAndView {
  public JsonResponseView(Map<String, Object> maps) {
    MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
    mappingJackson2JsonView.setAttributesMap(maps);
    this.setView(mappingJackson2JsonView);
  }
}
