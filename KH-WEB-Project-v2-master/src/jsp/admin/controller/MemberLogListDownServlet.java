package jsp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.MemberLoginLogVo;
import jsp.common.PensionExcelWriter;
import jsp.member.model.vo.MemberVo;

/**
 * Servlet implementation class MemberLogListDownServlet
 */
@WebServlet(name = "MemberLogListDown", urlPatterns = { "/memberLogListDown" })
public class MemberLogListDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogListDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<MemberLoginLogVo> list = new AdminService().memberLogListDown();
		String path = getServletContext().getRealPath("/")+"memberLogMember.xlsx";
		boolean result = new PensionExcelWriter().memberLogListWriter(list,path);
		System.out.println(request.getRequestURL().toString());
		if(result) {
			response.sendRedirect("/adminMemberLog");
			// 성공 메시지를 띄워야 한다.
		}else {
			response.sendRedirect("/View/error/errorPage.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
