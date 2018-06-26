package jsp.common;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmailAuth", urlPatterns = { "/emailAuth" })
public class EmailAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmailAuthServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		// 이메일 인증 번호 랜덤
		int authNum = (int) (Math.random() * 799999) + 200000;
		String email = request.getParameter("email");
		
		// 이메일 전송
		new EmailAuthSend().sendMail(email, authNum);
		
		response.getWriter().println(authNum);
		response.getWriter().close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
