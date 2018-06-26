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
import jsp.main.model.vo.MainPicTb;

/**
 * Servlet implementation class IntroduceServlet
 */
@WebServlet(name = "PsIntroduce", urlPatterns = { "/psIntroduce" })
public class PsIntroduceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PsIntroduceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 위에 사진과 코멘트 불러오는 비즈니스 로직
		DescriptionTb dTb = new MainService().introduce();
		// 아래 사진 불러오는 비즈니스 로직
		ArrayList<MainPicTb> list = new MainService().indexImage();

		RequestDispatcher view = request.getRequestDispatcher("/View/main/psIntroduce.jsp");
		request.setAttribute("dTb", dTb);
		request.setAttribute("MainPicTb", list);
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
