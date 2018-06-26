package jsp.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.service.BoardService;
import jsp.board.model.vo.Page;

/**
 * Servlet implementation class ReviewBoardServlet
 */
@WebServlet(name = "Review", urlPatterns = { "/review" })
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 고객 후기 게시글 불러오기
		int currentPage;
		
		if(request.getParameter("currentPage") == null) {
			currentPage = 1;
		}
		else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		Page p = new BoardService().reviewAll(currentPage);
	
		
		RequestDispatcher view = request.getRequestDispatcher("/View/board/review.jsp");
		request.setAttribute("Page", p);
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
