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
 * Servlet implementation class BoardServlet
 */
@WebServlet(name = "Search", urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		String searchOption = request.getParameter("searchOption");

		// System.out.println("searchOption값 : "+searchOption);

		int currentPage;
		if(request.getParameter("currentPage")==null) {
			currentPage=1;
		}else{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		Page page = new BoardService().searchNotice(currentPage,search,searchOption);

		RequestDispatcher view = request.getRequestDispatcher("/View/board/noticeSearch.jsp");
		request.setAttribute("Page", page); 
		view.forward(request, response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}