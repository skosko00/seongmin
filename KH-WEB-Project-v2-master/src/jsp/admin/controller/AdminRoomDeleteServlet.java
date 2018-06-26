package jsp.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.main.model.vo.PensionPicTb;

/**
 * Servlet implementation class AdminRoomDeleteServlet
 */
@WebServlet(name = "AdminRoomDelete", urlPatterns = { "/adminRoomDelete" })
public class AdminRoomDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRoomDeleteServlet() {
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
		String roomName = request.getParameter("roomName");
		// 1. 디비의 사진 가져오기
		ArrayList<PensionPicTb> list = new AdminService().delPicList(roomName);
		// 2. 디비 지우기
		boolean result = new AdminService().roomDeleteFinal(roomName,list.size());
		
		// 3. 파일 삭제
		if(result) {
			for(PensionPicTb ppt:list) {
			 File file = new File(getServletContext().getRealPath("/")+ppt.getPsPicPath());
			 file.delete();
			}
			response.sendRedirect("/adminRoomManager");
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