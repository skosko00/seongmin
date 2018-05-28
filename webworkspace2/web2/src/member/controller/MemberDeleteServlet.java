package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyDeleteServlet
 */
@WebServlet(name = "MemberDelete", urlPatterns = { "/memberDelete" })
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		// 1. 전송값에 한글이 있을 경우를 처리할 수 있도록 인코딩 처리
		request.setCharacterEncoding("utf-8");
		// 2. View에서 전송한 데이터를 받아 변수에 저장
		String userId = ((Member)session.getAttribute("user")).getUserId();
		String userPwd = request.getParameter("userPwd");
		// 3. 비즈니스 로직 처리 (Controller->Service->DAO->DB 처리후 리턴)
		int result = new MemberService().memberdelete(userId,userPwd);
		// 4. 처리 결과에 따라 성공/실패 페이지 리턴
		if(result>0)
		{
			session.invalidate();
			//회원 탈퇴후에는 해당 계정을 더이상 사용하지 못하게
			//회원 정보 삭제 및 세션 파기 작업을 해야 함
			response.sendRedirect("/views/member/memberDelete.jsp");
		}else
		{
			response.sendRedirect("/views/member/error.html");
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
