package com.cos.springstudy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@ToString
public class MemberDTO {

    private String memberId;

    @NotBlank(message = "아이디는 필수입니다.")
    @Pattern(regexp = "^[a-z0-9]{4,16}$", message = "아이디는 영문 소문자/숫자만 사용 가능하고 4~16자여야 합니다.")
    private String loginId;

    @NotBlank(message = "비밀번호는 필수입니다.")
    @Pattern(regexp = "^[A-Za-z0-9]{10,16}$",message = "비밀번호는 영문 대소문자와 숫자만 사용 가능하며 10~16자여야 합니다.")
    private String password;

    @NotBlank(message = "이름은 필수입니다.")
    private String name;

    @NotBlank(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "올바른 전화번호 형식이 아닙니다.")
    private String tel;

    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    private LocalDateTime regDate;
}
