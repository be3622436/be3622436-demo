package com.example.kracedemo.entity.mysql;

import java.io.Serializable;

public class Role implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
