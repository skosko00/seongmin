package jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.board.model.service.BoardService;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet(name = "CommentDelete", urlPatterns = { "/commentDelete" })
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 2. 변수에 값 저장

		int CM_NO = Integer.parseInt(request.getParameter("CM_NO"));
		int CM_BD_NO = Integer.parseInt(request.getParameter("CM_BD_NO"));

		HttpSession session = request.getSession(false); // false는 로그인했으면 그정보를 그대로 쓰고 없으면 null값을 리턴
															// true면 정보가 없으면 새로운 세션값을 생성함
		// 3. 비즈니스 로직(admin이 보낸것이 맞는지 확인 해야 함)
		// && ((MemberVo)session.getAttribute("member")).getMbId().equals("thepension")
		if (session.getAttribute("member") != null) {
			int result = new BoardService().deleteComment(CM_NO);
			// 4.view를 통하여 출력
			if (result > 0) {// 삭제가 성공할경우
				response.sendRedirect("/reviewSelect?bdNo=" + CM_BD_NO);
			} else { // 삭제 실패한경우
				response.sendRedirect("/View/error/error.jsp");
			}

		} else {
			// System.out.println("test");
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
