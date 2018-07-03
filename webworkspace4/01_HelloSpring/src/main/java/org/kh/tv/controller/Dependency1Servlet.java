package org.kh.tv.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kh.tv.model.vo.BeanFactory;
import org.kh.tv.model.vo.TV;
import org.kh.tv.model.vo.TVmgr;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Servlet implementation class Dependency1Servlet
 */
public class Dependency1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dependency1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//TV tv = (TV)BeanFactory.getBean(request.getParameter("beanName"));
		
		// xml 파일에 있는 Bean객체를 가져오기 위한 작업
		// 1. xml 파일을 읽어 들여야 함
		AbstractApplicationContext cntx = new GenericXmlApplicationContext("/sampleContext.xml");
		
		// TV tv = cntx.getBean("tvMgr",TVmgr.class).getTv();
		TV tv = ((TVmgr)cntx.getBean("tvMgr")).getTv();
		
		tv.powerOn(); //전원을 켬
		tv.volumeUp(); //소리를 올림
		tv.volumeDown(); //소리를 내림
		tv.powerOff(); //전원을 끔
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
