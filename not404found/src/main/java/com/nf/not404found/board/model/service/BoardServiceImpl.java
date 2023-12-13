package com.nf.not404found.board.model.service;

import com.nf.not404found.board.model.dao.BoardMapper;
import com.nf.not404found.board.model.dto.BoardDTO;
import com.nf.not404found.board.model.dto.CommentDTO;
import com.nf.not404found.board.model.dto.ReviewDTO;
import com.nf.not404found.common.exception.board.CommentRegistException;
import com.nf.not404found.common.exception.board.NoticeWriteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<BoardDTO> selectBoardList(Map<String, Object> selectCriteria2) {

        List<BoardDTO> boardList = mapper.selectBoardList(selectCriteria2);
        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectBoardList ===================== {}", boardList);

        return boardList;
    }

    @Override
    @Transactional
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

    @Override
    public List<ReviewDTO> selectReviewList(Map<String, Object> selectCriteria2) {

        List<ReviewDTO> reviewList = mapper.selectReviewList(selectCriteria2);

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectReviewList ===================== {}", reviewList);

        return reviewList;
    }

    @Override
    @Transactional
    public void writeNotice(BoardDTO board) throws NoticeWriteException {

        int result = mapper.insertNotice(board);

        if (!(result > 0)) {
            throw new NoticeWriteException("게시글 등록에 실패하셨습니다.");
        }
    }

    @Override
    public List<ReviewDTO> getTotalReviewCountByProduct(List<ReviewDTO> reviewList) {

        for(int i = 0; i < reviewList.size(); i++){
            int result = mapper.getTotalReviewCountByProduct(reviewList.get(i).getProduct().getProduct_code());

            reviewList.get(i).setReviewCount(result);
        }


        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  getTotalReviewCountByProduct ===================== {}", reviewList);

        return reviewList;
    }

    @Override
    @Transactional
    public BoardDTO selectQnaView(int post_code) {
        BoardDTO qnaView = null;

        /* 조회수 증가 */
        int result = mapper.incrementBoardCount(post_code);

        if (result > 0) {
            qnaView = mapper.selectQnaView(post_code);
        }

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectNoticeView ===================== {}", qnaView);

        return qnaView;
    }

    /**
     * QnA 게시글 댓글 조회용 메소드
     */
    @Override
    public List<CommentDTO> selectQnaCommentList(int post_code) {

        List<CommentDTO> qnaCommentList = null;

        qnaCommentList = mapper.selectQnaCommentList(post_code);

        log.info("");
        log.info("");
        log.info("[BoardServiceImpl]  selectQnaCommentList ===================== {}", qnaCommentList);

        return qnaCommentList;
    }

    @Override
    @Transactional
    public List<CommentDTO> registQnaComment(CommentDTO registComment) throws CommentRegistException {
        List<CommentDTO> qnaCommentList = null;

        int result = mapper.insertQnaComment(registComment);

        if (result > 0) {
            qnaCommentList = mapper.selectQnaCommentList(registComment.getComment_code());
        } else {
            throw new CommentRegistException("댓글 등록에 실패하셨습니다.");
        }

        return qnaCommentList;
    }
}
