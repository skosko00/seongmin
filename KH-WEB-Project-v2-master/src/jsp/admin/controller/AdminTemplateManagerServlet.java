package jsp.admin.controller;

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
 * Servlet implementation class AdminTemplateManagerServlet
 */
@WebServlet(name = "AdminTemplateManager", urlPatterns = { "/adminTemplateManager" })
public class AdminTemplateManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTemplateManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MainPicTb> mpt = new MainService().indexImage();
		DescriptionTb dTb = new MainService().introduce();
		if(dTb!=null && !mpt.isEmpty())
		{
			RequestDispatcher view = request.getRequestDispatcher("/View/admin/template/templateManager.jsp");
			request.setAttribute("dTb", dTb);
			request.setAttribute("MainPicTb", mpt);
			view.forward(request, response);
		}else
		{
			response.sendRedirect("/View/error/error.jsp");
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
