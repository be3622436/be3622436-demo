package com.example.kracedemo.entity.mysql;

import java.io.Serializable;
import java.util.Date;

public class BoardMessage implements Serializable {

  private Long id;
  private Long postUserId;
  private String message;
  private Date createdAt;
  private Date updatedAt;

  public BoardMessage(Long postUserId, String message) {
    this.postUserId = postUserId;
    this.message = message;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getPostUserId() {
    return postUserId;
  }

  public void setPostUserId(Long postUserId) {
    this.postUserId = postUserId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
}
