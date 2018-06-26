package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.BoardTotalInfoVo;

/**
 * Servlet implementation class AdminBoardDetailServlet
 */
@WebServlet(name = "AdminBoardDetail", urlPatterns = { "/adminBoardDetail" })
public class AdminBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String bdNostr = request.getParameter("bdNo");
		int bdNo = 0;
		if(bdNostr != null) {
			bdNo = Integer.parseInt(bdNostr);
		}
		//int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		
		BoardTotalInfoVo btlv = new AdminService().selectBoardOne(bdNo);
		/*if(btlv != null) {*/
			RequestDispatcher view  = request.getRequestDispatcher("/View/admin/board/boardDetail.jsp");
			request.setAttribute("boardDetail", btlv);
			view.forward(request, response);
		/*}else {
			response.sendRedirect("/View/error/errorPage");
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
