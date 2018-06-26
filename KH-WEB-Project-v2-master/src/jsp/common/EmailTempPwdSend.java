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

public class EmailTempPwdSend {

	private Properties prop = new Properties();

	public void sendMail(String id, String email, String tempPwd) {

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
			String path = EmailTempPwdSend.class.getResource("").getPath();
			prop.load(new FileReader(path + "email.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(prop.getProperty("id"), prop.getProperty("password"));
			}
		});
		// System.out.println("??");
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kh.message.smtp@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("[The pension] '" + id + "' 회원님의 임시 비밀번호 입니다");
			message.setText("\n" + id + "회원님의 임시 비밀번호 입니다\n\n임시 비밀번호 : [" + tempPwd
					+ "]\n\n※ 해당 비밀번호는 임시 비밀번호 입니다.\n 로그인 후 비밀번호를 반드시 변경바랍니다.\n\n※ 본 메일은 발신전용 메일입니다.\n기타 문의사항은 고객센터를 이용해주시기 바랍니다");
			// System.out.println("전송 시작");
			Transport.send(message);
			System.out.println("이메일이 성공적으로 보내졌습니다");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
