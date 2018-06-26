package jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.member.model.service.MemberService;

@WebServlet(name = "IdCheck", urlPatterns = { "/idCheck" })
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IdCheckServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		int result = new MemberService().idCheck(id);

		response.getWriter().println(result);
		response.getWriter().close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
