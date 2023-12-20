package com.nf.not404found.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    //이 곳은 상품을 DB 에서 가져와 출력하는 페이지들이다.
    //신상품, 베스트, 카테고리 등 페이지는 모두 동일하지만
    //사용자가 버튼을 누를 때 마다 페이지 형식은 유지한채로 데이터만 다르게 가져와 뿌리는 형식으로 한다. (동기 비동기 둘 다 가능)
    //사용자가 상품을 클릭하면 @@상품의 정보를 가지고@@ Order 페이지로 이동한다.
    //상품의 정보를 어떻게 가져가냐? 버튼을 누르면 뿌릴 때 서버사이드에 저장을 해야겠지?
//    @GetMapping("productPage")
//    public ModelAndView openProductPage(ModelAndView mv, @RequestBody String value){
//        //value 는 무슨 상품 목록을 선택했는지를 받아올 것이다.
//
//        mv.setViewName("productpage/productPage");
//        return mv;
//    }
    @GetMapping("productPage")
    public String openProductPage(){

        return "productpage/productPage";
    }
}
