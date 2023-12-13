package com.nf.not404found.admin.event.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminEvent {

    @GetMapping("event")
    public String eventPage(Model model){

        model.addAttribute("boardType", "이벤트");

        return "/admin/event/admin";
    }

    @GetMapping("event/insert")
    public String eventPage2(Model model){
        model.addAttribute("boardType", "이벤트");

        return "/admin/event/insert";
    }
}



