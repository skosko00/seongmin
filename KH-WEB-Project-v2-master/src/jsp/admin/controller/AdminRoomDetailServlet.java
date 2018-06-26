package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.RoomTotalInfoVo;

/**
 * Servlet implementation class AdminRoomDetailServlet
 */
@WebServlet(name = "AdminRoomDetail", urlPatterns = { "/adminRoomDetail" })
public class AdminRoomDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRoomDetailServlet() {
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
		
		String psName = request.getParameter("psName");
		
		RoomTotalInfoVo rtiv  = new AdminService().selectRoomInfo(psName);
		
		if(rtiv != null) {
			RequestDispatcher view = request.getRequestDispatcher("/View/admin/room/roomDetail.jsp");
			request.setAttribute("roomInfo", rtiv);
			view.forward(request, response);
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
