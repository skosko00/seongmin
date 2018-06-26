package jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.board.model.service.CommentService;
import jsp.board.model.vo.Comment;
import jsp.member.model.vo.MemberVo;

/**
 * Servlet implementation class RecommendCommentServlet
 */
@WebServlet(name = "RecommendComment", urlPatterns = { "/recommendComment" })
@SuppressWarnings("all")
public class RecommendCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int cmNo = Integer.parseInt(request.getParameter("cmNo"));
		
		HttpSession session = request.getSession(false);
		String recommendId = ((MemberVo) session.getAttribute("member")).getMbId();
		
		// false 이면 해당 게시글에 로그인한 계정이 추천을 누른적이 없는 경우, true이면 해당 게시글에 로그인한 계정이 추천을 누른적이 있는 경우
		boolean recommendInquiry = new CommentService().recommendInquiry(cmNo, recommendId);
				
		if(recommendInquiry == false) {
			int recommendAdd = new CommentService().recommendAdd(cmNo);
			int recommendInsert = new CommentService().recommendInsert(cmNo, recommendId);
		}	
		
		Comment c = new CommentService().commentCmNo(cmNo);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(c.getCmRecCount());
		response.getWriter().close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
