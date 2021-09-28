package com.example.kracedemo.service;

import com.example.kracedemo.entity.BoardMessage;

import java.util.Date;
import java.util.List;

public interface BoardService extends BaseService<BoardMessage> {
    List<BoardMessage> findByDatetime(Date startDate, Date endDate);
}
