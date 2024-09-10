package com.ssg.web2.todo.filter;

//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.HttpRequest;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/todo/*"})
//@Log4j2
//public class LoginCheckFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException{
//
//        log.info("LoginCheck filter 이다.");
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletRequest resp = (HttpServletRequest) response;
//
//        HttpSession session = req.getSession();
////        if(session.getAttribute("loginInfo") == null){
////            resp.sendRedirect("/login");
////            return;
////        }
//
//        filterChain.doFilter(request, response);
//    }
//
//}
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // Filter 인터페이스의 doFilter 추상메소드는 필터링이 필요한 로직을 구현하는 메소드이다.
        //필터를 적용하기 위해서는 @WebFilter 어노테이션 처리 필수
        // @WebFilter(urlPatterns = {"/todo/*"})    지정한 /todo/경로를 지정해서 해당 경로의 요청(request)에 대해서 doFilter를 실행하겠다.
        //LoginCheckFilter 는 /todo/* 지정되어 브라우저에서 /todo/...시작하는 모든 경로에 대해서 필터링을 시도하겠다.

        log.info("LoginCheck filter 이다.");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        if(session.getAttribute("loginInfo") == null) {
            resp.sendRedirect("/login");
            return;
        }
        filterChain.doFilter(req,resp);  // 다음 필터나 목적지(servlet ,jsp)로 갈 수 있도록 FilterChain의 doFilter()를 실행한다.
    }
}