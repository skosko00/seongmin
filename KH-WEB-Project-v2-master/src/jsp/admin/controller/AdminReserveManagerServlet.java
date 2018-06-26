package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.ReservePageVo;

/**
 * Servlet implementation class AdminMemberListServlet
 */
@WebServlet(name = "AdminReserveManager", urlPatterns = { "/adminReserveManager" })
public class AdminReserveManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReserveManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		String searchData = request.getParameter("searchData");
		String searchOption = request.getParameter("searchOption");
		
		int currentPage =0;
		
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		ReservePageVo mpv = null;
		if(searchData != null && searchOption != null) {
			
			mpv = new AdminService().reserveList(currentPage,searchData,searchOption);
			
		}else {
			mpv = new AdminService().reserveList(currentPage);
		}
			RequestDispatcher view = request.getRequestDispatcher("/View/admin/reserve/reserveManager.jsp");
			request.setAttribute("ReservePage",mpv );
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
