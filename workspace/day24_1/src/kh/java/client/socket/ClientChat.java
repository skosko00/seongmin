package kh.java.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientChat extends Thread{

	DataInputStream dis = null;
	String message;
	@Override
	public void run()
	{
		try {
			while(true)
			{
				message = dis.readUTF();
				if(message.equals("exit"))
				{
					return;
				}
				System.out.println("[서버] : " + message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ClientChat()
	{
		Socket clientSocket = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);

		try {
			// 소켓 생성
			clientSocket = new Socket("192.168.10.27", 7777);

			// 스트림 생성
			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());

			System.out.println("클라이언트");

			this.start();

			while(true)
			{
				message = sc.nextLine();
				dos.writeUTF(message);
				if(message.equals("exit"))
				{
					break;
				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				dos.close();
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
