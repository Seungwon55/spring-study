package com.cos.springstudy.aop;

import com.cos.springstudy.dto.MemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoginCheckAdvice {

    @Around("@annotation(LoginCheck)")  // LoginCheck 어노테이션 붙은 메서드 시작과 끝에 적용
    public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {

        // 세션 획득
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();

        // 세션 저장소의 MemberDTO 조회
        MemberDTO member = (MemberDTO) session.getAttribute("member");

        if (member == null)
            return "redirect:/login?uri=" + request.getRequestURI();
        // 회원이 있다면 정상 종료
        return joinPoint.proceed();
    }
}
