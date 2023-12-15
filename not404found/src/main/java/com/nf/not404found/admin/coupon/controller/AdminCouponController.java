package com.nf.not404found.admin.coupon.controller;


import com.nf.not404found.admin.account.model.dto.AdminAccountDTO;
import com.nf.not404found.admin.account.model.service.AdminAccountServiceImpl;
import com.nf.not404found.admin.common.exception.CouponInsertException;
import com.nf.not404found.admin.coupon.model.dto.AdminCouponDTO;
import com.nf.not404found.admin.coupon.model.service.AdminCouponServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/*")
@Slf4j
public class AdminCouponController {

    private final AdminCouponServiceImpl couponService;
    private final AdminAccountServiceImpl accountService;

    public AdminCouponController(AdminCouponServiceImpl couponService, AdminAccountServiceImpl accountService) {
        this.couponService = couponService;
        this.accountService = accountService;
    }

    @GetMapping("coupon")
    public ModelAndView couponPage(ModelAndView mv){

        mv.addObject("boardType", "쿠폰");
        mv.setViewName("admin/coupon/admin");

        List<AdminCouponDTO> couponList = couponService.selectAllCoupon();


        log.info("=================================================> 쿠폰 갯수 : " + couponList.size());
        int count = couponList.size();

        mv.addObject("couponList", couponList);
        mv.addObject("count", count);

        log.info("============================================> 쿠폰리스트 = " + couponList);

        return mv;
    }

    @PostMapping("coupon/search")
    public String couponSearchPage(Model model,
                                   @RequestParam(required = false) String searchCondition,
                                   @RequestParam(required = false) String searchCoupon,
                                   @RequestParam(required = false, defaultValue = "0") int periods,
                                   @RequestParam(required = false, defaultValue = "0") int periode,
                                   @RequestParam(required = false, defaultValue = "0") int chkbox1,
                                   @RequestParam(required = false, defaultValue = "0") int chkbox2,
                                   RedirectAttributes rttr){


        log.info("=================================================================>");

        return "redirect:/admin/coupon";
    }

    @GetMapping("coupon/insertCoupon")
    public String couponPageInsert(Model model){

        model.addAttribute("boardType", "쿠폰");

        return "/admin/coupon/insertCoupon";
    }

    @PostMapping("coupon/insertCoupon")
    public String couponInsert(@ModelAttribute AdminCouponDTO coupon,
                               RedirectAttributes rttr) throws CouponInsertException {

        log.info("-================================================== 쿠폰 등록 시작 ");

        couponService.insertCoupon(coupon);

        rttr.addFlashAttribute("complete", "쿠폰 등록에 성공하셨습니다.");



        return "redirect:/admin/coupon";
    }

    @GetMapping(value = "coupon/data", produces = "application/json; charset=utf-8")
    @ResponseBody
    public List<AdminAccountDTO> couponMember(){

        log.info("===================================================== 쿠폰 비동기로 멤버 가져오기 ======");


        List<AdminAccountDTO> memberList = accountService.selectAllAccountsList();

        log.info("=================================================> 잘 온건지 확인 쿠폰 회원정보 = " + memberList);
        log.info("=================================================> 잘 온건지 확인 쿠폰 회원정보 : " + memberList.size());

        return memberList;
    }
}
