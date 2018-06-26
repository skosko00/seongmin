package jsp.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.admin.model.vo.MemberLoginLogVo;
import jsp.common.PensionExcelWriter;
import jsp.reservation.model.vo.ReservationVo;

/**
 * Servlet implementation class ReservationListDownServlet
 */
@WebServlet(name = "ReservationListDown", urlPatterns = { "/reservationListDown" })
public class ReservationListDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationListDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ArrayList<ReservationVo> list = new AdminService().reservationListDown();
		String path = getServletContext().getRealPath("/")+"reservationListDown.xlsx";
		boolean result = new PensionExcelWriter().reservationLogListWriter(list,path);
		System.out.println(request.getRequestURL().toString());
		if(result) {
			response.sendRedirect("/adminReserveManager");
			// 성공 메시지를 띄워야 한다.
		}else {
			response.sendRedirect("/View/error/errorPage.jsp");

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
