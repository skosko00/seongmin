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
import jsp.main.model.vo.DescriptionTb;
import jsp.main.model.vo.PensionPicTb;

/**
 * Servlet implementation class RoomServlet
 */
@WebServlet(name = "RoomIntroduce", urlPatterns = { "/roomIntroduce" })
public class RoomIntroduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomIntroduceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DescriptionTb dTb = new MainService().introduce();
		// 방 메인 사진 정보를 가지고 오는 로직
		ArrayList<PensionPicTb> ppt = new MainService().room();

		RequestDispatcher view = request.getRequestDispatcher("/View/main/roomIntroduce.jsp");
		request.setAttribute("dTb", dTb);
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
