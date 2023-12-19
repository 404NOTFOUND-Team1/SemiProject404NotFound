package com.nf.not404found.main;


import com.nf.not404found.main.mainservice.MainService;
import com.nf.not404found.main.model.dto.MainPageProductDTO;
import com.nf.not404found.product.model.dto.ProductPageDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    private final MainService service;
    public MainController(MainService service){
        this.service = service;
    }
//    @GetMapping("/")
//    public String defaultLocation(){
//
//        return "index";
//    }
    @GetMapping("/")
    public ModelAndView showMainPage(ModelAndView mv){
        List<MainPageProductDTO> list = service.showMainPageProduct();
        mv.addObject("products",list);
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("member/login") 
    public String logIn(){
        return "member/login";
    }
    @GetMapping("member/signup")
    public String signUp(){
        return "member/signup";
    }
    @GetMapping("productPage")
    public ModelAndView showProduct(@RequestParam String  product_name, ModelAndView mv){
        System.out.println(product_name);
        List<ProductPageDTO> list = service.getProduct(product_name);
        mv.addObject("products",list);
        mv.setViewName("productpage/productPage");
        return mv;
    }
}
