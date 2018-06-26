package jsp.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.board.model.service.BoardService;
import jsp.board.model.vo.DataFile;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet(name = "ReviewDelete", urlPatterns = { "/reviewDelete" })
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));

		// 2.비즈니스 로직

		HttpSession session = request.getSession(false);

		ArrayList<DataFile> list = new BoardService().deleteImageFile(bdNo);

		for (int i = 0; i < list.size(); i++) {
			File file = new File(getServletContext().getRealPath("/") + list.get(i).getBdFilePath());
			file.delete();
		}
		int result = 0; // 게시글 삭제
		int result1 = new BoardService().deleteCommentNotice(bdNo); // 댓글 삭제
		if (session.getAttribute("member") != null) {

			if (result1 > -1) { // 댓글 삭제가 성공하면
				result = new BoardService().deleteReview(bdNo); // 글 삭제 진행
				if (result > 0) { // 게시글삭제가 성공하면
					response.sendRedirect("/review");
				} else {// 게시글 삭제가 실패하면
					response.sendRedirect("/View/error/error.jsp");

				}
			} else {
				response.sendRedirect("/View/error/error.jsp");
			}
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
