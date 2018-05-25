package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

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

		//세션값이 있다면 해당 세션값을 사용
		//세션값이 없다면 null 리턴
		if(session.getAttribute("user")!=null)	//세션이 null이 아니라면! (즉, 있다면!)
		{
			String userId = ((Member)session.getAttribute("user")).getUserId();
			String userPwd = request.getParameter("userPwd");
			Member m = new MemberService().selectOne(userId,userPwd);
			if(m!=null)
			{
				RequestDispatcher view = request.getRequestDispatcher("/views/member/myInfo.jsp");
				request.setAttribute("userInfo", m);
				view.forward(request, response);
			}
			else {
				response.sendRedirect("/views/member/loginfaile.jsp");
			}
		}else
		{
			response.sendRedirect("/views/member/error.html");
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
