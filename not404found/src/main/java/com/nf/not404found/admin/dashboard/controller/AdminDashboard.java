package com.nf.not404found.admin.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminDashboard {

    /**
     * Dashboard페이지 이동 메소드
     */
    @GetMapping("dashboard")
    public String dashboardPage(Model model){

        model.addAttribute("boardType", "대시보드");


        return "/admin/dashboard/admin";
    }
}
