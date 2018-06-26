package jsp.reservation.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.member.model.service.MemberService;
import jsp.member.model.vo.MemberVo;
import jsp.reservation.model.vo.ReservationVo;

/**
 * Servlet implementation class ReservationThirdStepServlet
 */
@WebServlet(name = "ReservationThirdStep", urlPatterns = { "/reservationThirdStep" })
public class ReservationThirdStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationThirdStepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 문자 인코딩
				request.setCharacterEncoding("UTF-8");
				
				// 2. 전송 값 저장
				String loginId = request.getParameter("loginId"); // 세션에서 보낸 아이디
				

				// 3. 비즈니스 로직
				MemberVo mv = new MemberService().loginIdInfo(loginId);
				
				// 4. 결과 페이지
				if(mv != null) { // 로그인 아이디의 정보를 잘 불러오면~ 실행
					
					ReservationVo rv = new ReservationVo();
					
					rv.setResRoomName(request.getParameter("res_room_name"));
					rv.setResId(mv.getMbId()); // 세션에서 보낸 아이디를 디비에서 잘 검색함!
					rv.setResPersonnel(Integer.parseInt(request.getParameter("res_personnel")));
					rv.setResInDate(Date.valueOf(request.getParameter("res_in_date"))); // date형 변환
					rv.setResOutDate(Date.valueOf(request.getParameter("res_out_date")));
					rv.setResPeriod(Integer.parseInt(request.getParameter("res_period")));
					rv.setResPrice(Integer.parseInt(request.getParameter("res_price")));
					
					
					RequestDispatcher view = request.getRequestDispatcher("/View/reservation/reservationStep3Page.jsp");
					request.setAttribute("reservationInfo", rv);
					request.setAttribute("memberInfo", mv);
					view.forward(request, response);
					
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
