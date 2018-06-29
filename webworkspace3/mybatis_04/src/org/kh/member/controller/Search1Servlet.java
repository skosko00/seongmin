package org.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.member.model.service.MemberServiceImpl;
import org.kh.member.model.vo.Member;
import org.kh.member.model.vo.SearchRadio;

/**
 * Servlet implementation class Search1Servlet
 */
@WebServlet(name = "Search1", urlPatterns = { "/search1" })
public class Search1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String searchRadio = request.getParameter("searchRadio");
		String searchKeyword = request.getParameter("searchKeyword");
		
		SearchRadio sr = new SearchRadio(searchRadio,searchKeyword);
		
		ArrayList<Member> list = new MemberServiceImpl().radioSearch(sr);
		
		response.setContentType("text/html; charset=utf-8");
		
		if(!list.isEmpty())
		{
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/member/allUser.jsp").forward(request, response);
		} else {
			response.getWriter().println("조회 실패");
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
