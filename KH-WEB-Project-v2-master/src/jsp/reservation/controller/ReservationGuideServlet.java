package jsp.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.main.model.service.MainService;
import jsp.main.model.vo.DescriptionTb;
import jsp.main.model.vo.PensionPicTb;
import jsp.reservation.model.service.ReservationService;
import jsp.reservation.model.vo.PensionVo;

/**
 * Servlet implementation class ReservationGuideServlet
 */
@WebServlet(name = "ReservationGuide", urlPatterns = { "/reservationGuide" })
public class ReservationGuideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationGuideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 문자 인코딩
		// 2. 전송값 저장
		// 3. 비즈니스 로직
		ArrayList<PensionVo> pvList = new ReservationService().pensionList(); // 방 전체 정보 가지고 옴
		DescriptionTb desList = new MainService().introduce(); // 주의사항 환불안내 계좌안내 내용 넣을껀데 지금은 내용이 없어서...ㅜㅡㅠ 일단 보류
		ArrayList<PensionPicTb> picList = new MainService().room(); // 펜션 방 사진 가져오기
		
		
		if(pvList != null) {
			RequestDispatcher view = request.getRequestDispatcher("/View/reservation/reservationGuide.jsp");
			request.setAttribute("pensionInfoList", pvList);
			request.setAttribute("descriptionInfo", desList);
			request.setAttribute("pensionRoomPic", picList);
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
