package com.cos.springstudy.error.exception;

import org.springframework.http.HttpStatus;

public abstract class AbstractCustomException extends RuntimeException {

    public AbstractCustomException(String message) {
        super(message);
    }

    // 상태 코드를 받는 메서드
    public abstract HttpStatus getStatus();

    // 오류 메시지를 받는 메서드
    public abstract String getMessage();
}
