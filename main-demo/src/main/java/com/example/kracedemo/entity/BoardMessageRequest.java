package com.example.kracedemo.entity;

public class BoardMessageRequest {
    private Long postUserId;
    private String message;

    public BoardMessageRequest(Long userId, String msg) {
        postUserId = userId;
        message = msg;
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
}
