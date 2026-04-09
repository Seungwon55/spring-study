package com.cos.springstudy.mapper;

import com.cos.springstudy.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    // 아이디를 통한 회원 조회
    MemberDTO selectByLoginId(String loginId);

    // 회원가입
    int insert(MemberDTO memberDTO);
}
