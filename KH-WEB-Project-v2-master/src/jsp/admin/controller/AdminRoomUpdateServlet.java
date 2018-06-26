package jsp.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.admin.model.service.AdminService;
import jsp.reservation.model.vo.PensionVo;

/**
 * Servlet implementation class AdminRoomUpdateServlet
 */
@WebServlet(name = "AdminRoomUpdate", urlPatterns = { "/adminRoomUpdate" })
public class AdminRoomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminRoomUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		
		PensionVo pv = new PensionVo(
				request.getParameter("PS_Name"), 
				Integer.parseInt(request.getParameter("PS_Person")), 
				Integer.parseInt(request.getParameter("PS_MaxPerson")), 
				request.getParameter("PS_Contents"), 
				Integer.parseInt(request.getParameter("PS_Weekend")), 
				Integer.parseInt(request.getParameter("PS_Weekday")), 
				Integer.parseInt(request.getParameter("PS_Addition_Price"))
				);
		
		boolean result = new AdminService().updateRoomText(pv);
		
		if(result) {
			//String psName = request.getParameter("psName");
			response.sendRedirect("/adminRoomDetail?psName="+pv.getPsName());
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
