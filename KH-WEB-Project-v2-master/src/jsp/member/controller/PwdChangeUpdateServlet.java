package jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.SHA256Hash;
import jsp.member.model.service.MemberService;

@WebServlet(name = "PwdChangeUpdate", urlPatterns = { "/pwdChangeUpdate" })
public class PwdChangeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PwdChangeUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = new SHA256Hash().enctyptSHA256(request.getParameter("pwdAfter"));

		int result = new MemberService().pwdChange(id, pwd);

		if (result > 0) {
			response.getWriter().print("1");
			response.getWriter().close();
		} else {
			response.getWriter().print("0");
			response.getWriter().close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
