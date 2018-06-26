package jsp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.service.BoardService;

/**
 * Servlet implementation class CommentUpdateServlet
 */
@WebServlet(name = "CommentUpdate", urlPatterns = { "/commentUpdate" })
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.View에서 넘겨준 값을 변수에 저장
		String CM_CONTENTS = request.getParameter("CM_CONTENTS");
		int CM_NO = Integer.parseInt(request.getParameter("CM_NO"));
		int CM_BD_NO = Integer.parseInt(request.getParameter("CM_BD_NO"));
		
		//3.비즈니스 로직
		int result = new BoardService().updateComment(CM_CONTENTS,CM_NO);
		if(result>0) {//값이 들어오면
			response.sendRedirect("/reviewSelect?bdNo=" + CM_BD_NO);
		}else { //값이 안들어오면
			response.sendRedirect("/View/Error/Error.jsp");
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
