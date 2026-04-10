package com.cos.springstudy.dao;

import com.cos.springstudy.dto.BoardDTO;
import com.cos.springstudy.util.PageHandler;
import com.cos.springstudy.util.SearchCondition;

import java.util.List;

public interface BoardDAO {

    // 게시글 리스트 조회
    List<BoardDTO> selectList();

    // 게시글 번호를 통한 게시글 조회
    BoardDTO selectByBno(Integer bno);

    // 조회수 증가
    int increaseViewCnt(Integer bno);

    // 게시글 작성
    int insert(BoardDTO boardDTO);

    // 게시글 삭제
    int delete(Integer bno);

    // 게시글 수정
    int update(Integer bno, BoardDTO boardDTO);

    // 게시글 개수 조회
    int selectCnt();

    // 검색 조건에 따른 게시글 개수 조회
    int selectCntBySc(SearchCondition sc);

    // 페이지와 검색어에 따른 게시글 리스트 조회
    List<BoardDTO> selectListByPh(PageHandler ph);
}
