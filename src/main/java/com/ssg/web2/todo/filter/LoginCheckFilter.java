package com.ssg.web2.todo.filter;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throw IOException{

        log.info("LoginCheck filter 이다.");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletRequest resp = (HttpServletRequest) response;

        HttpSession session = req.getSession();
        if(session.getAttribute("loginInfo") == null){
            resp.sendRedirect("/login");
            return;
        }

        filterChain.doFilter(request, response);
    }

}
