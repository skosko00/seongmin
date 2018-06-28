package org.kh.users.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.users.model.service.UserServiceImpl;
import org.kh.users.model.vo.Users;

/**
 * Servlet implementation class AllUserSerlvet
 */
@WebServlet(name = "AllUser", urlPatterns = { "/allUser" })
public class AllUserSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUserSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Users> list = new UserServiceImpl().allUser();
		response.setContentType("text/html; charset=utf-8");
		if(!list.isEmpty()){
			RequestDispatcher view = request.getRequestDispatcher("/views/users/allUser.jsp");
			request.setAttribute("list", list);
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
