package com.nf.not404found.admin.event.controller;


import com.nf.not404found.admin.event.model.dto.AdminEventDTO;
import com.nf.not404found.admin.event.model.service.AdminEventServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/*")
public class AdminEventController {

    private final AdminEventServiceImpl eventService;

    public AdminEventController(AdminEventServiceImpl eventService) {
        this.eventService = eventService;
    }


    @GetMapping("event")
    public ModelAndView eventPage(ModelAndView mv){

        mv.addObject("boardType", "이벤트");
        mv.setViewName("/admin/event/admin");

        List<AdminEventDTO> eventList = eventService.selectAllEvent();

        mv.addObject("eventList", eventList);



        return mv;
    }

    @GetMapping("event/insert")
    public String eventPage2(Model model){
        model.addAttribute("boardType", "이벤트");


        return "/admin/event/insert";
    }
}



