package org.kh.member.common;

import java.security.MessageDigest;

public class SHA256Util {
	public static String encryptData(String data) throws Exception{
		
		// MessageDigest 객체를 사용해서 SHA-256으로 암호화 할 수 있도록 객체 생성
		MessageDigest mDigest= MessageDigest.getInstance("SHA-256");
		
		// 암호화에 사용할 데이터를 바이트 배열로 바꾸어서 MessageDigest객체에 넣어줌
		// update 메소드의 매개변수가 byte 배열을 필요로 함
		mDigest.update(data.getBytes());
		
		// 해당 값들을 SHA-256으로 암호화한 값들을 Byte로 꺼냄
		byte [] msgStr = mDigest.digest();
		
		StringBuffer sbuf = new StringBuffer();
		
		// 꺼낸 값들을 16진수로 바꾸어 주기 위한 알고리즘
		for(int i=0; i<msgStr.length; i++) {
			byte tmpStrByte = msgStr[i];
			String tmpEnctext = Integer.toString((tmpStrByte & 0xff) + 0x100,16).substring(1);
			sbuf.append(tmpEnctext);
		}
		
		return sbuf.toString();
	}
}
