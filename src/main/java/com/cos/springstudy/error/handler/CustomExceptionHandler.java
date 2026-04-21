package com.cos.springstudy.error.handler;

import com.cos.springstudy.error.ErrorInfo;
import com.cos.springstudy.error.exception.AbstractCustomException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.cos.springstudy")
public class CustomExceptionHandler {

    @ExceptionHandler(AbstractCustomException.class)
    public String customExceptionHandler(AbstractCustomException e, Model model) {

        // 에러 정보 Model에 담아 전송
        ErrorInfo errorInfo = new ErrorInfo(e.getStatus(), e.getMessage());
        model.addAttribute("errorInfo", errorInfo);

        return "error/errorForm";
    }
}
