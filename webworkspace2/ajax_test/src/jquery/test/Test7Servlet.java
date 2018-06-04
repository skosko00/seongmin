package jquery.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jquery.test.vo.User;

/**
 * Servlet implementation class Test7Servlet
 */
@WebServlet(name = "Test7", urlPatterns = { "/test7" })
public class Test7Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test7Servlet() {
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
		
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 2. 값 저장
		String userIndexs = request.getParameter("userIndexs");
		StringTokenizer sT = new StringTokenizer(userIndexs, ",");
		
		// 토큰 확인 코드
//		while(sT.hasMoreTokens()) {
//			System.out.println(sT.nextToken());
//		}
		
		// 인덱스 번호를 저장
		ArrayList<Integer> userSelect = new ArrayList<Integer>();
		
		while(sT.hasMoreTokens())
		{
			userSelect.add(Integer.parseInt(sT.nextToken())-1);
		}
		
		
		// 여러명 일 수 있으므로 JSONArray를 사용
		JSONArray resultArray = new JSONArray();
		
		int index = 0;
		
		// 만약에 사용자가 1,5,8를 입력 했다면 (-1씩 해서 저장 하였음)
		// userSelect Array에는 [0] : 0, [1] : 4, [2] : 7
		while(index<userSelect.size())
		{
			User user = list.get(userSelect.get(index));
			JSONObject result = new JSONObject();
			
			result.put("name", user.getName());
			result.put("age", user.getAge());
			result.put("addr", user.getAddr());
			
			resultArray.add(result);
			index++;
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
