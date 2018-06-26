package jsp.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jsp.reservation.model.service.ReservationService;
import jsp.reservation.model.vo.ReservationVo;

/**
 * Servlet implementation class ReservationCheckListServlet
 */
@WebServlet(name = "ReservationCheckList", urlPatterns = { "/reservationCheckList" })
public class ReservationCheckListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationCheckListServlet() {
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
		String loginId = request.getParameter("loginId");
		//System.out.println(loginId);
		
		// 3. 비즈니스 로직
		ArrayList<ReservationVo> rvList = new ReservationService().loginIdReservationList(loginId);	

		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(rvList, response.getWriter());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
