package com.cos.springstudy.mapper;

import com.cos.springstudy.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 리스트 조회
    List<BoardDTO> selectList();
}
