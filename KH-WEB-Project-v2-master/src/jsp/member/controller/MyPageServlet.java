package jsp.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.SHA256Hash;
import jsp.member.model.service.MemberService;
import jsp.member.model.vo.MemberVo;

@WebServlet(name = "MyPage", urlPatterns = { "/myPage" })
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession(false);

		String id = ((MemberVo) session.getAttribute("member")).getMbId();
		String idTest = request.getParameter("idTest");
		String pwd = new SHA256Hash().enctyptSHA256(request.getParameter("pwd"));

		if (id.equals(idTest)) {
			MemberVo mv = new MemberService().login(idTest, pwd);
			if (mv != null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/View/member/myPageView.jsp");
				request.setAttribute("mypage", mv);
				dispatcher.forward(request, response);
			} else {
				response.sendRedirect("/View/error/loginFail.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
