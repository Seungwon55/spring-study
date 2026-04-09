package com.cos.springstudy.dao.impl;

import com.cos.springstudy.dao.MemberDAO;
import com.cos.springstudy.dto.MemberDTO;
import com.cos.springstudy.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final MemberMapper mapper;

    // 아이디를 통한 회원 조회
    @Override
    public MemberDTO selectByLoginId(String loginId) {
        return mapper.selectByLoginId(loginId);
    }

    // 회원가입
    @Override
    public int insert(MemberDTO memberDTO) {
        return mapper.insert(memberDTO);
    }
}
