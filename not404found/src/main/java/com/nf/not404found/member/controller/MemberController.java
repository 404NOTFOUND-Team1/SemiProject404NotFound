package com.nf.not404found.member.controller;


import com.nf.not404found.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Character.toUpperCase;

@RestController
public class MemberController {

    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping("/check-username")
    public Map<String, Object> checkUsername(@RequestParam String username){
        boolean exists = memberService.usernameExists(username);
        Map<String, Object> response = new HashMap<>();
        response.put("count",exists);
        return response;
    }

    /**
     * 비동기로 넘어올 수 있는 메소드이다.
     * 이메일 인증 버튼을 누르면 이 메소드로 들어온다.
     *
     * 해야할 일 : 난수 생성(클리어), 난수 데이터 DB에 Insert 까지만
     *
     */
    @GetMapping("/checkEmail/id")
    public Map<String, Boolean> checkEmail(@RequestParam String id, @RequestParam String email){
        String randomStr = createRandomString();
        System.out.println(randomStr);
        boolean check = memberService.checkEmail(id,randomStr);
        Map<String, Boolean> insertStatus = new HashMap<>();
        insertStatus.put("check",check);
        if(!check){
            return insertStatus;
        }
        Map<String, Boolean> emailStatus = new HashMap<>();
        //if(EmailSender.emailSend(email,randomStr))
        if(true)
        {
            System.out.println("성공");
            emailStatus.put("check",true);
            return emailStatus;
        } else {
            System.out.println("실패");
            emailStatus.put("check",false);
            return emailStatus;
        }
    }
    @GetMapping("/check/code")
    public String checkCode(@RequestParam String id,@RequestParam String pwdCode){
        System.out.println(id);
        System.out.println(pwdCode);
        boolean result = memberService.checkCode(id,pwdCode);
        return "";
    }

    private String createRandomString(){
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";

        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                // 알파벳 문자 추가
                int index = random.nextInt(alphabet.length());
                sb.append(toUpperCase(alphabet.charAt(index)));
            } else {
                // 숫자 추가
                int index = random.nextInt(digits.length());
                sb.append(digits.charAt(index));
            }
        }

        String randomString = sb.toString();
        System.out.println("랜덤 문자열: " + randomString);
        return randomString;
    }
}
