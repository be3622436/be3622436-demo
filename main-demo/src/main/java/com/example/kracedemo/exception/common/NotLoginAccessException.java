package com.example.kracedemo.exception.common;

public class NotLoginAccessException extends RuntimeException {
    public final static Integer errCode = 2001;
    public final static String errMsg = "access need to be login";
}
