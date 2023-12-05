package com.nf.not404found.reviewboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")
public class ReviewBoardController {

    /**
     * review페이지 이동 메소드
     */
    @GetMapping("review")
    public String reviewBoardLocation() {

        return "/board/review/review";
    }
}
