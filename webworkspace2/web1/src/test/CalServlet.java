package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalServlet
 */
@WebServlet(name = "Cal", urlPatterns = { "/cal" })
public class CalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("utf-8");
		int firstValue = Integer.parseInt(request.getParameter("firstValue"));
		int secondValue = Integer.parseInt(request.getParameter("secondValue"));
		String select = request.getParameter("cal");

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>");
		out.println("결과출력");
		out.println("</title></head><body>");
		switch(select)
		{
		case "+":
			out.println(firstValue + " + " + secondValue + " = " + (firstValue+secondValue));
			break;
		case "-":
			out.println(firstValue + " - " + secondValue + " = " + (firstValue-secondValue));
			break;
		case "*":
			out.println(firstValue + " * " + secondValue + " = " + (firstValue*secondValue));
			break;
		case "/":
			out.println(firstValue + " / " + secondValue + " = " + (firstValue/(double)secondValue));
			break;
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
