package com.nf.not404found.board.controller;


import com.nf.not404found.board.model.dto.BoardDTO;
import com.nf.not404found.board.model.dto.ReviewDTO;
import com.nf.not404found.board.model.service.BoardService;
import com.nf.not404found.board.model.service.BoardServiceImpl;
import com.nf.not404found.common.exception.NoticeWriteException;
import com.nf.not404found.common.paging.Pagenation;
import com.nf.not404found.common.paging.SelectCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "notice/list")
    public ModelAndView noticeList(@RequestParam(required = false, defaultValue = "") String searchCondition,
                                  @RequestParam(required = false, defaultValue = "") String searchValue,
                                  @RequestParam(required = true, defaultValue = "1") int categorycode_board,
                                  @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                  ModelAndView mv) {

        log.info("");
        log.info("");
        log.info("[BoardController] ========================================================= start");
        /*
         * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
         * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
         */

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("categorycode_board", categorycode_board); // categorycode_board 추가

        log.info("[BoardController] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        /*
         * 전체 게시물 수가 필요하다.
         * 데이터베이스에서 먼저 전체 게시물 수를 조회해올 것이다.
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */

        int totalCount = boardService.selectTotalCount(searchMap);
        log.info("[BoardController] totalBoardCount : " + totalCount);

        /* 한 페이지에 보여줄 게시물 수 */
        int limit = 10;        //얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[BoardController] selectCriteria : " + selectCriteria);

        Map<String, Object> selectCriteria2 = new HashMap<>();
        selectCriteria2.put("selectCriteria", selectCriteria);
        selectCriteria2.put("categorycode_board", categorycode_board);

        /* 조회 */
        List<BoardDTO> boardList = boardService.selectBoardList(selectCriteria2);

        log.info("[BoardController] boardList : " + boardList);

        mv.addObject("boardList", boardList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[BoardController] SelectCriteria : " + selectCriteria);
        mv.setViewName("board/notice/list");

        log.info("[BoardController] ========================================================= end");
        return mv;
    }


    @GetMapping("/notice/view")
    public String selectNoticeView(@RequestParam int post_code, Model model) {

        log.info("");
        log.info("");
        log.info("[BoardController] ========================================================= start");

        BoardDTO noticeView = boardService.selectNoticeView(post_code);
        log.info("[BoardController] noticeView : " + noticeView);

        model.addAttribute("noticeView", noticeView);

        log.info("[BoardController] ========================================================= end");
        return "board/notice/view";
    }


    @GetMapping(value = "review/review")
    public ModelAndView reviewList(@RequestParam(required = false, defaultValue = "") String searchCondition,
                                   @RequestParam(required = false, defaultValue = "") String searchValue,
                                   @RequestParam(required = true, defaultValue = "2") int categorycode_board,
                                   @RequestParam(value="currentPage", defaultValue = "1") int pageNo,
                                   ModelAndView mv) {

        log.info("");
        log.info("");
        log.info("[BoardController / review] ========================================================= start");
        /*
         * 목록보기를 눌렀을 시 가장 처음에 보여지는 페이지는 1페이지이다.
         * 파라미터로 전달되는 페이지가 있는 경우 currentPage는 파라미터로 전달받은 페이지 수 이다.
         */

        Map<String, Object> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);
        searchMap.put("categorycode_board", categorycode_board); // categorycode_board 추가


        log.info("[BoardController / review] 컨트롤러에서 검색조건 확인하기 : " + searchMap);

        /*
         * 전체 게시물 수 조회
         * 검색조건이 있는 경우 검색 조건에 맞는 전체 게시물 수를 조회한다.
         */

        int totalCount = boardService.selectTotalCount(searchMap);
        log.info("[BoardController / review] totalBoardCount : " + totalCount);

        /* 한 페이지에 보여줄 게시물 수 */
        int limit = 5;        //얘도 파라미터로 전달받아도 된다.

        /* 한 번에 보여질 페이징 버튼의 갯수 */
        int buttonAmount = 5;

        /* 페이징 처리를 위한 로직 호출 후 페이징 처리에 관한 정보를 담고 있는 인스턴스를 반환받는다. */
        SelectCriteria selectCriteria = null;

        if (searchCondition != null && !"".equals(searchCondition)) {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount, searchCondition, searchValue);
        } else {
            selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
        }

        log.info("[BoardController / review] selectCriteria : " + selectCriteria);

        Map<String, Object> selectCriteria2 = new HashMap<>();
        selectCriteria2.put("selectCriteria", selectCriteria);
        selectCriteria2.put("categorycode_board", categorycode_board);

        /* 조회 */
        List<ReviewDTO> reviewList = boardService.selectReviewList(selectCriteria2);

        log.info("[BoardController] reviewList : " + reviewList);

        /* 상품코드 별 리뷰 누적 갯수 */
        List<ReviewDTO> totalReviewCountByProduct = boardService.getTotalReviewCountByProduct(reviewList);

        log.info("===================================> totalReviewCountByProduct : " + totalReviewCountByProduct);


        mv.addObject("totalReviewCountByProduct", totalReviewCountByProduct);

        mv.addObject("reviewList", reviewList);
        mv.addObject("selectCriteria", selectCriteria);
        log.info("[BoardController / review] SelectCriteria2 : " + selectCriteria2);
        mv.setViewName("board/review/review");

        log.info("[BoardController / review] ========================================================= end");
        return mv;
    }




    @GetMapping("notice/write")
    public String goNoticeWrite(Model model){

        return "/board/notice/write";
    }

    @PostMapping("notice/write")
    public String writeNotice(@ModelAttribute BoardDTO board, RedirectAttributes rttr) throws NoticeWriteException {

        log.info("");
        log.info("");
        log.info("[BoardController] writeNotice ========================================================= start");
        log.info("[BoardController] writeNotice Request : " + board);

        boardService.writeNotice(board);

        rttr.addFlashAttribute("message", "게시글 등록에 성공하셨습니다!");

        log.info("[BoardController] writeNotice ========================================================= end");

        return "redirect:/board/notice/list";
    }




    /**
     * QnA 리스트 페이지 이동 메소드
     */
    @GetMapping("/qna/*")
    public String QnABoardLocation() {

        return "/board/qna/list";
    }
}