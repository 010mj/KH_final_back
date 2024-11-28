package kr.re.kh.vo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberVO {
    private Long idx;
    private Long isAdmin;
    private String userID;
    private String password;
    private String username;
    private String email;
    private LocalDateTime regDate;
    private int isUse;
    private LocalDateTime dropDate;
    private int age;
    private String birth;
    private String gender;

    @Builder
    public MemberVO(Long idx, Long isAdmin, String userID, String password, String username, String email,
                    LocalDateTime regDate, int isUse, LocalDateTime dropDate, int age, String birth, String gender) {
        this.idx = idx;
        this.isAdmin = isAdmin;
        this.userID = userID;
        this.password = password;
        this.username = username;
        this.email = email;
        this.regDate = regDate;
        this.isUse = isUse;
        this.dropDate = dropDate;
        this.age = age;
        this.birth = birth;
        this.gender = gender;
    }
}