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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Notice n = new Notice();
		int result = 0;
		HttpSession session = request.getSession(false);
		if(session.getAttribute("user")!=null && ((Member)session.getAttribute("user")).getUserId().equals("admin"))
		{
			n.setUserId(((Member)session.getAttribute("user")).getUserId());
			n.setSubject(request.getParameter("subject"));
			n.setContents(request.getParameter("contents"));
			result = new NoticeService().noticeWrite(n);
			if(result>0)
			{
				response.sendRedirect("/notice");
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
