package com.cos.springstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class LoginDTO {

    private String loginId;
    private String password;
    private Boolean rememberId;

    public boolean getRememberId() {
        return Boolean.TRUE.equals(this.rememberId);
    }

    // 아이디,비밀번호 입력 확인
    public boolean inputCheck() {
        return loginId.isBlank() || password.isBlank();
    }
}
