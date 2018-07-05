package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.vo.Member;
import org.springframework.web.servlet.ModelAndView;

public interface MemberController {
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response);
	public String logOut(HttpServletRequest request);
	public Object myInfo(HttpSession session);
	public String memberUpdate(Member vo, HttpSession session);
}
