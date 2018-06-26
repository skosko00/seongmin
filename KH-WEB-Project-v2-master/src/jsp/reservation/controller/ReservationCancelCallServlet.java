package jsp.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.reservation.model.service.ReservationService;

/**
 * Servlet implementation class ReservationCancelCallServlet
 */
@WebServlet(name = "ReservationCancelCall", urlPatterns = { "/reservationCancelCall" })
public class ReservationCancelCallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCancelCallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 문자 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 전송값 저장
		int resNo = Integer.parseInt(request.getParameter("res_no"));
		// System.out.println(resNo);
		
		// 3. 비즈니스 로직
		int copyResult = new ReservationService().copyReservationList(resNo); // 데이터 복사
		
		if(copyResult>0) {
			
			int deleteResult = new ReservationService().deleteReservationList(resNo); // 예약 테이블에서 정보 삭제
			if(deleteResult>0) {
				System.out.println("예약 취소 신청 성공");
			} 
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
