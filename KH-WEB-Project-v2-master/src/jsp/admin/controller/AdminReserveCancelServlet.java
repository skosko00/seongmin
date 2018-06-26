package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.ReserveCancelPageVo;

/**
 * Servlet implementation class AdminReserveCancelServlet
 */
@WebServlet(name = "AdminReserveCancel", urlPatterns = { "/adminReserveCancel" })
public class AdminReserveCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReserveCancelServlet() {
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
		
		
		ReserveCancelPageVo rcpv = null;
		if(searchData != null && searchOption != null) {
			
			rcpv = new AdminService().reserveCancelList(currentPage,searchData,searchOption);
			
		}else {
			rcpv = new AdminService().reserveCancelList(currentPage);
		}
		
		
			RequestDispatcher view = request.getRequestDispatcher("/View/admin/reserve/reservationCancel.jsp");
			request.setAttribute("ReserveCancelPage",rcpv);
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
