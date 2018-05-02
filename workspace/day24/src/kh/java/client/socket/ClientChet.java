package kh.java.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientChet {
	public ClientChet()
	{
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		try {
			// 1. 서버와의 연결 소켓
			socket = new Socket("127.0.0.1",11111);

			// 2. 입출력 스트림 생성
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			// 3. 데이터 입출력
			System.out.println("====== 클라이언트 ======");
			do
			{
				String message = dis.readUTF();
				if(message.equals("eixt"))
				{
					System.out.println("상대방이 연결을 종료합니다.");
					break;
				}
				System.out.println("[서버] : "+message);
				System.out.print("전솔될 데이터 입력 : ");
				message = sc.nextLine();				
				dos.writeUTF(message);
				if(message.equals("eixt"))
				{
					System.out.println("연결을 종료합니다.");
					break;
				}

			}while(true);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 4. 통신 연결 종료 및 스트림 종료
				dis.close();
				dos.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
// 클라이언트 소켓

// 1. 서버와의 연결 소켓
// new Socket(서버IP,포트번호);

// 2. 입/출력 스트림 생성
//클라이언트소켓.getInputStream();
//클라이언트소켓.getOutputStream();

// 3. 데이터 입출력
//입력 : 입력스트림.readUTF();
//출력 : 출력스트림.writeUTF();

// 4. 통신연결 종료 및 스트림 해제
// 입력스트림.close()
// 출력스트림.close()
// 서버와의 연결 소켓.close()