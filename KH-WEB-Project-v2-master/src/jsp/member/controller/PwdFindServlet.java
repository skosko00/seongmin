package jsp.member.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.EmailTempPwdSend;
import jsp.common.SHA256Hash;
import jsp.member.model.service.MemberService;

@WebServlet(name = "PwdFind", urlPatterns = { "/pwdFind" })
public class PwdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PwdFindServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String email = request.getParameter("email");

		int result = new MemberService().findPwd(id, email);

		if (result == 1) {

			StringBuffer tempPwd = new StringBuffer();
			Random ran = new Random();
			for (int i = 0; i < 10; i++) {
				int randomIndex = ran.nextInt(3);
				switch (randomIndex) {
				case 0:
					tempPwd.append((char) ((int) (ran.nextInt(26)) + 97));
					break;
				case 1:
					tempPwd.append((char) ((int) (ran.nextInt(26)) + 65));
					break;
				case 2:
					tempPwd.append((ran.nextInt(10)));
					break;
				}
			}

			new EmailTempPwdSend().sendMail(id, email, tempPwd.toString());
			String encryptTempPwd = new SHA256Hash().enctyptSHA256(tempPwd.toString());
			new MemberService().tempPwdChange(id, email, encryptTempPwd);

			response.setCharacterEncoding("utf-8");
			response.getWriter().print(result);
			response.getWriter().close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
