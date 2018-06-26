package jsp.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jsp.admin.model.vo.AnswerVo;
import jsp.admin.model.vo.QnAVo;
import jsp.member.model.service.MemberService;
import jsp.member.model.vo.QuestionVo;

@WebServlet(name = "MyQuestion", urlPatterns = { "/myQuestion" })
public class MyQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyQuestionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String loadNo = request.getParameter("loadNo");

		try {
			QuestionVo qv = new MemberService().myQuestion(loadNo);
			AnswerVo av = null;

			if (qv.getqAnswerCheck().equals("Y")) {
				av = new MemberService().myAnswer(String.valueOf(qv.getqNo()));
			}

			QnAVo qnAVo = new QnAVo();
			qnAVo.setQv(qv);
			qnAVo.setAsv(av);

			av.getaContents();

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(qnAVo, response.getWriter());
		} catch (Exception e) {
			QuestionVo qv = new MemberService().myQuestion(loadNo);
			AnswerVo av = new AnswerVo();

			av.setaContents("답변 대기 중 입니다");
			av.setaQNo(0);
			av.setaNo(0);

			QnAVo qnAVo = new QnAVo();
			qnAVo.setQv(qv);
			qnAVo.setAsv(av);

			av.getaContents();

			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			new Gson().toJson(qnAVo, response.getWriter());
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
