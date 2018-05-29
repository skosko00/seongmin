package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import notice.model.service.NoticeService;
import notice.model.vo.Notice;

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
		//2. view에서 보낸 데이터를 변수에 저장
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		Notice notice = null;
		//3. 비즈니스 로직
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user")!=null && ((Member)session.getAttribute("user")).getUserId().equals("admin"))
		{
			notice = new NoticeService().noticeSelect(noticeNo);
		}
		//4. view에 결과 출력
		if(notice!=null)
		{
			RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeUpdateReady.jsp");
			request.setAttribute("notice", notice);
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
