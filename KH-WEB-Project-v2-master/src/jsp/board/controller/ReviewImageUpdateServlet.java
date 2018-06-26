package jsp.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import jsp.board.model.service.BoardService;
import jsp.common.MyFileRenamePolicy;

/**
 * Servlet implementation class ReviewImageUpdateServlet
 */
@WebServlet(name = "ReviewImageUpdate", urlPatterns = { "/reviewImageUpdate" })
@SuppressWarnings("all")
public class ReviewImageUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewImageUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int fileSizeLimit = 10 * 1024 * 1024;
		String uploadFilePath = getServletContext().getRealPath("/") + "Image" + "\\" + "reViewFileUpload";
		String encType = "UTF-8";

		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, fileSizeLimit, encType,
				new MyFileRenamePolicy());

		Enumeration parameter = multi.getParameterNames();

		String value = parameter.nextElement().toString();

		String afterFileName = multi.getFilesystemName("img"); // 새로운 사진 이름
		String afterPath = "/Image/reViewFileUpload/" + afterFileName; // 새로운 사진 이름

		String beforeFileName = multi.getParameter(value); // 전 사진 경로
		int bdNo = Integer.parseInt(multi.getParameter("bdNo"));

		String fullFilePath = uploadFilePath + "\\" + afterFileName;
		File file = new File(fullFilePath); // 해당 파일을 오픈
		long fileSize = file.length();

		int result = new BoardService().reviewUpdateImage(fileSize, afterFileName, afterPath, beforeFileName);
		if (result > 0) {
			file = new File(getServletContext().getRealPath("/") + beforeFileName);
			file.delete();
			response.sendRedirect("/reviewSelect?bdNo=" + bdNo + "");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
