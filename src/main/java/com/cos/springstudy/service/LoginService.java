package com.cos.springstudy.service;

import com.cos.springstudy.dto.MemberDTO;

public interface LoginService {

    // 로그인
    MemberDTO login(String loginId);
}
