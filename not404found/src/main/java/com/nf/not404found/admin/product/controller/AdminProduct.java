package com.nf.not404found.admin.product.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminProduct {

    @GetMapping("product")
    public String productMainPage(Model model){

        model.addAttribute("boardType", "상품 관리");

        return "/admin/product/select";
    }
    @GetMapping("product/insert")
    public String productInsertPage(Model model){

        model.addAttribute("boardType", "상품 관리");

        return "/admin/product/insert";
    }
    @GetMapping("product/modify")
    public String productModifyPage(Model model){

        model.addAttribute("boardType", "상품 관리");

        return "/admin/product/modify";
    }
}
