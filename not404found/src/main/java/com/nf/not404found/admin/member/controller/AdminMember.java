package com.nf.not404found.admin.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminMember {

    @GetMapping("member")
    public String memberPage(){

        return "/admin/member/admin";
    }


}
