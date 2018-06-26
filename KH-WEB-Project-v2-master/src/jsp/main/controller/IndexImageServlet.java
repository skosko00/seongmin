package jsp.main.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jsp.main.model.service.MainService;
import jsp.main.model.vo.MainPicTb;

/**
 * Servlet implementation class IndexImageServlet
 */
@SuppressWarnings("all")
@WebServlet(name = "IndexImage", urlPatterns = { "/indexImage" })
public class IndexImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MainPicTb> list = new MainService().indexImage();
		JSONArray resultArray = new JSONArray();
		
			for(MainPicTb m : list) {
			JSONObject result = new JSONObject();
			result.put("mainPicPath", m.getMainPicPath());
			resultArray.add(result);
			}
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(resultArray);
			response.getWriter().close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
