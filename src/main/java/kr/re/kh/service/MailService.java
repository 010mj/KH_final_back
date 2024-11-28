package kr.re.kh.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;

    public int sendVerificationCode(String mail) throws MessagingException, javax.mail.MessagingException {
        // 6자리 번호를 랜덤 생성.
        int verificationCode = new Random().nextInt(900000) + 100000;

        // 이메일 메시지 생성
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(mail);
        helper.setSubject("회원가입 인증번호");
        helper.setText("인증번호는 " + verificationCode + " 입니다.");

        // 이메일 발송
        javaMailSender.send(message);

        return verificationCode;
    }
}
