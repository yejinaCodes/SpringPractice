package com.ssg.web2.todo.controller;

import com.ssg.web2.todo.dto.MemberDTO;
import com.ssg.web2.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="loginController" , urlPatterns = "/login")
@Log4j2
public class LoginController extends HttpServlet {

    // get 은 로그인 을 화면을 보여주고, POST방식으로 실제 로그인 처리하도록 구성 하도록 한다.
    //1. webservlet 해당 컨트롤러 등록 이름  /login
    //2. doGet   login.jsp 파일로 포워딩
    //3. login.jsp 파일 만들어주세요 ... text 2개   id(mid), pwd(mpw) , submit 버튼


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/todo/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");      //파라미터 수집

        //String str = mid + mpw;

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid,mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo",memberDTO);
            resp.sendRedirect("/todo/list");
            //정상적으로 로그인된 경우에는 HttpSession을 이용해서 loginInfo이름으로 객체를 저장한다.
        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
            // 예외가 발생한다면 /login 으로 이동하는데, result라는 파라미터를 전달하여 error가 발생했다는 사실을 전달한다.
        }
        //HttpSession을 이용해서 setAttribute()를 사용자 공간에 loginInfo 라는 이름으로 문자열을 보관
    }
}