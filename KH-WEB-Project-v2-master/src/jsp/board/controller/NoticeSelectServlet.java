package jsp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.BoardTotalInfoVo;
import jsp.board.model.service.BoardService;
import jsp.board.model.vo.Comment;

/**
 * Servlet implementation class NoticeSelectServlet
 */
@WebServlet(name = "noticeSelect", urlPatterns = { "/noticeSelect" })
public class NoticeSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeSelectServlet() {

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 2. view 에서 보낸 데이터를 변수에 저장
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));

		// 3. 비즈니스 로직(조회수)
		int hitsResult = new BoardService().hitsCount(bdNo);
		
		// 3. 비즈니스 로직(공지사항 내용)
		BoardTotalInfoVo btlv = new AdminService().selectBoardOne(bdNo);

		// 3. 비즈니스 로직(댓글 내용)
		ArrayList<Comment> list = new BoardService().Comment(bdNo);
		
		// 4. View에 결과 출력
		if (btlv != null && hitsResult>0) {
			RequestDispatcher view = request.getRequestDispatcher("/View/board/noticeSelect.jsp");
			request.setAttribute("board", btlv);
			request.setAttribute("comment", list);
			view.forward(request, response);
		} else {
			response.sendRedirect("/Views/error/error.jsp");
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
