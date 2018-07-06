package org.kh.member.controller;

import java.util.ArrayList;

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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberControllerImpl implements MemberController{

	@Autowired
	@Qualifier(value="memberService")
	private MemberServiceImpl memberService;

	public String selectOneMember(HttpServletRequest request, HttpServletResponse response) {
		//1. 값추출
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));
		return null;
	}

	@Override
	@RequestMapping(value="/login.do")
	public String selectOneMember(HttpServletRequest request, @RequestParam String userId, @RequestParam String userPw) {
		//1. 값추출
		Member vo = new Member();
		vo.setUserId(request.getParameter("userId"));
		vo.setUserPw(request.getParameter("userPw"));

		//2. 비즈니스 로직 처리
		Member m = memberService.selectOneMember(vo);

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

	@Override
	@RequestMapping(value="/logout.do")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/index.jsp";
		// redirect가 붙을 경우 ViewResolver가 관여하지 않음
	}

	@Override
	@RequestMapping(value="/myInfo.do")
	public Object myInfo(HttpSession session) {
		Member vo = (Member)session.getAttribute("member");
		Member m = memberService.selectOneMember(vo);
		ModelAndView view = new ModelAndView();
		if(m!=null)
		{
			view.addObject("mem", m);
			view.setViewName("member/myPage");
			return view;
		} else {
			view.setViewName("member/error");
			return view;
		}
	}
	
	@Override
	@RequestMapping(value="/mUpdate.do")
	public String memberUpdate(Member vo, HttpSession session) {
		int result = memberService.updateMember(vo);
		
		if(result>0) {
			session.setAttribute("member", vo);
			return "member/mUpdateSuccess";
		} else {
			return "member/mUpdateFail";
		}
		
	}
	
	@RequestMapping(value="/enrollView.do")
	public String enrollView() {
		
		return "member/enroll";
	}

	@RequestMapping(value="/enroll.do")
	public String insertMember(Member vo) {
		
		int result = memberService.insertMember(vo);
		
		if(result>0) {
			return "redirect:/index.jsp";
		} else {
			return "member/enroll";
		}
	}
	
	@RequestMapping(value="/deleteMember.do")
	public String deleteMember(HttpSession session) {
		Member vo = (Member)session.getAttribute("member");
		int result = memberService.deleteMember(vo);
		
		if(result>0) {
			session.invalidate();
			return "member/deleteSuccess";
		} else {
			return "member/deleteFailed";
		}
		
	}
	
	@RequestMapping(value="/allMember.do")
	public Object AllMember() {
		
		ArrayList<Member> list = memberService.allMember();
		
		ModelAndView view = new ModelAndView();
		
		if(!list.isEmpty()) {
			view.addObject("memberList",list);
			view.setViewName("member/allMember");
			return view;
		} else {
			view.setViewName("member/error");
			return view;
		}
	}

}
