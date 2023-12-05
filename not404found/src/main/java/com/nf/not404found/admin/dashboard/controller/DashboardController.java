package com.nf.not404found.admin.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class DashboardController {

    /**
     * Dashboard페이지 이동 메소드
     */
    @GetMapping("dashboard")
    public String dashboardLocation() {

        return "/admin/dashboard/admin";
    }
}
