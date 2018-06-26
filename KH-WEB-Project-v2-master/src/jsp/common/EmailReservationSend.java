package jsp.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailReservationSend {

	private Properties prop = new Properties();

	public void sendMail(String email, String name, String amount, String roomName, String inDate, String outDate) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "true");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		try {
			String path = EmailReservationSend.class.getResource("").getPath();
			prop.load(new FileReader(path + "email.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.getProperty("id"), prop.getProperty("password"));
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kh.message.smtp@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("[The pension] " + name + "님 펜션 예약 정보입니다");
			message.setText("\n더 펜션 예약 해주셔서 감사합니다:D\n\n "
					+"─────────────────────────────────────────────────\n"
					+ "예약한 방 : " + roomName
					+ "\n결제 금액 : " + amount + "원"
					+ "\n펜션 이용 기간 : " + inDate + " ~ " + outDate
					+ "\n─────────────────────────────────────────────────"
					+ "\n본 예약에 대한 취소 및 상세 정보는 더 펜션 마이페이지에서 확인 부탁드립니다"
					+ "\n\n※ 본 메일은 발신전용 메일입니다.\n기타 문의사항은 고객센터를 이용해주시기 바랍니다");
			Transport.send(message);
			System.out.println("이메일이 성공적으로 보내졌습니다");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
