package com.cos.springstudy.controller;

import com.cos.springstudy.dto.LoginDTO;
import com.cos.springstudy.dto.MemberDTO;
import com.cos.springstudy.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm() {

        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO) {

        MemberDTO memberDTO = loginService.login(loginDTO.getLoginId());

        return "redirect:/";
    }
}
