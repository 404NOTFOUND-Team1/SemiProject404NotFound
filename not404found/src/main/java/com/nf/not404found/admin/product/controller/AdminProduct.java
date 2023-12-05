package com.nf.not404found.admin.product.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminProduct {

    @GetMapping("product")
    public String productMainPage(){

        return "/admin/product/select";
    }
    @GetMapping("product/insert")
    public String productInsertPage(){

        return "/admin/product/insert";
    }
    @GetMapping("product/modify")
    public String productModifyPage(){

        return "/admin/product/modify";
    }
}
