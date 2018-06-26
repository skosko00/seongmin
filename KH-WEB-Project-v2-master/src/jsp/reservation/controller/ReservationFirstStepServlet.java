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
 * Servlet implementation class ReservationFirstStepServlet
 */
@WebServlet(name = "ReservationFirstStep", urlPatterns = { "/reservationFirstStep" })
public class ReservationFirstStepServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationFirstStepServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// step1. 예약 전 예약 조회하는 기능( 모든 예약 정보와 방 정보 캘린더에 조회하기 )
		ArrayList<ReservationVo> rvList = new ReservationService().reservationDateList();
		ArrayList<PensionVo> pvList = new ReservationService().pensionList();
		
		if(pvList != null) {
			RequestDispatcher view = request.getRequestDispatcher("/View/reservation/reservationStep1Page.jsp");
			request.setAttribute("reservationList", rvList);
			request.setAttribute("pensionList", pvList);
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
