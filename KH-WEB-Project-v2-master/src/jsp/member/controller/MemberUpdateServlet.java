package jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.member.model.service.MemberService;

@WebServlet(name = "MemberUpdate", urlPatterns = { "/memberUpdate" })
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberUpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String address = request.getParameter("address");
		String addressDetail = request.getParameter("addressDetail");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");

		String fullAddress = "";

		if (addressDetail != "") {
			fullAddress = address + " " + addressDetail;
		} else {
			fullAddress = address;
		}

		int result = new MemberService().memberUpdate(id, phone, fullAddress);

		response.getWriter().print(result);
		response.getWriter().close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
