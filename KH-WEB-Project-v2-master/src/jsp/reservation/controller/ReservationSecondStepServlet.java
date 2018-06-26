package jsp.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.reservation.model.service.ReservationService;
import jsp.reservation.model.vo.PensionVo;
import jsp.reservation.model.vo.ReservationVo;

/**
 * Servlet implementation class ReservationDetailInfoServlet
 */
@WebServlet(name = "ReservationDetailInfo", urlPatterns = { "/reservationSecondStep" })
public class ReservationSecondStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationSecondStepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 해야할 것
		// 1. 넘어온 room_code에 해당하는 방 정보(기준인원 등) 가져오기
		// 2. 넘어온 room_code에 해당하는 가격정보 가져오기
		
		// 1. 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2. 전송값 저장
		String resRoomName = request.getParameter("roomName");
		
		// 3. 비즈니스 로직
		PensionVo pv = new ReservationService().pensionInfo(resRoomName);
		ArrayList<ReservationVo> list = new ReservationService().reservationDateList();
		
		
		// 4. 결과값 페이지 전송
		
		if(pv!=null) {
			
			RequestDispatcher view = request.getRequestDispatcher("/View/reservation/reservationStep2Page.jsp");
			request.setAttribute("pensionInfo", pv);
			request.setAttribute("reservationDateList", list);
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
