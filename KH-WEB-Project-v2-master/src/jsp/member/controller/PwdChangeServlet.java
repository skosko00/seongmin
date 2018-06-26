package jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.SHA256Hash;
import jsp.member.model.service.MemberService;
import jsp.member.model.vo.MemberVo;

@WebServlet(name = "PwdChange", urlPatterns = { "/pwdChange" })
public class PwdChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PwdChangeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getParameter("utf-8");

		String pwdBefore = new SHA256Hash().enctyptSHA256(request.getParameter("pwdBefore"));
		String id = request.getParameter("id");

		MemberVo mv = new MemberService().login(id, pwdBefore);

		if (mv != null) {
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
