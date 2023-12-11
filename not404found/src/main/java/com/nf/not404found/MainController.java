package com.nf.not404found;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = { "mypage/main/*"})
    public String adminProductModify(){

        return "mypage/main/ShippingAddressManagement";       //admin/product/modify
    }

    @GetMapping("/")
    public String defaultLocation(){
        return "index";
    }
}
