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
import notice.model.vo.Comment;

/**
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet(name = "UpdateComment", urlPatterns = { "/updateComment" })
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCommentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(false);
		Comment c = new Comment();
		c.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
		c.setContent(request.getParameter("comment"));
		c.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		int result = new NoticeService().updateComment(c);
		if(result>0)
		{
			response.sendRedirect("/noticeSelect?noticeNo="+c.getNoticeNo());
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
