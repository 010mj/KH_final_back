package kr.re.kh.controller.admin;

import kr.re.kh.payload.response.ApiResponse;
import kr.re.kh.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@Slf4j
@RequestMapping("/api/mail")
@CrossOrigin("http://localhost:3000")
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;
    private final Map<String, Integer> verificationCodes = new ConcurrentHashMap<>();

    // 인증번호 발송
    @PostMapping("/send")
    public ResponseEntity<?> sendVerificationCode(@RequestBody HashMap<String, Object> mail) {
        HashMap<String, Object> resultMap = new HashMap<>();
        String mailStr = mail.get("mail").toString();

        try {
            int code = mailService.sendVerificationCode(mailStr);
            verificationCodes.put(mailStr, code);
            return ResponseEntity.ok(new ApiResponse(true, String.valueOf(code)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(500).body("Failed to Send Verification code");
    }

    // 인증번호 검증
    @GetMapping("/verifyCode")
    public ResponseEntity<?> verifyCode(@RequestParam String mail, @RequestParam int code) {
        Integer storedCode = verificationCodes.get(mail);

        if (storedCode != null && storedCode == code) {
            verificationCodes.remove(mail);
            return ResponseEntity.ok("Verification successful");
        } else {
            return ResponseEntity.status(500).body("Invalid verification code");
        }
    }

}
