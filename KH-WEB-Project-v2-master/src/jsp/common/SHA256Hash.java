package jsp.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Hash {

	public SHA256Hash() {
	}

	public String enctyptSHA256(String pwd) {

		String encryptPwd = null;

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pwd.getBytes());

			byte byteData[] = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}

			encryptPwd = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encryptPwd;
	}
}
