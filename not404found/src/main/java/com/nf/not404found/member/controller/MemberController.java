package com.nf.not404found.member.controller;


import com.nf.not404found.common.functions.UserInformation;
import com.nf.not404found.member.emailsend.EmailSender;
import com.nf.not404found.member.model.dto.MemberDTO;
import com.nf.not404found.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Character.toUpperCase;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("check-username")
    @ResponseBody
    public Map<String, Object> checkUsername(@RequestParam String username) {
        System.out.println("aaaaaaaaa");
        boolean exists = memberService.usernameExists(username);
        Map<String, Object> response = new HashMap<>();
        response.put("count", exists);
        return response;
    }

    /**
     * 비동기로 넘어올 수 있는 메소드이다.
     * 이메일 인증 버튼을 누르면 이 메소드로 들어온다.
     * 해야할 일 :
     * 1. 난수 생성
     * 2. 난수 데이터 DB에 Insert
     */
    @GetMapping("checkEmail")
    @ResponseBody
    public boolean checkEmail(@RequestParam(name = "param1") String id, @RequestParam(name = "param2") String email) {
        System.out.println(id);
        System.out.println(email);
        String randomStr = createRandomString();    //난수 생성 메소드 호출
        System.out.println(randomStr);  //난수 체크용 출력
        boolean check = memberService.checkEmail(id, randomStr);     //아이디, 랜덤 키 갖고 서비스로 보내기
        Map<String, Boolean> insertStatus = new HashMap<>();        //인서트 잘 됐는지 확인용 Map
        insertStatus.put("check", check);                            //돌아온 true or false PUT
        if (!check) {
            return false;
        }
        Map<String, Boolean> emailStatus = new HashMap<>();
        if (EmailSender.emailSend(email, randomStr))    //이메일 보내는 메소드 테스트일 때는 주석 처리
        //if(true)
        {
            System.out.println("성공");
            emailStatus.put("check", true);
            return true;
        } else {
            System.out.println("실패");
            emailStatus.put("check", false);
            return false;
        }
    }

    /**
     * 이메일 인증 코드가 맞는지 확인하러 가는 메소드!
     *
     * @param id      사용자 id
     * @param pwdCode 사용자가 입력한 인증 코드
     */
    @GetMapping("member/check/code")
    @ResponseBody
    public int checkCode(@RequestParam(name = "id") String id, @RequestParam(name = "pwdCode") String pwdCode) {
        System.out.println(id);
        System.out.println(pwdCode);
        int result = memberService.checkCode(id, pwdCode);
        return result;
    }

    private String createRandomString() {
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

    @PostMapping("/join")
    @ResponseBody
    public boolean createMember(@RequestBody MemberDTO member) {
        System.out.println(member.getId());
        System.out.println(member.getEmail());
        System.out.println(member.getPwd());
        System.out.println(member.getPhone());
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        System.out.println("암호화 된 비밀번호 = " + member.getPwd());
        if (memberService.createMember(member)) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("withdraw")
    public String memberDeleteAccount(Model model) {

        return "member/withdraw";
    }

    @PostMapping("/withdraw")
    @ResponseBody
    public String handleWithdraw() {
        // 현재 로그인된 사용자의 username 가져오기
        String username = getCurrentUsername();
        System.out.println("username ======== " + username);
//        String userEmail = getCurrentUserEmail(); // 현재 로그인된 사용자의 이메일 가져오기
//        System.out.println("userEmail = " + userEmail);
//        LocalDate deleteDate = LocalDate.now(); // 삭제 날짜 설정

//        boolean isUpdateSuccessful = memberService.updateFormerMemberDate(userEmail, deleteDate);
        boolean isWithdrawn = memberService.withdrawAccount(username);
        
//        if (isUpdateSuccessful && isWithdrawn) {
//            return "회원 탈퇴 처리가 완료되었습니다.";
//        } else if (!isUpdateSuccessful) {
//            return "업데이트 실패: 계정 상태 업데이트를 실패하였습니다.";
//        } else {
//            return "계정을 찾을 수 없습니다.";
//        }
        String result = null;
        if (isWithdrawn) {
            return result ="회원 탈퇴 처리가 완료되었습니다.";
        } else {
            return result = "계정을 찾을 수 없습니다.";
        }
    }

//    private String getCurrentUserEmail() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            System.out.println("이메일오나1");
//            return null; // 사용자가 로그인하지 않은 경우
//        }
//
//        Object principal = authentication.getPrincipal();
//        System.out.println("Principal 클래스 타입: " + principal.getClass().getName()); // 클래스 이름 출력
//        if (principal instanceof UserInformation) {
//            System.out.println("이메일오나2");
//            return ((UserInformation) principal).getEmail(); // 는 사용자 정의 UserDetails 구현체
//        } else {
//            System.out.println("이메일오나3");
//            return null; // 이메일 주소를 가져올 수 없는 경우
//        }
//    }

    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null; // 사용자가 로그인하지 않은 경우
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else if (principal instanceof String) {
            return (String) principal;
        }
        return null;
    }
}



    // 비밀번호 확인 로직 구현
    // 회원 탈퇴 로직 구현
    // 성공 시 리디렉션 또는 특정 페이지로 이동

