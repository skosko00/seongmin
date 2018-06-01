package file.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import file.model.service.FileService;
import file.model.vo.DataFile2;

/**
 * Servlet implementation class FileRemoveServlet
 */
@WebServlet(name = "FileRemove2", urlPatterns = { "/fileRemove2" })
public class FileRemove2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileRemove2Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 삭제시 진행해야 되는 것 2가지
		// 1. DB에서 정보 삭제
		//		- 비즈니스 로직 처리 (DELETE)
		// 2. 실제 디렉토리에서 실제 파일을 삭제
		//		- a. 경로를 DB에서 알아 온 후 삭제
		//		- b. 경로가 항상 같다면 해당되는 디렉토리를 정적으로 명시하여 삭제
		
		request.setCharacterEncoding("utf-8");

		String afterfileName = request.getParameter("afterfileName");
		DataFile2 df = new FileService().fileSelectDownLoad2(afterfileName);
		if(df!=null)
		{
			int result = new FileService().fileSelectDelete2(afterfileName);
			if(result>0)
			{
				File file = new File(df.getFilePath());
				file.delete();
				response.sendRedirect("/fileList2");
			}else
			{
				response.sendRedirect("/views/file/fileError.html");
			}
		}
		else
		{
			response.sendRedirect("/views/file/fileError.html");
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
