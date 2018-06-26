package jsp.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EmailReservationSend", urlPatterns = { "/emailReservationSend" })
public class EmailReservationSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmailReservationSendServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String roomName = request.getParameter("roomName");
		String amount = request.getParameter("amount");
		String inDate = request.getParameter("inDate");
		String outDate = request.getParameter("outDate");

		new EmailReservationSend().sendMail(email, name, amount, roomName, inDate, outDate);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
