package com.nf.not404found.board.model.service;

import com.nf.not404found.board.model.dao.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    public BoardServiceImpl(BoardMapper mapper) {
        this.mapper = mapper;
    }



}
