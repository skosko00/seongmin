package jsp.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.SHA256Hash;
import jsp.member.model.service.MemberService;
import jsp.member.model.vo.MemberVo;

@WebServlet(name = "SignUp", urlPatterns = { "/signUp" })
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String pwd = new SHA256Hash().enctyptSHA256(request.getParameter("pwd"));
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String gender[] = request.getParameterValues("gender");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String addressDetails = request.getParameter("addressDetails");
		if (!addressDetails.equals("")) {
			address = address + " " + addressDetails;
		}
		String email = request.getParameter("email");
		MemberVo mv = new MemberVo();
		mv.setMbAddress(address);
		mv.setMbBirth(Date.valueOf(birth));
		mv.setMbEmail(email);
		mv.setMbGender(gender[0]);
		mv.setMbId(id);
		mv.setMbName(name);
		mv.setMbPhone(phone);
		mv.setMbPwd(pwd);

		int result = new MemberService().signUp(mv);

		if (result > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/View/member/signUpSuccess.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("/View/error/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
