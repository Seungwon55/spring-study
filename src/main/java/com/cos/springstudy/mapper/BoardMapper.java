package com.cos.springstudy.mapper;

import com.cos.springstudy.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    // 게시글 리스트 조회
    List<BoardDTO> selectList();

    // 게시글 번호를 통한 게시글 조회
    BoardDTO selectByBno(Integer bno);

    // 조회수 증가
    int increaseViewCnt(Integer bno);

    // 게시글 작성
    int insert(BoardDTO boardDTO);
}
