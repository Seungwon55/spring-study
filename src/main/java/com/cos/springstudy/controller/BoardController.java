package com.cos.springstudy.controller;

import com.cos.springstudy.aop.LoginCheck;
import com.cos.springstudy.dao.BoardDAO;
import com.cos.springstudy.dto.BoardDTO;
import com.cos.springstudy.error.exception.BoardDTOBlankException;
import com.cos.springstudy.util.PageHandler;
import com.cos.springstudy.util.SearchCondition;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardDAO boardDAO;

    // 게시판 목록
    @GetMapping("/list")
    public String boardList(@ModelAttribute SearchCondition sc, Model model) {

        // 검색어 여부와 조건에 따른 게시물 총 개수
        int totalCnt = sc.getOption() == null ? boardDAO.selectCnt() : boardDAO.selectCntBySc(sc);

        // 게시글 리스트 조회할 때는 PageHandler 필수
        PageHandler ph = new PageHandler(sc, totalCnt);
        List<BoardDTO> boardDTOList = boardDAO.selectListByPh(ph);
        model.addAttribute("ph", ph);
        model.addAttribute("boardList", boardDTOList);

        System.out.println("ph = " + ph);

        return "board/boardList";
    }

    // 해당 게시글 조회
    @GetMapping("/read/{bno}")
    @LoginCheck
    public String boardDetail(@PathVariable int bno, Model model, HttpServletRequest request) {

        // 해당 게시글 조회수 증가
        boardDAO.increaseViewCnt(bno);

        BoardDTO boardDTO = boardDAO.selectByBno(bno);
        model.addAttribute("board", boardDTO);

        return "board/boardDetail";
    }

    // 게시물 작성 폼으로 이동
    @GetMapping("/write")
    @LoginCheck
    public String boardWriteForm() {

        return "board/boardWriteForm";
    }

    // 게시물 작성
    @PostMapping("/write")
    public String boardWrite(@ModelAttribute BoardDTO boardDTO) {

        if (boardDTO.inputCheck())
            throw new BoardDTOBlankException();

        boardDAO.insert(boardDTO);

        return "redirect:/board/list";
    }

    // 게시글 삭제
    @PostMapping("/delete/{bno}")
    public String boardDelete(@PathVariable int bno) {

        boardDAO.delete(bno);

        return "redirect:/board/list";
    }

    // 게시글 수정 폼으로 이동
    @GetMapping("/update/{bno}")
    @LoginCheck
    public String boardUpdateForm(@PathVariable Integer bno, Model model) {

        // 이전 제목과 내용 전송
        BoardDTO boardDTO = boardDAO.selectByBno(bno);
        model.addAttribute("board", boardDTO);

        return "board/boardUpdateForm";
    }

    // 게시글 수정
    @PostMapping("/update/{bno}")
    public String boardUpdate(@PathVariable Integer bno, @ModelAttribute BoardDTO boardDTO) {

        if (boardDTO.inputCheck())
            throw new BoardDTOBlankException();

        boardDAO.update(bno, boardDTO);

        return "redirect:/board/read/{bno}";
    }

}
