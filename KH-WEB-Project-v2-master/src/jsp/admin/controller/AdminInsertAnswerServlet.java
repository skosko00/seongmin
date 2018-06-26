package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.AnswerVo;

/**
 * Servlet implementation class AdminInsertAnswerServlet
 */
@WebServlet(name = "AdminInsertAnswer", urlPatterns = { "/adminInsertAnswer" })
public class AdminInsertAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsertAnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String aContents = request.getParameter("aContents");
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		AnswerVo asv = new AnswerVo();
		asv.setaQNo(qNo);
		asv.setaContents(aContents);
		boolean result = new AdminService().insertAnswer(asv);
		
		if(result) {
			response.sendRedirect("/adminQuestionDetail?qNo="+qNo);
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
