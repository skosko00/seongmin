package notice.controller;

import java.io.IOException;

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
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet(name = "NoticeUpdate", urlPatterns = { "/noticeUpdate" })
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.변수에 저장
		String subject = request.getParameter("subject");
		String contents = request.getParameter("contents");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		int result = 0;
		//3.비즈니스 로직
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user")!=null && ((Member)session.getAttribute("user")).getUserId().equals("admin"))
		{
		result = new NoticeService().noticeUpdate(subject,noticeNo,contents);
		
		if(result>0)
		{
			response.sendRedirect("/noticeSelect?noticeNo="+noticeNo);
		}
		else
		{
			response.sendRedirect("/views/notice/Error.html");
		}
		}
		else
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
