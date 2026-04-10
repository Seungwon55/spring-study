package com.cos.springstudy.controller;

import com.cos.springstudy.aop.LoginCheck;
import com.cos.springstudy.dao.BoardDAO;
import com.cos.springstudy.dto.BoardDTO;
import com.cos.springstudy.error.exception.BoardDTOBlankException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
    public String boardList(Model model) {

        List<BoardDTO> boardDTOList = boardDAO.selectList();
        model.addAttribute("boardList", boardDTOList);

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
}
