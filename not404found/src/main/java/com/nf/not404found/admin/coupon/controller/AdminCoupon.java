package com.nf.not404found.admin.coupon.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminCoupon {

    @GetMapping("coupon")
    public String couponPage(Model model){

        model.addAttribute("boardType", "쿠폰");

        return "/admin/coupon/admin";
    }

    @GetMapping("coupon/insertCoupon")
    public String couponPage2(Model model){

        model.addAttribute("boardType", "쿠폰");

        return "/admin/coupon/insertCoupon";
    }
}
