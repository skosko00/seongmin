package jsp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.board.model.vo.DataFile;
import jsp.common.PensionFileDel;

/**
 * Servlet implementation class AdminBoardDeleteServlet
 */
@WebServlet(name = "AdminBoardDelete", urlPatterns = { "/adminBoardDelete" })
public class AdminBoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminBoardDeleteServlet() {
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
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		String path = getServletContext().getRealPath("/");
		// 1. 파일 가져오기
		ArrayList<DataFile> list = new AdminService().boardFileList(bdNo);
		// 2. 파일 삭제 하기
		
		boolean reusltFile = new PensionFileDel().boardFileListDel(list,path);
		// 3. 디비 삭제
		if(reusltFile){
			System.out.println("삭제 성공 ");
		}else {
			System.out.println("삭제 실패");
		}
		
		boolean result = new AdminService().boardCompleteDel(bdNo);
		
		if(result) {
			response.sendRedirect("/adminBoardList");
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
