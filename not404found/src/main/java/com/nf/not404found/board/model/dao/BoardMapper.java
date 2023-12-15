package com.nf.not404found.board.model.dao;

import com.nf.not404found.board.model.dto.BoardDTO;
import com.nf.not404found.board.model.dto.CommentDTO;
import com.nf.not404found.board.model.dto.ReviewDTO;
import com.nf.not404found.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    int selectTotalCount(Map<String, Object> searchMap);

    List<BoardDTO> selectBoardList(Map<String, Object> selectCriteria2);

    int incrementBoardCount(int post_code);

    BoardDTO selectNoticeView(int post_code);

    List<ReviewDTO> selectReviewList(Map<String, Object> selectCriteria2);

    int insertNotice(BoardDTO board);

    int getTotalReviewCountByProduct(int product_code);

    BoardDTO selectQnaView(int post_code);

    List<CommentDTO> selectQnaCommentList(int post_code);

    int insertQnaComment(CommentDTO registComment);

    int deleteQnaComment(int commentCode);

    int updateNotice(BoardDTO board);


    int deleteNotice(int postCode);

}
