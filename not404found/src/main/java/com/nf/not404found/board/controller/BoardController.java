package com.nf.not404found.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    /**
     * 공지사항 리스트 페이지 이동 메소드
     */
    @GetMapping("notice/*")
    public String noticeBoardLocation() {

        return "/board/notice/list";
    }

    /**
     * QnA 리스트 페이지 이동 메소드
     */
    @GetMapping("/qna/*")
    public String QnABoardLocation() {

        return "/board/qna/list";
    }
}