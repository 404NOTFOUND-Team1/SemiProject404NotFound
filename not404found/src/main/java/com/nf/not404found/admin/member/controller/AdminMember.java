package com.nf.not404found.admin.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminMember {

    @GetMapping("member")
    public String memberPage(Model model){

        model.addAttribute("boardType", "회원 관리");


        return "/admin/member/admin";
    }
    @GetMapping("member/dormant")
    public String memberDormantPage(Model model){

        model.addAttribute("boardType", "회원 관리");


        return "/admin/member/dormant";
    }
    @GetMapping("member/blacked")
    public String memberBlackedPage(Model model){

        model.addAttribute("boardType", "회원 관리");


        return "/admin/member/blacked";
    }

}
