package jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.board.model.service.BoardService;
import jsp.board.model.vo.BoardVo;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet(name = "NoticeWrite", urlPatterns = { "/noticeWrite" })
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.인코딩
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);

		if (session.getAttribute("member") != null) {

			String bdWriter = request.getParameter("bd_Writer");
			String bdName = request.getParameter("bd_Name");
			String bdContents = request.getParameter("bd_Contents");

			BoardVo board = new BoardVo();
			board.setBdName(bdName);
			board.setBdContents(bdContents);
			board.setBdWriter(bdWriter);

			// 3.비즈니스 로직 처리
			int result = new BoardService().insertNotice(board);

			if (result > 0) {// 글쓰기가 정상작동 할경우
				response.sendRedirect("/review");
			} else {// 작동이 안될경우
				response.sendRedirect("/View/error/error.jsp");
			}

		} else {// 세션이 제대로 연결되지 않은경우
			response.sendRedirect("/View/error/error.jsp");
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
