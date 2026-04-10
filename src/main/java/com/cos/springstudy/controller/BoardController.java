package com.cos.springstudy.controller;

import com.cos.springstudy.aop.LoginCheck;
import com.cos.springstudy.dao.BoardDAO;
import com.cos.springstudy.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String boardDetail(@PathVariable int bno, Model model) {

        BoardDTO boardDTO = boardDAO.selectByBno(bno);
        model.addAttribute("board", boardDTO);

        return "board/boardDetail";
    }
}
