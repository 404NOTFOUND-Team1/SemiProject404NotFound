package com.nf.not404found.noticeboard.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class NoticeBoardController {

    /**
     * 공지사항 페이지 이동 메소드
     */
    @GetMapping("notice/*")
    public String noticeBoardLocation() {

        return "/board/notice/list";
    }
}