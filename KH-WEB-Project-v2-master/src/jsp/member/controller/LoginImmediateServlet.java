package jsp.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.SHA256Hash;
import jsp.member.model.service.MemberService;
import jsp.member.model.vo.MemberVo;

@WebServlet(name = "LoginImmediate", urlPatterns = { "/loginImmediate" })
public class LoginImmediateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginImmediateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// AJAX로 로그인
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = new SHA256Hash().enctyptSHA256(request.getParameter("pwd"));

		MemberVo mv = new MemberService().login(id, pwd);

		if (mv != null) {
			response.getWriter().print("1");
			HttpSession session = request.getSession();
			session.setAttribute("member", mv);

			String logBrowser = new String();
			String accessInfo = request.getHeader("User-Agent");

			if (accessInfo.indexOf("Trident") > 0 || accessInfo.indexOf("MSIE") > 0) {
				logBrowser = "IE";
			} else if (accessInfo.indexOf("Opera") > 0) {
				logBrowser = "Opera";
			} else if (accessInfo.indexOf("Firefox") > 0) {
				logBrowser = "Firefox";
			} else if (accessInfo.indexOf("Safari") > 0) {
				if (accessInfo.indexOf("Chrome") > 0) {
					logBrowser = "Chrome";
				} else {
					logBrowser = "Safari";
				}
			} else {
				logBrowser = "etc";
			}

			String logId = mv.getMbId();
			String logIp = request.getRemoteHost();
			String logLocale = String.valueOf(request.getLocale());

			new MemberService().memberLog(logId, logBrowser, logIp, logLocale);
		} 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
