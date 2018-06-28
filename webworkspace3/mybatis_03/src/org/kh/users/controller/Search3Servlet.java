package org.kh.users.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.users.model.service.UsersService;
import org.kh.users.model.vo.User;

/**
 * Servlet implementation class Search3Servlet
 */
@WebServlet(name = "Search3", urlPatterns = { "/search3" })
public class Search3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Search3Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값 저장
		String [] addr = request.getParameterValues("addr");
		
		//3. 비즈니스 로직 처리
		ArrayList<User> list = new UsersService().search3UserList(addr);
		
		response.setContentType("text/html; charset=utf-8");
		if(!list.isEmpty())
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/users/checkList.jsp").forward(request, response);
		} else {
			response.getWriter().println("조회 실패");
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
