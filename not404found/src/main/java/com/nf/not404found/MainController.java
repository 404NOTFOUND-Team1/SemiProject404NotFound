package com.nf.not404found;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("member/pwdFind")
    public String pwdFind(){
        return "member/pwdFind";
    }
    @GetMapping("member/pwdFindCertification")
    public String pwdFindCertification() {
        return "member/pwdFindCertification";
    }
//    @GetMapping("member/pwdChange")
//    public String pwdChange(){
//        return "member/pwdChange";
//    }

}
