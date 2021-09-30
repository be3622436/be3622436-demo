package com.example.kracedemo.entity;

public class TestJsonEntity {
  private String key;
  private String value;

  public TestJsonEntity() {}

  public TestJsonEntity(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String geKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
