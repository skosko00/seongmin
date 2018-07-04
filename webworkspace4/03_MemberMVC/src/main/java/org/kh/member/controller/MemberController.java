package org.kh.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberController {
	public String selectOneMember(HttpServletRequest request, HttpServletResponse response);
}
