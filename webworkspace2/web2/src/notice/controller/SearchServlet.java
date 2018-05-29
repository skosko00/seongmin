package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.PageData;

/**
 * Servlet implementation class SearchNoticeServlet
 */
@WebServlet(name = "Search", urlPatterns = { "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		
		int currentPage; //현재 페이지 값을 저장하는 변수
		if(request.getParameter("currentPage")==null)currentPage=1;
		else currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		PageData pd = new NoticeService().getSearchPage(currentPage,search);
		if(pd!=null)
		{
			RequestDispatcher view = request.getRequestDispatcher("/views/notice/search.jsp");
			request.setAttribute("pageData", pd);
			request.setAttribute("search", search);
			view.forward(request, response);
		}else
		{
			response.sendRedirect("/views/notice/Error.html");
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
