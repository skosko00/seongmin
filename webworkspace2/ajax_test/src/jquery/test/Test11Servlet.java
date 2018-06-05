package jquery.test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test11Servlet
 */
@WebServlet(name = "Test11", urlPatterns = { "/test11" })
public class Test11Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test11Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<User> list = new ArrayList<User>();
		list.add(new User("홍길동",20,"경기도"));
		list.add(new User("김말똥",30,"서울시"));
		list.add(new User("고길똥",40,"전라도"));
		list.add(new User("김지똥",50,"경상도"));
		list.add(new User("박혜똥",60,"강원도"));
		list.add(new User("류훈똥",70,"충청도"));
		list.add(new User("한알름",80,"제주도"));
		list.add(new User("김례진",90,"독도"));
		list.add(new User("곽령훈",10,"울릉도"));
		list.add(new User("김쥐섭",25,"평양"));
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		new Gson().toJson(list,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
