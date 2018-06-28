package org.kh.users.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import org.kh.users.model.service.UsersService;
import org.kh.users.model.vo.Check;
import org.kh.users.model.vo.User;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet(name = "MemberList", urlPatterns = { "/memberList" })
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.process(request,response);
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 매개변수 값 가져오기
		Check check = new Check(
				request.getParameter("chId"),
				request.getParameter("chPw"),
				request.getParameter("chName"),
				request.getParameter("chAddr"));
		
		//3. 비즈니스 로직
		ArrayList<User> list = new UsersService().checkUserList(check);
		
		//4. 결과 출력
		
		response.setContentType("text/html; charset=utf-8");
		if(!list.isEmpty())
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/users/checkList.jsp").forward(request, response);
		} else {
			response.getWriter().println("조회 실패");
		}
	}

}
