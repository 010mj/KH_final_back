package kr.re.kh.util;

import java.util.Random;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtil {

    // 랜덤 문자열 생성
    public static String generateRandomString(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789`~!@#$%^&*()-_=+\\|[{]};:,<.>/?\'\"";
        StringBuilder result = new StringBuilder(len);
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            int index = random.nextInt(chars.length());
            result.append(chars.charAt(index));
        }

        return result.toString();
    }

}
