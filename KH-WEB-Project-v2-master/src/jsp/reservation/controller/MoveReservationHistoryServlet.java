package jsp.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.reservation.model.service.ReservationService;

/**
 * Servlet implementation class MoveReservationHistoryServlet
 */
@WebServlet(name = "MoveReservationHistory", urlPatterns = { "/moveReservationHistory" })
public class MoveReservationHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveReservationHistoryServlet() {
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
		String today = request.getParameter("today");
		
		// 3. 비즈니스 로직
		int moveResult = new ReservationService().moveReservationHistory(today);
		if(moveResult>0) {
			System.out.println("이동성공");
			int deleteResult = new ReservationService().deleteReservationHistory(today);
			if(deleteResult>0) {
				System.out.println("삭제성공");
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
