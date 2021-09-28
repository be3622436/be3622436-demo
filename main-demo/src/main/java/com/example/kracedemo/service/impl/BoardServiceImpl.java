package com.example.kracedemo.service.impl;

import com.example.kracedemo.entity.BoardMessage;
import com.example.kracedemo.mapper.BoardMapper;
import com.example.kracedemo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
  @Autowired private BoardMapper boardMapper;

  @Override
  public List<BoardMessage> findAll() {
    return boardMapper.findAll();
  }

  @Override
  public BoardMessage findById(Long id) {
    return boardMapper.findById(id);
  }

  @Override
  public Long create(BoardMessage boardMessage) {
    return boardMapper.create(boardMessage);
  }

  @Override
  public void delete(Long... ids) {
    for (Long id : ids) {
      boardMapper.delete(id);
    }
  }

  @Override
  public void update(BoardMessage boardMessage) {
    boardMapper.update(boardMessage);
  }

  @Override
  public List<BoardMessage> findByDatetime(Date startDate, Date endDate) {
    return boardMapper.findByDatetime(startDate, endDate);
  }
}
