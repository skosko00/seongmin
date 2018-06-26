package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.QnAVo;

/**
 * Servlet implementation class AdminQuestionDetailServlet
 */
@WebServlet(name = "adminQuestionDetail", urlPatterns = { "/adminQuestionDetail" })
public class AdminQuestionDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminQuestionDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//
		request.setCharacterEncoding("utf-8");
		
		int qNo = Integer.parseInt(request.getParameter("qNo"));
		//
		QnAVo qnav = new AdminService().selectOneQuestion(qNo);
		//
		RequestDispatcher view = request.getRequestDispatcher("/View/admin/board/boardQuestionDetail.jsp");
		request.setAttribute("qnaVo", qnav);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
