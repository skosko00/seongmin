package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberActivationServlet
 */
@WebServlet(name = "MemberActivation", urlPatterns = { "/memberActivation" })
public class MemberActivationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberActivationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String active = request.getParameter("active");
		String userId = request.getParameter("userId");
		if(userId.equals("admin")) {
			response.sendRedirect("/views/member/adminActivationerror.jsp");
			return;
		}
		else {
			if(active.toUpperCase().equals("Y")) {
				active = "N";
			}
			else
			{
				active = "Y";
			}
		}
		int result = new MemberService().activation(active,userId);
		if(result>0)
		{
			response.sendRedirect("/allMember");
		}else
		{
			response.sendRedirect("/views/member/activationerror.jsp");
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
