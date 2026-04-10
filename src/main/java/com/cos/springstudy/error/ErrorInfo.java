package com.cos.springstudy.error;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public class ErrorInfo {

    private final int code;        // 상태 코드
    private final String message;  // 에러 메시지

    public ErrorInfo(HttpStatus status, String message) {
        this.code = status.value();
        this.message = message;
    }
}
