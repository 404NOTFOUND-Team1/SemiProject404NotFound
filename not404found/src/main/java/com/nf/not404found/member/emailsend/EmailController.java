package com.nf.not404found.member.emailsend;

import com.nf.not404found.common.random.RandomString;
import com.nf.not404found.member.emailsend.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {

//    @Autowired
//    private JavaMailSender javaMailSender;
    @RequestMapping("/send-email-form")
    public String sendEmailForm() {
        return "send-email";
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String email) {

        System.out.println("email = " + email);
        try {
            String subject = "집꾸미 이메일 인증";
            String text = "Your verification code is: " + generateVerificationCode();

           String random = RandomString.createRandomString();
            boolean result = EmailSender.emailSend(email, random);
            System.out.println("result = " + result);

            // 메일보내기가 성공을 하면 데이터베이스에 업데이트
            return ""; // Success page or any other page
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error"; // Error page or redirect back to the form with an error message
        }
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
