package com.cos.springstudy.error.exception;

import org.springframework.http.HttpStatus;

public class BoardDTOBlankException extends AbstractCustomException {

    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    private static final String MESSAGE = "게시글 제목 혹은 내용을 입력하지 않았습니다.";

    public BoardDTOBlankException() {
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
