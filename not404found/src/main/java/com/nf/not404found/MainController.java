package com.nf.not404found;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = {"/", "admin/dashboard/admin"})
    public String adminMainPage(){

        return "admin/dashboard/admin";
    }
//
//    @GetMapping("/")
//    public String defaultLocation(){
//        return "index";
//    }
}
