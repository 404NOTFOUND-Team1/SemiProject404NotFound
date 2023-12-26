package com.nf.not404found.common.exception.loginerror;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth")
public class LoginErrorHandler {


    @GetMapping("fail")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false)
                        String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/auth/fail";
    }
}
