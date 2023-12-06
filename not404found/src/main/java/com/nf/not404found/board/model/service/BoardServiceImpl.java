package com.nf.not404found.board.model.service;

import com.nf.not404found.board.model.dao.BoardMapper;
import com.nf.not404found.board.model.dto.BoardDTO;
import com.nf.not404found.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    public BoardServiceImpl(BoardMapper mapper) {
        this.mapper = mapper;
    }


    /* 공지사항 & QnA 게시글 전체 갯수 조회용 메소드 */
    @Override
    public int selectTotalCount(Map<String, String> searchMap) {

        int result = mapper.selectTotalCount(searchMap);
        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectTotalCount ===================== {}", result);

        return result;
    }

    /* 공지사항 & QnA 게시글 전체 리스트 조회용 메소드 */
    @Override
    public List<BoardDTO> selectBoardList(SelectCriteria selectCriteria) {

        List<BoardDTO> boardList = mapper.selectBoardList(selectCriteria);
        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectBoardList ===================== {}", boardList);

        return boardList;
    }
}
