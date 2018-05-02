package kh.java.server.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChat extends Thread{
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
				System.out.println("[Ŭ���̾�Ʈ] : " + message);
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
	public ServerChat()
	{
		Scanner sc = new Scanner(System.in);
		ServerSocket socket = null;
		Socket clientSocket = null;
		
		DataOutputStream dos = null;
		try {
			// ���� ����
			socket = new ServerSocket(7777);
			clientSocket = socket.accept();
			// ��Ʈ������
			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());
			
			System.out.println("���� ȭ��");
			
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
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
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
