package com.nf.not404found.order.controller;


import com.nf.not404found.order.model.service.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/order/*")
public class OrderController {

    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
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

    @GetMapping("orderMember")
    public String orderMemberPage(){

        log.info("=============================================> orderMember 매핑 확인");


        return "/order/orderMember";
    }

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
