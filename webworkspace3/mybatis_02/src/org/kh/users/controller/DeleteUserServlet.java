package org.kh.users.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.users.model.service.UserServiceImpl;
import org.kh.users.model.vo.Users;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet(name = "DeleteUser", urlPatterns = { "/deleteUser" })
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		
		int result = new UserServiceImpl().deleteUser(users);
		
		response.setContentType("text/html; charset=utf-8");
		
		if(result>0) {
			response.getWriter().println("삭제되었습니다.");
		}else {
			response.getWriter().println("삭제의 실패했습니다.");
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
