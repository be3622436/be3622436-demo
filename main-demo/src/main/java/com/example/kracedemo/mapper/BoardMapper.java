package com.example.kracedemo.mapper;

import com.example.kracedemo.entity.BoardMessage;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardMessage> findAll();

    BoardMessage findById(Long id);

    Long create(BoardMessage boardMessage);

    void delete(Long id);

    void update(BoardMessage boardMessage);

    List<BoardMessage> findByDatetime(Date startDate, Date endDate);
}
