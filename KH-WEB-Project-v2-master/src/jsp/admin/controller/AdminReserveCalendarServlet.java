package jsp.admin.controller;

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
 * Servlet implementation class AdminReserveCalendarServlet
 */
@WebServlet(name = "AdminReserveCalendar", urlPatterns = { "/adminReserveCalendar" })
public class AdminReserveCalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReserveCalendarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 코드를 그대로 가져왔다
		ArrayList<ReservationVo> rvList = new ReservationService().reservationDateList();
		ArrayList<PensionVo> pvList = new ReservationService().pensionList();
		
		if(pvList != null) {
			RequestDispatcher view = request.getRequestDispatcher("/View/admin/reserve/reservationCalendar.jsp");
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
