package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.SalesPageVo;

/**
 * Servlet implementation class AdminSalesManagerServlet
 */
@WebServlet(name = "AdminSalesManager", urlPatterns = { "/adminSalesManager" })
public class AdminSalesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSalesManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		// page정보, pageper정보 없으면 1로 줄까?
		int currentPage =0;
		String searchData = request.getParameter("searchData");
		String searchOption = request.getParameter("searchOption");

		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		SalesPageVo spv = null;
		if(searchData != null && searchOption != null) {
			spv = new AdminService().salesList(currentPage,searchData,searchOption);
		}else {
			spv = new AdminService().salesList(currentPage);
		}

		RequestDispatcher view = request.getRequestDispatcher("/View/admin/sales/salesManager.jsp");
		request.setAttribute("SalesPage",spv );
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
