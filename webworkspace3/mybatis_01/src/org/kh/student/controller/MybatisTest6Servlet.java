package org.kh.student.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.student.model.service.StudentServiceImpl;
import org.kh.student.model.vo.Student;

/**
 * Servlet implementation class MybatisTest6Servlet
 */
@WebServlet(name = "MybatisTest6", urlPatterns = { "/mybatisTest6" })
public class MybatisTest6Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MybatisTest6Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 값 가져오기
		int studentNo = Integer.parseInt(request.getParameter("studentNo"));
		
		// 3. 비즈니스 로직
		Student std = new StudentServiceImpl().selectOneStudent(studentNo);
		
		// 4. 결과값 리턴
		response.setContentType("text/html; charset=utf-8");
		if(std!=null){
			RequestDispatcher view = request.getRequestDispatcher("/views/student/studentInfo.jsp");
			request.setAttribute("student", std);
			view.forward(request, response);
		}else {
			response.getWriter().println("검색하지 못하였습니다.");
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
