package org.kh.student.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.student.model.service.StudentServiceImpl;

/**
 * Servlet implementation class MybatisTest5Servlet
 */
@WebServlet(name = "MybatisTest5", urlPatterns = { "/mybatisTest5" })
public class MybatisTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		int result = new StudentServiceImpl().deleteStudent(studentNo);
		response.setContentType("text/html; charset=utf-8");
		if(result>0) {
			response.getWriter().println("정상 처리 되었습니다.");
		}else {
			response.getWriter().println("실패 되었습니다.");
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
