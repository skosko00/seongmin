package jsp.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.main.model.service.MainService;
import jsp.main.model.vo.PensionPicTb;
import jsp.reservation.model.service.ReservationService;
import jsp.reservation.model.vo.PensionVo;

/**
 * Servlet implementation class RoomInfoServlet
 */
@WebServlet(name = "RoomInfo", urlPatterns = { "/roomInfo" })
public class RoomInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String roomName = request.getParameter("roomName");
		// 방 사진 갖고 오는 로직
		ArrayList<PensionPicTb> roomNameImage = new MainService().roomInfo(roomName);
		// 방 정보를 갖고 오는 로직
		PensionVo pv = new ReservationService().pensionInfo(roomName);
		// 방 메인 사진 정보를 가지고 오는 로직
		ArrayList<PensionPicTb> ppt = new MainService().room();

		RequestDispatcher view = request.getRequestDispatcher("/View/main/roomInfo.jsp");
		request.setAttribute("roomNameImage", roomNameImage);
		request.setAttribute("pv", pv);
		request.setAttribute("PensionPicTb", ppt);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
