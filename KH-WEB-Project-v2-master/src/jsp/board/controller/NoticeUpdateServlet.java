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
		request.setCharacterEncoding("UTF-8");
		
	//2.view에서 값 받아서 변수 지정
		int bdNo = Integer.parseInt(request.getParameter("bdNo"));
		String bdName = request.getParameter("bdName");
		String bdContents = request.getParameter("bdContents");
		
		
		BoardVo board = new BoardVo();
		board.setBdNo(bdNo);
		board.setBdName(bdName);
		board.setBdContents(bdContents);
		
		HttpSession session=request.getSession(false);
		
		if(session.getAttribute("member")!=null) {
			int result = new BoardService().updateNotice(board);
			
			if(result>0) {//값이 들어오면
				response.sendRedirect("/reviewSelect?bdNo=" + bdNo + "");
			}else {//값이 안들어오면
				response.sendRedirect("/View/error/error.jsp");
			}
		}else {//세션값을 받아오지 못하면
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
