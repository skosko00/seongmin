package kh.java.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClientSocket1 {
	public TcpClientSocket1()
	{

		Scanner sc = new Scanner(System.in);

		String serverIpAddress = "127.0.0.1";
		int serverPort = 10000;
		Socket clientScoket = null;

		try {
			clientScoket = new Socket(serverIpAddress, serverPort);
			System.out.println("서버와 연결되었습니다.");

			InputStream in = clientScoket.getInputStream();	// 입력 스트림 생성
			DataInputStream dis = new DataInputStream(in);	// 입력 보조 스트림 생성
			OutputStream out = clientScoket.getOutputStream();	// 출력 스트림 생성
			DataOutputStream dos = new DataOutputStream(out);	// 출력 보조 스트림 생성

			dos.writeUTF(sc.nextLine());
			
			String data = dis.readUTF();
			System.out.println("서버로부터 전송된 메시지 : "+ data);
			data = dis.readUTF();
			System.out.println("서버로부터 전송된 메시지 : "+ data);
			
			
			dos.close();
			dis.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				clientScoket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
