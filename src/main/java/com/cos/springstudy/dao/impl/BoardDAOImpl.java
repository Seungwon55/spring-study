package com.cos.springstudy.dao.impl;

import com.cos.springstudy.dao.BoardDAO;
import com.cos.springstudy.dto.BoardDTO;
import com.cos.springstudy.mapper.BoardMapper;
import com.cos.springstudy.util.PageHandler;
import com.cos.springstudy.util.SearchCondition;
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

    // 게시글 번호를 통한 게시글 조회
    @Override
    public BoardDTO selectByBno(Integer bno) {
        return mapper.selectByBno(bno);
    }

    // 조회수 증가
    @Override
    public int increaseViewCnt(Integer bno) {
        return mapper.increaseViewCnt(bno);
    }

    // 게시글 작성
    @Override
    public int insert(BoardDTO boardDTO) {
        return mapper.insert(boardDTO);
    }

    // 게시글 삭제
    @Override
    public int delete(Integer bno) {
        return mapper.delete(bno);
    }

    // 게시글 수정
    @Override
    public int update(Integer bno, BoardDTO boardDTO) {
        return mapper.update(bno, boardDTO);
    }

    // 게시글 개수 조회
    @Override
    public int selectCnt() {
        return mapper.selectCnt();
    }

    // 검색 조건에 따른 게시글 개수 조회
    @Override
    public int selectCntBySc(SearchCondition sc) {
        return mapper.selectCntBySc(sc);
    }

    // 페이지와 검색어에 따른 게시글 리스트 조회
    @Override
    public List<BoardDTO> selectListByPh(PageHandler ph) {
        return mapper.selectListByPh(ph);
    }
}
