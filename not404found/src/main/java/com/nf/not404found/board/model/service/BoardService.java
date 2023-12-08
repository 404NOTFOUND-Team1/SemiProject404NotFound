package com.nf.not404found.board.model.service;

import com.nf.not404found.board.model.dto.BoardDTO;
import com.nf.not404found.common.paging.SelectCriteria;

import java.util.List;
import java.util.Map;

public interface BoardService {

    public int selectTotalCount(Map<String, Object> searchMap);

    public List<BoardDTO> selectBoardList(Map<String, Object> selecttest);

    BoardDTO selectNoticeView(int post_code);
}
