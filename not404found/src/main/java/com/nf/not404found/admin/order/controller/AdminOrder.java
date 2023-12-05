package com.nf.not404found.admin.order.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminOrder {

    @GetMapping("order")
    public String orderPage(Model model){

        model.addAttribute("boardType", "주문 관리");

        return "/admin/order/order";
    }
}
