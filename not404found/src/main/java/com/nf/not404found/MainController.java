package com.nf.not404found;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/admin/product/select")
    public String adminProductModify(){

        return "admin/product/select";
    }
//    @GetMapping("board/notice/list")
//    public String boardList(){
//        return "board/notice/list";
//    }
//    @GetMapping("board/notice/view")
//    public String boardView(){
//        return "board/notice/view";
//    }
//    @GetMapping("board/review/review")
//    public String boardReview(){
//        return "board/review/review";
//    }
//    @GetMapping("/")
//    public String defaultLocation(){
//        return "index";
//    }
//    @GetMapping("member/login")
//    public String logIn(){
//        return "member/login";
//    }
//    @GetMapping("member/signup")
//    public String signUp(){
//        return "member/signup";
//    }
}
