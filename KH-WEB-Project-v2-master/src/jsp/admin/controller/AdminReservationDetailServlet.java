package jsp.admin.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.reservation.model.vo.ReservationVo;

/**
 * Servlet implementation class AdminReservationDetailServlet
 */
@WebServlet(name = "AdminReservationDetail", urlPatterns = { "/adminReservationDetail" })
public class AdminReservationDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReservationDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 일단은 예약이 제대로 되었는지 확인이 필요하다. -> 기간만료가 필요한가?
		// 일단은 그대로...
		request.setCharacterEncoding("utf-8");
		
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("day"))+1;	// 1씩 차이가 난다.
		
		String roomName = request.getParameter("roomName");
		
		String from = year+"-"+month+"-"+day;

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		Date comDate;
		try {
			comDate = (Date)transFormat.parse(from);
			java.sql.Date sqlDate = new java.sql.Date(comDate.getTime());
			
			
			ReservationVo rv = new AdminService().selectOneReservation(roomName, sqlDate);
			
			if(rv != null) {
				RequestDispatcher view  = request.getRequestDispatcher("/View/admin/reserve/reservationDetail.jsp");
				request.setAttribute("reservationInfo", rv);
				view.forward(request, response);
			}else {
				// 경고 한번 띄우고  달력으로 
				response.sendRedirect("/adminReserveCalendar");
			}
			//ReservationVo rv = new AdminService();
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
