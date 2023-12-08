package com.nf.not404found.board.model.dao;

import com.nf.not404found.board.model.dto.BoardDTO;
import com.nf.not404found.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    int selectTotalCount(Map<String, Object> searchMap);

    List<BoardDTO> selectBoardList(Map<String, Object> selecttest);

    int incrementBoardCount(int post_code);

    BoardDTO selectNoticeView(int post_code);
}
