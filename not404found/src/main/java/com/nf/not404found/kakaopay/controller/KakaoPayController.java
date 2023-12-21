package com.nf.not404found.kakaopay.controller;


import com.nf.not404found.kakaopay.model.dto.ApproveResponse;
import com.nf.not404found.kakaopay.model.dto.Payment;
import com.nf.not404found.kakaopay.model.dto.ReadyResponse;
import com.nf.not404found.kakaopay.model.service.KakaoPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@SessionAttributes({"tid","order"})
public class KakaoPayController {


    private final KakaoPayService kakaoPayService;

    public KakaoPayController(KakaoPayService kakaoPayService) {
        this.kakaoPayService = kakaoPayService;
    }

    @PostMapping("/order/pay")
    @ResponseBody
    public ReadyResponse payReady(Model model,
                                  @RequestParam int totalprice,
                                  @RequestParam int mileage,
                                  @RequestParam(required = false) String buyname,
                                  @RequestParam(required = false) String buytel,
                                  @RequestParam(required = false) String buyemail,
                                  @RequestParam(required = false) String receivename,
                                  @RequestParam(required = false) String receivetel,
                                  @RequestParam(required = false) String receiveaddress,
                                  @RequestParam(required = false) String pname
//                                  @RequestParam(required = false) int totalamount
                                  ) {


        log.info("========================================================> 시작? 컨트롤 ? ");
        log.info("=======================================================> totalprice : " + totalprice);
        log.info("=======================================================> mileage : " + mileage);
        log.info("=======================================================> buyname : " + buyname);
        log.info("=======================================================> buytel : " + buytel);
        log.info("=======================================================> buyemail : " + buyemail);
        log.info("=======================================================> receivename : " + receivename);
        log.info("=======================================================> receivetel : " + receivetel);
        log.info("=======================================================> receiveaddress : " + receiveaddress);
        log.info("=======================================================> pname : " + pname);


        ReadyResponse readyResponse = kakaoPayService.payReady(totalprice,      //totalamount
                mileage,
                buyname,
                buytel,
                buyemail,
                receivename,
                receivetel,
                receiveaddress,
                pname);
        // 요청처리후 받아온 결재고유 번호(tid)를 모델에 저장
        model.addAttribute("tid", readyResponse.getTid());
        log.info("결재고유 번호: " + readyResponse.getTid());

        log.info("=========================================================컨트롤러 첫 리턴 ");
        return readyResponse; // 클라이언트에 보냄.(tid,next_redirect_pc_url이 담겨있음.)
    }

    @GetMapping("/order/pay/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken, @ModelAttribute("tid") String tid, Model model) {

        log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
        log.info("결재고유 번호: " + tid);

        log.info("================================ model : " + model);

        // 카카오 결재 요청하기
        ApproveResponse approveResponse = kakaoPayService.payApprove(tid, pgToken);



        log.info("----------어디까지 된거냐 여긴 컨트롤러 마지막 ");

        return "redirect:/order/orderComplete";
    }
}
