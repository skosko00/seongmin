package jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.board.model.service.BoardService;
import jsp.board.model.vo.BoardVo;
import jsp.member.model.vo.MemberVo;

/**
 * Servlet implementation class RecommentBoardServlet
 */
@WebServlet(name = "RecommendBoard", urlPatterns = { "/recommendBoard" })
@SuppressWarnings("all")
public class RecommendBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		
		HttpSession session = request.getSession(false);
		String recommendId = ((MemberVo) session.getAttribute("member")).getMbId();
		
		// false 이면 해당 게시글에 로그인한 계정이 추천을 누른적이 없는 경우, true이면 해당 게시글에 로그인한 계정이 추천을 누른적이 있는 경우
		boolean recommendInquiry = new BoardService().recommendInquiry(bdNo, recommendId);
		
		if(recommendInquiry == false) {
			int recommendAdd = new BoardService().recommendAdd(bdNo);
			int recommendInsert = new BoardService().recommendInsert(bdNo, recommendId);
		}	
			
		BoardVo bv = new BoardService().boardBdNo(bdNo);
				
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(bv.getBdRecommendCount());
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
