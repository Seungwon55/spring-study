package com.cos.springstudy.error.exception;

import org.springframework.http.HttpStatus;

public class LoginDTOBlankException extends AbstractCustomException {

    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    private static final String MESSAGE = "아이디 혹은 비밀번호를 입력하지 않았습니다.";

    public LoginDTOBlankException() {
        super(MESSAGE);
    }

    @Override
    public HttpStatus getStatus() {
        return STATUS;
    }

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
