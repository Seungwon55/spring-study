package com.cos.springstudy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class MemberDTO {

    private String memberId;
    private String loginId;
    private String password;
    private String name;
    private String tel;
    private String email;
    private LocalDateTime regDate;
}
