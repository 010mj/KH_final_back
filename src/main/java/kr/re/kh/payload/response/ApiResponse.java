package kr.re.kh.payload.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    private boolean success;
    private String data;
    private String timestamp;
    private String cause;
    private String path;

    public ApiResponse(boolean success, String data) {
        this.success = success;
        this.data = data;
        this.timestamp = Instant.now().toString();
        this.cause = null;
        this.path = null;
    }

    public ApiResponse(boolean success, String data, String cause, String path) {
        this.success = success;
        this.data = data;
        this.timestamp = Instant.now().toString();
        this.cause = cause;
        this.path = path;
    }
}
