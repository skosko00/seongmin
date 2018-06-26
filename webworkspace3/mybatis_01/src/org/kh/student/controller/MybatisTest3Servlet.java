package org.kh.student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.student.model.service.StudentServiceImpl;
import org.kh.student.model.vo.Student;

/**
 * Servlet implementation class MybatisTest3Servlet
 */
@WebServlet(name = "MybatisTest3", urlPatterns = { "/mybatisTest3" })
public class MybatisTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Student vo = new Student();
		vo.setStudentName(request.getParameter("studentName"));
		vo.setStudentTel(request.getParameter("studentTel"));
		vo.setStudentEmail(request.getParameter("studentEmail"));
		vo.setStudentAddr(request.getParameter("studentAddr"));
		int result = new StudentServiceImpl().insertStudent(vo);
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
