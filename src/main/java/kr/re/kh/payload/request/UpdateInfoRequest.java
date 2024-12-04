package kr.re.kh.payload.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateInfoRequest {
    private String userID;
    private String username;
    private String password;
    private String email;
}
