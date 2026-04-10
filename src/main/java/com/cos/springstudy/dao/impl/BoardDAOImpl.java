package com.cos.springstudy.dao.impl;

import com.cos.springstudy.dao.BoardDAO;
import com.cos.springstudy.dto.BoardDTO;
import com.cos.springstudy.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

    private final BoardMapper mapper;

    // 게시글 리스트 조회
    @Override
    public List<BoardDTO> selectList() {
        return mapper.selectList();
    }
}
