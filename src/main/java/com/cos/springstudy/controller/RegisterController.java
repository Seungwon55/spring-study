package com.cos.springstudy.controller;

import com.cos.springstudy.dao.MemberDAO;
import com.cos.springstudy.dto.MemberDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegisterController {

    private final MemberDAO memberDAO;

    @GetMapping("/add")
    public String registerForm() {

        return "member/registerForm";
    }

    @PostMapping("/add")
    public String register(@RequestParam String passwordChk, @Valid @ModelAttribute MemberDTO memberDTO,
                           BindingResult bindingResult, RedirectAttributes redirect) {

        // 유효성 검사
        // 서버 사이드 랜더링은 bindingResult로 처리
        if (bindingResult.hasErrors()) {
            bindingResult.getFieldErrors().forEach(fieldError -> {
                System.out.println("fieldError : " + fieldError.getField());
                System.out.println("errorMessage : " + fieldError.getDefaultMessage());
            });

            return "redirect:/register/add";
        }

        // 비밀번호가 다르다면 메시지와 함께 회원등록으로 재이동
        if (!memberDTO.getPassword().equals(passwordChk)) {
            redirect.addFlashAttribute("message", "비밀번호가 다릅니다. 다시 입력해주세요.");
            return "redirect:/register/add";
        }

        // 비밀번호가 같다면 insert 수행
        memberDAO.insert(memberDTO);
        // 회원 가입 완료 페이지에 보이기 위해 정보 전송
        redirect.addFlashAttribute("member", memberDTO);

        return "redirect:/register/complete";
    }

    @GetMapping("/complete")
    public String registerComplete() {

        return "member/registerComplete";
    }
}
