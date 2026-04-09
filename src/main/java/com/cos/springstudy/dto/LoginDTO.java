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
}
