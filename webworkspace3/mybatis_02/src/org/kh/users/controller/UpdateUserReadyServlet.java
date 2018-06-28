package org.kh.users.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.users.model.service.UserServiceImpl;
import org.kh.users.model.vo.Users;

/**
 * Servlet implementation class UpdateUserReadyServlet
 */
@WebServlet(name = "UpdateUserReady", urlPatterns = { "/updateUserReady" })
public class UpdateUserReadyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserReadyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		Users users = new Users();
		
		users.setUserId(request.getParameter("userId"));
		users.setUserPw(request.getParameter("userPw"));
		
		Users result = new UserServiceImpl().oneUserSelect(users);
		response.setContentType("text/html; charset=utf-8");
		if(result!=null)
		{
			RequestDispatcher view = request.getRequestDispatcher("/views/users/updateUser.jsp");
			request.setAttribute("users", result);
			view.forward(request, response);
		}else {
			response.getWriter().println("검색하지 못하였습니다.");
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
