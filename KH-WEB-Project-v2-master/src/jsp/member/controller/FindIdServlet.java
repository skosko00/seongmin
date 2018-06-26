package jsp.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jsp.member.model.service.MemberService;
import jsp.member.model.vo.FindIdVo;
import jsp.member.model.vo.MemberVo;

@WebServlet(name = "FindId", urlPatterns = { "/findId" })
public class FindIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindIdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String email = request.getParameter("email");
		String name = request.getParameter("name");

		try {
			MemberVo mv = new MemberService().findId(email, name);
			String id = mv.getMbId();
			Date entDate = mv.getMbEntDate();

			FindIdVo fv = new FindIdVo();

			fv.setId(id);
			fv.setEntDate(entDate);

			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(fv, response.getWriter());

		} catch (Exception e) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			new Gson().toJson("없음", response.getWriter());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
