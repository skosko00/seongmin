package org.kh.users.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.users.model.service.UsersService;
import org.kh.users.model.vo.Search;
import org.kh.users.model.vo.User;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "Search", urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 값 가져오기
		String select = request.getParameter("select");
		String keyword = request.getParameter("keyword");
		
		Search search = new Search(select,keyword);
		
		//3. 비즈니스 로직
		ArrayList<User> list = new UsersService().searchUserList(search);
		
		//4. 결과값 출력
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
