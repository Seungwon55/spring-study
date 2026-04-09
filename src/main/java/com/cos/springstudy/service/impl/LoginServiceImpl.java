package com.cos.springstudy.service.impl;

import com.cos.springstudy.dao.MemberDAO;
import com.cos.springstudy.dto.MemberDTO;
import com.cos.springstudy.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final MemberDAO memberDAO;

    // 로그인
    @Override
    public MemberDTO login(String loginId) {
        return memberDAO.selectByLoginId(loginId);
    }
}
