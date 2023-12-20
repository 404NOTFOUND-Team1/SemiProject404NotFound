package com.nf.not404found.order.controller;


import com.nf.not404found.common.functions.UserInformation;
import com.nf.not404found.order.model.dto.OrderDTO;
import com.nf.not404found.order.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/order/*")
public class OrderController {

    private final OrderService service;
    private final UserInformation user;
    public OrderController(OrderService service,UserInformation user) {
        this.service = service;
        this.user = user;
    }

    @GetMapping("orderComplete")
    public String orderEndPage(){

        log.info("=============================================> orderEnd 매핑 확인");


        return "/order/orderComplete";
    }

    @GetMapping("orderFailure")
    public String orderFailurePage(){

        log.info("=============================================> orderFailure 매핑 확인");


        return "/order/orderFailure";
    }

//    @PostMapping(value = "orderMember", produces = "application/json; charset=utf-8")
    @PostMapping("orderMember")
    public String orderMemberPage(@RequestParam String productName,
                                @RequestParam int amount,
                                @RequestParam int mileage,
                                @RequestParam int deliveryCost,
                                @RequestParam String price,
                                Model model) {
        List<String> coupon = user.getCoupon();
        System.out.println("coupon = " + coupon);
        OrderDTO orderInfor = service.getOrderInfor(user.getId());
        model.addAttribute("productName",productName);
        model.addAttribute("amount",amount);
        model.addAttribute("mileage",mileage);
        model.addAttribute("deliveryCost",deliveryCost);
        model.addAttribute("price",price);
        model.addAttribute("grade",orderInfor.getGrade());
        model.addAttribute("rate",orderInfor.getMileageRate());
        model.addAttribute("mileage",orderInfor.getMileage());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("name",user.getName());
        model.addAttribute("phone",user.getPhone());
        model.addAttribute("addr",user.getAddr());
        model.addAttribute("addrDetail",user.getAddrDetail());
        return "/order/orderMember";
    }
//    @GetMapping("orderMember")
//    public String orderMemberPage(){
//        return "/order/orderMember";
//    }

    @GetMapping("orderNonMember")
    public String orderNonMemberPage(){

        log.info("=============================================> orderNonMember 매핑 확인");


        return "/order/orderNonMember";
    }

    @GetMapping("payment")
    public String paymentPage(){

        log.info("=============================================> payment 매핑 확인");


        return "/order/payment";
    }


    @GetMapping("shoppingCart")
    public String shoppingCartPage(){

        log.info("=============================================> shoppingCart 매핑 확인");


        return "/order/shoppingCart";
    }
}
