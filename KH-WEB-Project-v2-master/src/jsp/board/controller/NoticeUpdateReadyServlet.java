package jsp.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import jsp.board.model.service.BoardService;
import jsp.board.model.vo.BoardVo;

/**
 * Servlet implementation class NoticeUpdateReadyServlet
 */
@WebServlet(name = "NoticeUpdateReady", urlPatterns = { "/noticeUpdateReady" })
public class NoticeUpdateReadyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateReadyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1.인코딩
		request.setCharacterEncoding("UTF-8");
		
	//2.view에서 보낸 데이터를 변수에 저장
		
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		
		BoardVo board = null;
		
		HttpSession session = request.getSession(false);
		
		if(session.getAttribute("member")!=null) {
			
			//3.비즈니스 로직
			board = new BoardService().noticeSelect(bdNo);
			
		}
		
		//4.view에 결과 출력
		if(board!=null) {
			RequestDispatcher view = request.getRequestDispatcher("/View/board/noticeUpdateReady.jsp");
			request.setAttribute("board", board);
			view.forward(request, response);
		}else {
			response.sendRedirect("/View/error/error.jsp");
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
