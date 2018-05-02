package kh.java.server.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServerSocket {
	Scanner sc = new Scanner(System.in);
	public TcpServerSocket()
	{
		ServerSocket serverSocket = null;	// 서버용 소켓
		Socket clientSocket = null;	// 클라이언트용 소켓
		int port = 7777;
		try {
			serverSocket = new ServerSocket(port);	// 서버 오픈
			System.out.println("Port listen Ok!!");
			clientSocket = serverSocket.accept();	// 클라이언트 접속
			OutputStream out = clientSocket.getOutputStream();	// 출력
			DataOutputStream dos = new DataOutputStream(out);	// 보조스트림
			InputStream In = clientSocket.getInputStream();		// 입력
			DataInputStream dis = new DataInputStream(In);

			System.out.println(clientSocket.getInetAddress() + " 클라이언트가 접속하였습니다.");

			dos.writeUTF("[Notice] SMLOVE 서버에 오신것을 환영 합니다.");
			// 해당 클라이언트한테 전달하는 메시지

			System.out.println("메시지 전송 완료");
			while(true)
			{
				System.out.print("나 : ");
				String s = sc.nextLine();
				dos.writeUTF(s);
				if(s.equals("exit"))
				{
					break;
				}
				String data = dis.readUTF();
				System.out.println("상대방 : "+data);
				if(data.equals("exit"))
				{
					break;
				}
				
			}
			dos.close();
			dis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();	// 클라이언트 소켓 종료
				serverSocket.close();	// 서버 소켓 종료
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
