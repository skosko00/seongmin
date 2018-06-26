package jsp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.AdminIndexVo;
import jsp.board.model.vo.BoardVo;
import jsp.member.model.vo.QuestionVo;

/**
 * Servlet implementation class AdminIndexServlet
 */
@WebServlet(name = "AdminIndex", urlPatterns = { "/adminIndex" })
public class AdminIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 1. 
		request.setCharacterEncoding("utf-8");
		

		int countReserve = new AdminService().countReserve();
		int countQuestion = new AdminService().countQuesetion();
		int countNewMember = new AdminService().countNewMember();
		ArrayList<BoardVo> boardList = new AdminService().indexBoardList();
		ArrayList<QuestionVo> questionList = new AdminService().indexQuestionList();
		
		AdminIndexVo aiv = new AdminIndexVo(countReserve, countQuestion, countNewMember, boardList, questionList);
		
		RequestDispatcher view  = request.getRequestDispatcher("/View/admin/admin.jsp");
		request.setAttribute("adminInfo",aiv);
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
