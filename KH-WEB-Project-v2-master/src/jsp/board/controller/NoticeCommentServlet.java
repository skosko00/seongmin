package jsp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.board.model.service.BoardService;
import jsp.board.model.vo.Comment;
import jsp.member.model.vo.MemberVo;

/**
 * Servlet implementation class NoticeCommentServlet
 */
@WebServlet(name = "NoticeComment", urlPatterns = { "/noticeComment" })
public class NoticeCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 변수값 저장(내용, 게시물 번호)
		String CM_CONTENTS = request.getParameter("CM_CONTENTS");
		int BD_NO = Integer.parseInt(request.getParameter("bdNo"));
		HttpSession session = request.getSession(false);
		
		
		if(session.getAttribute("member")!=null) { //로그인이 된 상태라면
			Comment c = new Comment();
			c.setCmBdNo(BD_NO);
			c.setCmContents(CM_CONTENTS);
			c.setCmWriter(((MemberVo)session.getAttribute("member")).getMbId());
		
			int result = new BoardService().insertComment(c);
			
			if(result>0) {//댓글내용이 들어오면
				response.sendRedirect("/reviewSelect?bdNo="+BD_NO);
			}else {//내용이 안들어오면
				response.sendRedirect("/View/error/error.jsp");
			}
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
