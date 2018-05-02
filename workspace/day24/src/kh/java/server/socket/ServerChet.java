package kh.java.server.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChet {
	public ServerChet()
	{
		Scanner sc = new Scanner(System.in);
		ServerSocket socket = null;
		Socket clientSocket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			// 1. 서버소켓 생성
			socket = new ServerSocket(11111);

			// 2. 클라이언트별 연결 소켓
			clientSocket = socket.accept();

			// 3. 입/출력 스트림생성
			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());

			// 4. 데이터 입출력
			System.out.println("====== 서버 ======");
			do {
			System.out.print("전솔될 데이터 입력 : ");
			String message = sc.nextLine();
			dos.writeUTF(message);
			if(message.equals("exit"))
			{
				System.out.println("연결을 종료합니다.");
				break;
			}
			
			message = dis.readUTF();
			
			if(message.equals("exit"))
			{
				System.out.println("상대방이 연결을 종료합니다.");
				break;
			}
			System.out.println("[클라이언트] : "+message);
			
			}while(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				// 5. 통신 연결 종료 및 스트림 종료
				dis.close();
				dos.close();
				clientSocket.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
// 서버 소켓

// 1. 서버 소켓 생성(서버 오픈)
// new ServerSocket(포트번호);

// 2. 클라이언트별 연결 소켓
// 서버소켓.accept();

// 3. 입/출력 스트림 생성
// 클라이언트소켓.getInputStream();
// 클라이언트소켓.getOutputStream();

// 4. 데이터 입출력
// 입력 : 입력스트림.readUTF();
// 출력 : 출력스트림.writeUTF();

// 5. 통신연결 종료 및 스트림 해제
// 입력스트림.close()
// 출력스트림.close()
// 클라이언트별소켓.close()
// 서버소켓.close()