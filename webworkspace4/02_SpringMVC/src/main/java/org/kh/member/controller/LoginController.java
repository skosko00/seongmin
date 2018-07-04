package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberService;
import org.kh.member.model.vo.Member;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("로그인 처리");
		
		//1. 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		//2. 사용자 입력값 저장
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		
		//3. 비즈니스 로직 처리
		Member m = new MemberService().selectOneMember(vo);
		
		//4. view 페이지 리턴
		
		if(m!=null) {
			return "loginSuccess";
		} else {
			return "loginFailed";
		}
	}

}
