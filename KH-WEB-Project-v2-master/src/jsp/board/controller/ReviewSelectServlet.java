package jsp.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.BoardTotalInfoVo;
import jsp.board.model.service.BoardService;
import jsp.board.model.service.CommentService;
import jsp.board.model.vo.Comment;
import jsp.member.model.vo.MemberVo;

/**
 * Servlet implementation class ReviewSelectServlet
 */
@WebServlet(name = "ReviewSelect", urlPatterns = { "/reviewSelect" })
public class ReviewSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		
		// 선택한 후기 불러오기
		
		BoardTotalInfoVo btlv = new AdminService().selectBoardOne(bdNo);
		
		// 선택한 후기에 대한 댓글 불러오기
		ArrayList<Comment> list = new CommentService().selectComment(bdNo);
		
		// 조회수 카운트
		int inquiryResult = new BoardService().hitsCount(bdNo);
		
		// 추천 여부
		HttpSession session = request.getSession(false);
		int rmConfirm = 0;
		if((MemberVo)session.getAttribute("member") != null) {
			String rmId = ((MemberVo)session.getAttribute("member")).getMbId();
			rmConfirm = new BoardService().recommendConfirm(bdNo, rmId);
			// 0이면 추천 안함, 1이면 추천했었음
		}
		
		// 사진 불러오기
		
		
		if(btlv != null) {
			if(inquiryResult > 0) {
				RequestDispatcher view = request.getRequestDispatcher("/View/board/reviewSelect.jsp");
				request.setAttribute("review", btlv); // 후기 객체
				request.setAttribute("comment", list); // 댓글 객체 리스트
				request.setAttribute("rmConfirm", rmConfirm);
				view.forward(request, response);
			}
			else {
				response.sendRedirect("/View/error/error.jsp");
			}
		}
		else {
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
