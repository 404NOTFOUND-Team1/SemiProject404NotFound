package com.nf.not404found.order.controller;


import com.nf.not404found.common.functions.UserInformation;
import com.nf.not404found.order.model.dto.OrderDTO;
import com.nf.not404found.order.model.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
                                @RequestParam int price,
                                @RequestParam int discountPrice,
                                Model model) {
        //디스카운트 프라이스는 null이 아니고,
        //할인 중인건 할인 중인 가격, 할인중이 아닌건 본 가격과 똑같이 나온다.
        // 그렇다면
        if(price == discountPrice){
            System.out.println("할인 중 아님");
            discountPrice = 0;
        } else {
            System.out.println("할인 중");
            discountPrice = price - discountPrice;
        }
        //으로 비교할 수 있을 것이다.
        List<String> coupon = user.getCoupon();
        System.out.println("coupon = " + coupon);
        OrderDTO orderInfor = service.getOrderInfor(user.getId());
        model.addAttribute("coupon",user.getCoupon());
        model.addAttribute("productName",productName);
        model.addAttribute("amount",amount);
        model.addAttribute("mileage",mileage);
        model.addAttribute("deliveryCost",deliveryCost);
        model.addAttribute("price",price);
        model.addAttribute("discountPrice",discountPrice);
        model.addAttribute("grade",orderInfor.getGrade());
        model.addAttribute("rate",orderInfor.getMileageRate());
        model.addAttribute("userMileage",orderInfor.getMileage());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("name",user.getName());
        model.addAttribute("phone",user.getPhone());
        model.addAttribute("addr",user.getAddr());
        model.addAttribute("addrDetail",user.getAddrDetail());
        return "/order/orderMember";
    }
    @PostMapping("coupon")
    @ResponseBody
    public int getCouponRate(@RequestBody String coupon){
        System.out.println(coupon);
        return service.getCouponDiscountRate(coupon);
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
