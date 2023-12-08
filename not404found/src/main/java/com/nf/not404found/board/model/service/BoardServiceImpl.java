package com.nf.not404found.board.model.service;

import com.nf.not404found.board.model.dao.BoardMapper;
import com.nf.not404found.board.model.dto.BoardDTO;
import com.nf.not404found.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
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
    public int selectTotalCount(Map<String, Object> searchMap) {

        int result = mapper.selectTotalCount(searchMap);
        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectTotalCount ===================== {}", result);

        return result;
    }

    /* 공지사항 & QnA 게시글 전체 리스트 조회용 메소드 */
    @Override
    public List<BoardDTO> selectBoardList(Map<String, Object> selecttest) {

        List<BoardDTO> boardList = mapper.selectBoardList(selecttest);
        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectBoardList ===================== {}", boardList);

        return boardList;
    }

    @Override
    public BoardDTO selectNoticeView(int post_code) {

        BoardDTO noticeView = null;

        /* 조회수 증가 */
        int result = mapper.incrementBoardCount(post_code);

        if (result > 0) {
            noticeView = mapper.selectNoticeView(post_code);
        }

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectNoticeView ===================== {}", noticeView);

        return noticeView;
    }
}
