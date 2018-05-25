package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet(name = "MemberUpdate", urlPatterns = { "/memberUpdate" })
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전송값에 한글이 있을 경우를 처리할 수 있도록 인코딩 처리
				request.setCharacterEncoding("utf-8");
				// 2. View에서 전송한 데이터를 받아 변수에 저장
				Member m = new Member();
				m.setUserId(request.getParameter("userId"));
				m.setUserPwd(request.getParameter("userPwd"));
				m.setEmail(request.getParameter("email"));
				m.setPhone(request.getParameter("phone"));
				m.setAddress(request.getParameter("address"));
				m.setHobby(request.getParameter("hobby"));
				// 3. 비즈니스 로직 처리 (Controller->Service->DAO->DB 처리후 리턴)
				int result = new MemberService().memberUpdate(m);
				// 4. 처리 결과에 따라 성공/실패 페이지 리턴
				if(result>0)
				{
					response.sendRedirect("/views/member/updateSuccess.jsp");
				}else
				{
					response.sendRedirect("/views/member/updateFail.jsp");
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
