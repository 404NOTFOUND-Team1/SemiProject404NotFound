package com.nf.not404found.admin.product.controller;


import com.nf.not404found.admin.product.model.dto.AdminProductCategoryDTO;
import com.nf.not404found.admin.product.model.dto.AdminProductDTO;
import com.nf.not404found.admin.product.model.service.AdminProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/admin/*")
@Slf4j
public class AdminProduct {

    private final AdminProductServiceImpl productService;

    public AdminProduct(AdminProductServiceImpl productService) {
        this.productService = productService;
    }

//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(int.class, new CustomNumberEditor(Integer.class, true));
//    }


    @GetMapping("product")
    public ModelAndView productMainPage(@RequestParam(required = false) String deleteStatus,
                                        @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date enterDate,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false, defaultValue = "0") int price,
                                        @RequestParam(required = false, defaultValue = "0") int amount,
                                        @RequestParam(required = false, defaultValue = "0") Integer refCategoryCode,
                                        @RequestParam(required = false) String categoryName,
                                        ModelAndView mv){

        log.info("");
        log.info("");
        log.info("들어왔나?-==========================================" );

        mv.addObject("boardType", "상품 관리");

        log.info("애드오브젝'=========================================");
        log.info("확인 ======================================================> name : {} ", name);
        log.info("확인 ======================================================> deleteStatus : {} ", deleteStatus);
        log.info("확인 ======================================================> enterDate : {} ", enterDate);
        log.info("확인 ======================================================> price : {} ", price);
        log.info("확인 ======================================================> amount : {} ", amount);
        log.info("확인 ======================================================> refCategoryCode : {} ", refCategoryCode);
        log.info("확인 ======================================================> categoryName : {} ", categoryName);

            List<AdminProductDTO> condition = null;

            int count = 0;
            // 검색결과 없을 때 하는거 처리하고 , 다른거 오류나는거 처리하고
        if (deleteStatus != null || enterDate != null || name != null || price != 0 || amount != 0 || refCategoryCode != 0 || categoryName != null){
            log.info("조건 들어왔나================================================>");

           AdminProductDTO product = new AdminProductDTO();
           product.setName(name);
           product.setPrice(price);
           product.setAmount(amount);
           product.setEnterDate(enterDate);
           product.setDeleteStatus(deleteStatus);
           AdminProductCategoryDTO category = new AdminProductCategoryDTO();
           category.setRefCategoryCode(refCategoryCode);
           category.setCategoryName(categoryName);
           product.setAdminProductCategory(category);



            condition = productService.selectConditionProduct(product);

            log.info("프로덕트 조건 넣어서 잘 들어왔어?+=====================================");

            mv.addObject("condition", condition);

            log.info("컨디션 상태 ===============================================> condition : " + condition);

            if (condition.isEmpty() ){
                log.info("00000000000000000000000000000000000000000000000000000000000000000000");
                count++;
            }

        }
        if (count == 0) {
            List<AdminProductDTO> productList = productService.selectAllProduct();

            log.info("전체 상품 목록 잘 들어왔냐 ================================================>");

            mv.addObject("productList", productList);

            log.info("전체 상품 목록======================================================== productList = " + productList);
        }

        mv.setViewName("/admin/product/select");

        return mv;
    }
    @GetMapping("product/insert")
    public String productInsertPage(Model model){

        model.addAttribute("boardType", "상품 관리");

        return "/admin/product/insert";
    }
    @GetMapping("product/modify")
    public String productModifyPage(Model model){

        model.addAttribute("boardType", "상품 관리");

        return "/admin/product/modify";
    }
}
