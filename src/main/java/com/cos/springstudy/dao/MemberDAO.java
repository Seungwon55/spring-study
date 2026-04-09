package com.cos.springstudy.dao;

import com.cos.springstudy.dto.MemberDTO;

public interface MemberDAO {

    // 아이디를 통한 회원 조회
    MemberDTO selectByLoginId(String loginId);

    // 회원가입
    int insert(MemberDTO memberDTO);
}
