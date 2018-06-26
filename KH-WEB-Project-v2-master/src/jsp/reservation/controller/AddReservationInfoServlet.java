package jsp.reservation.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.reservation.model.service.ReservationService;
import jsp.reservation.model.vo.ReservationVo;

/**
 * Servlet implementation class AddReservationInfoServlet
 */
@WebServlet(name = "AddReservationInfo", urlPatterns = { "/addReservationInfo" })
public class AddReservationInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReservationInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 전송값 저장
		ReservationVo rv = new ReservationVo();
		
		rv.setResRoomName(request.getParameter("res_room_name"));
		rv.setResId(request.getParameter("res_id")); // 나중에 세션값으로 저장
		rv.setResPersonnel(Integer.parseInt(request.getParameter("res_personnel")));
		rv.setResInDate(Date.valueOf(request.getParameter("res_in_date"))); // date형 변환
		rv.setResOutDate(Date.valueOf(request.getParameter("res_out_date")));
		rv.setResPeriod(Integer.parseInt(request.getParameter("res_period")));
		rv.setResPrice(Integer.parseInt(request.getParameter("res_price")));
		
		// 3. 비즈니스 로직
		int result = new ReservationService().addReservation(rv); // 예약 추가

		// 4. 결과값 처리
		if(result>0) {
			response.sendRedirect("/View/reservation/reservationStep4Page.jsp");
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
