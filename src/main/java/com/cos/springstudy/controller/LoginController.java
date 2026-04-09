package com.cos.springstudy.controller;

import com.cos.springstudy.dao.MemberDAO;
import com.cos.springstudy.dto.LoginDTO;
import com.cos.springstudy.dto.MemberDTO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final MemberDAO memberDAO;

    @GetMapping("/login")
    public String loginForm(@CookieValue(name = "loginId", required = false) String loginId,
                            @RequestParam(name="uri", required = false) String uri,
                            Model model) {

        model.addAttribute("loginId", loginId);  // 전에 로그인 기억한다면 loginId 활성화
        model.addAttribute("uri", uri);          // 로그인 성공 시 전에 머물던 페이지로 이동하기 위한 uri값

        return "member/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, @RequestParam(name = "uri", required = false) String uri,
                        HttpServletRequest request, HttpServletResponse response,
                        RedirectAttributes redirect) {

        if (loginDTO.inputCheck())
            throw new RuntimeException("아이디,비밀번호를 입력하지 않았습니다.");

        // 아이디를 통한 회원 조회
        MemberDTO memberDTO = memberDAO.selectByLoginId(loginDTO.getLoginId());

        // 로그인 실패 시 메시지와 함께 로그인 화면으로 재이동
        if (loginCheck(loginDTO, memberDTO)) {
            redirect.addFlashAttribute("message", "아이디 혹은 비밀번호가 일치하지 않습니다.");
            return "redirect:/login";
        }

        // 로그인 성공
        // 로그인 여부를 위해 세션 저장(상태 부여)
        HttpSession session = request.getSession();
        session.setAttribute("member", memberDTO);

        // 아이디 기억 시 쿠키 저장
        Cookie cookie = new Cookie("loginId", memberDTO.getLoginId());
        System.out.println("loginDTO = " + loginDTO);
        if (loginDTO.getRememberId())
            cookie.setMaxAge(60 * 5);  // 5분간 아이디 저장
        else
            cookie.setMaxAge(0);  // 기억 안할 시 쿠키 삭제
        response.addCookie(cookie);

        return "redirect:" + (uri == null ? "" : uri);
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // 세션 저장소의 데이터 삭제
        session.invalidate();

        return "redirect:/";
    }

    // 아이디,비밀번호 일치 여부 확인
    private boolean loginCheck(LoginDTO loginDTO, MemberDTO memberDTO) {
        return memberDTO == null || !memberDTO.getPassword().equals(loginDTO.getPassword());
    }
}
