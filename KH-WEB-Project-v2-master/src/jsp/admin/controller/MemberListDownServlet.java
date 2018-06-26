package jsp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.common.PensionExcelWriter;
import jsp.member.model.vo.MemberVo;

/**
 * Servlet implementation class MemberListDownServlet
 */
@WebServlet(name = "MemberListDown", urlPatterns = { "/memberListDown" })
public class MemberListDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<MemberVo> list = new AdminService().memberListDown();
		String path = getServletContext().getRealPath("/")+"pansionMember.xlsx";
		boolean result = new PensionExcelWriter().memberListWriter(list,path);
		System.out.println(request.getRequestURL().toString());
		if(result) {
			response.sendRedirect("/adminMemberList");
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
