package com.nf.not404found.member.emailsend;

import com.nf.not404found.common.random.RandomString;
import com.nf.not404found.member.model.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    //    @Autowired
//    private JavaMailSender javaMailSender;
    @RequestMapping("/send-email-form")
    public String sendEmailForm() {
        return "/member/pwdFind";
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String email, @RequestParam String userId, Model model) {

        System.out.println("email = " + email);
        System.out.println("userId = " + userId);
        try {
            String subject = "집꾸미 이메일 인증";
            String text = "Your verification code is: " + generateVerificationCode();

            String random = RandomString.createRandomString();
            boolean result = EmailSender.emailSend(email, random);
            System.out.println("result = " + result);


            // 메일보내기가 성공을 하면 데이터베이스에 업데이트
            if(result) {
             int resultId =  emailService.insertRandomEmailCode(userId,random);
                System.out.println("resultId = " + resultId);
                model.addAttribute("id", resultId);
            }
            return "member/pwdFindCertification";


        } catch (Exception e) {
            e.printStackTrace();
       }
        return "redirect:/error"; // Error page or redirect back to the form with an error message
    }

    @GetMapping ("/member/next")
    public String pwdFindCertification() {
        return "member/pwdFindCertification";
    }


//    private void sendSimpleEmail(String to, String subject, String text) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(text);
//
//    }

    private String generateVerificationCode() {
        return "123456"; // For example, a simple static code
    }
}
