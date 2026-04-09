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

    @Override
    public MemberDTO selectByLoginId(String loginId) {
        return mapper.selectByLoginId(loginId);
    }
}
