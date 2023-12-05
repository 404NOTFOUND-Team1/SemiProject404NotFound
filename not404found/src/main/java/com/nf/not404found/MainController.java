package com.nf.not404found;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = { "admin/product/modify"})
    public String adminProductModify(){

        return "admin/product/modify";
    }

    @GetMapping("/")
    public String defaultLocation(){
        return "index";
    }
}
