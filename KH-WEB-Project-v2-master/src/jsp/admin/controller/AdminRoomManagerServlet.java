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
import jsp.reservation.model.vo.PensionVo;

/**
 * Servlet implementation class AdminRoomManagerServlet
 */
@WebServlet(name = "AdminRoomManager", urlPatterns = { "/adminRoomManager" })
public class AdminRoomManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRoomManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    ///adminRoomManager
    ///adminRoomManager
    // 1. 객실 정보들을 불러오는 페이지...
    // 2. 페이지를 불러올 필요는 없을 것이다.  (객실이 많지는 않을 것 )
    // 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//1. 한글
		request.setCharacterEncoding("utf-8");
		ArrayList<PensionVo> list = new AdminService().AllRoomList();
		//ArrayList<PensionVo> list = new AdminService().AllRoomList();
		// 리스트가 없을 수 있다.
		/*if(!list.isEmpty()) {*/
			RequestDispatcher view = request.getRequestDispatcher("/View/admin/room/roomManager.jsp");
			request.setAttribute("roomlist", list);
			view.forward(request, response);
			
			/*}else {
				
				response.sendRedirect("/View/error/error.jsp");
				
			}	*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
