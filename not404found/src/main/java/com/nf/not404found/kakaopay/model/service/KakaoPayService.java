package com.nf.not404found.kakaopay.model.service;


import com.nf.not404found.common.functions.UserInformation;
import com.nf.not404found.kakaopay.model.dto.ApproveResponse;
import com.nf.not404found.kakaopay.model.dto.ReadyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class KakaoPayService {

    private static final String HOST = "https://kapi.kakao.com";

    private ReadyResponse readyResponse;

    private final UserInformation user;

    public KakaoPayService(UserInformation user) {
        this.user = user;
    }

    public ReadyResponse payReady(//int totalAmount,
                                  int totalprice,
                                  int mileage,
                                  String buyname,
                                  String buytel,
                                  String buyemail,
                                  String receivename,
                                  String receivetel,
                                  String receiveaddress,
                                  String pname) {

        log.info("======================================> 서비스 시작 ");

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();


        parameters.add("cid", "TC0ONETIME"); //테스트임
        parameters.add("partner_order_id", "4"); // 주문번호임 ?
        parameters.add("partner_user_id", user.getId()); // 주문결제 하는 회원의 아이디
        parameters.add("item_name", pname); // 상품명
        parameters.add("quantity", "2"); // 수량
        parameters.add("total_amount", String.valueOf(totalprice));
        parameters.add("tax_free_amount", "0"); //비과세인가 뭔가 하는거임
        parameters.add("approval_url", "http://localhost:8404/order/pay/completed"); // 결제승인시 넘어갈 url
        parameters.add("cancel_url", "http://localhost:8404/order/pay/cancel"); // 결제취소시 넘어갈 url
        parameters.add("fail_url", "http://localhost:8404/order/pay/fail");

        log.info("파트너주문아이디:"+ parameters.get("partner_order_id")) ;

        log.info("=================================================> parameters : " + parameters);

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();

        String url = "https://kapi.kakao.com/v1/payment/ready";
        log.info("============================================= id : " + parameters.get("partner_user_id"));
        log.info("=================================================url : " + url);
        log.info("=============================================== requestEntity : " +requestEntity);
        log.info("======================================================= ReadyResponse.class : " + ReadyResponse.class);

        ReadyResponse readyResponse = template.postForObject(url, requestEntity, ReadyResponse.class);

        log.info("결재준비 응답객체: " + readyResponse);

        log.info("===============================================================> 서비스 첫 리턴 ");

        return readyResponse;
    }

    public ApproveResponse payApprove(String tid, String pgToken){

        log.info("=================================================================> 서비스 응답 시작 ");

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

        parameters.add("cid", "TC0ONETIME");
        parameters.add("tid", tid);
        parameters.add("partner_order_id", "4"); // 주문번호
        parameters.add("partner_user_id", user.getId());
        parameters.add("pg_token", pgToken);

        log.info("=================================================================> 여기 오냐 ? 서비스 중간 ");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        log.info("==================================================================> 여기 ? " );
        RestTemplate template = new RestTemplate();
        String url = "https://kapi.kakao.com/v1/payment/approve";
        // 보낼 외부 url, 요청 메시지(header,parameter), 처리후 값을 받아올 클래스.

        log.info("============================================= id : " + parameters.get("partner_user_id"));
        log.info("=================================================url : " + url);
        log.info("=============================================== requestEntity : " +requestEntity);
        log.info("======================================================= ReadyResponse.class : " + ReadyResponse.class);

        ApproveResponse approveResponse = template.postForObject(url, requestEntity, ApproveResponse.class);
        log.info("결재승인 응답객체: " + approveResponse);

        log.info("======================================================================= 서비스 마지막 리턴 :");
        return approveResponse;
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + "e909ec5503342452f610e3e90db74082");
        headers.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return headers;
    }
}
