package jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.member.model.service.MemberService;

@WebServlet(name = "QuestionSend", urlPatterns = { "/questionSend" })
public class QuestionSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionSendServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String questionName = request.getParameter("questionName");
		String questionContent = request.getParameter("questionContent");
		String id = request.getParameter("id");

		int result = new MemberService().questionSend(questionName, questionContent, id);
		String resultStr = String.valueOf(result);

		response.getWriter().print(resultStr);
		response.getWriter().close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
