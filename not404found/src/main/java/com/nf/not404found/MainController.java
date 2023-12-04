package com.nf.not404found;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "board/notice/list"})
    public String adminProductModify(){

        return "board/notice/list";
    }
}
