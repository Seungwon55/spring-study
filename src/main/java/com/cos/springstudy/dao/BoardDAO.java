package com.cos.springstudy.dao;

import com.cos.springstudy.dto.BoardDTO;

import java.util.List;

public interface BoardDAO {

    // 게시글 리스트 조회
    List<BoardDTO> selectList();
}
