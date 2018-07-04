package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberControllerImpl implements MemberController{
	
	@Autowired
	@Qualifier(value="memberService")
	private MemberServiceImpl memberSerivce;

	@Override
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response) {
		//1. 값추출
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		return null;
	}
	
	@RequestMapping(value="/login.do")
	public String selectOneMember(HttpServletRequest request, @RequestParam String userId, @RequestParam String userPw) {
		//1. 값추출
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		
		//2. 비즈니스 로직 처리
		Member m = memberSerivce.selectOneMember(vo);
		
		HttpSession session = request.getSession();
		
		//3. viewName 리턴
		// viewName을 처리할때 주의할점
		// viewName을 DispatcherServlet에게 돌려주고 자동으로
		// 처리되도록 만들지만! DispatcherServlet에서는
		// 처리할때 무조건 forward 방식만을 사용함
		// (sendRedirect는 사용하지 않음)
		if(m!=null)
		{
			session.setAttribute("member", m);
			return "member/loginSuccess";
		} else {
			return "member/loginFailed";
		}
		
	}
	@RequestMapping(value="/enroll.do")
	public String insertMember() {
		
		return null;
	}
	
}
