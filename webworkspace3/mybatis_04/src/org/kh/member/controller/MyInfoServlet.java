package org.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;

/**
 * Servlet implementation class MyInfoServlet
 */
@WebServlet(name = "MyInfo", urlPatterns = { "/myInfo" })
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("member")!=null)
		{
			Member m = new Member();
			m.setMemberId(((Member)session.getAttribute("member")).getMemberId());
			m.setMemberPw(((Member)session.getAttribute("member")).getMemberPw());
			Member result = new MemberServiceImpl().loginMember(m);
			if(result!=null)
			{
				RequestDispatcher view = request.getRequestDispatcher("views/member/myInfo.jsp");
				request.setAttribute("member", result);
				view.forward(request, response);
			} else {
				response.sendRedirect("/views/error.jsp");
			}
		} else {
			response.sendRedirect("/views/error.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
