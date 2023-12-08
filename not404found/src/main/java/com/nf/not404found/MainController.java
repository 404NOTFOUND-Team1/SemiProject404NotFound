package com.nf.not404found;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String defaultLocation(){
        return "index";
    }
    @GetMapping("member/login")
    public String logIn(){
        return "member/login";
    }
    @GetMapping("member/signup")
    public String signUp(){
        return "member/signup";
    }
}
