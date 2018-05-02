package cm.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import cm.view.ServerGameView;

//----- �� ��  ���� ----- //
public class CreateGameMgr extends Thread{

	private String sendMessage=null;
	private String getMessage;
	DataInputStream dis = null;
	ServerGameView sgv = null;
	public CreateGameMgr(ServerGameView sgv)
	{
		this.sgv = sgv;
	}
	@Override
	public void run()
	{
		try {
			while(true)
			{
				if(getMessage!=null) 
				{
					getMessage = dis.readUTF();
					sgv.getMessage(getMessage);
					System.out.println("����");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("���� CreateGameMgr");
			e.printStackTrace();
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("�� �׷���?�Ф�");
				e.printStackTrace();
			}
		}
	}

	public CreateGameMgr()	{	}

	public void createGame(int portNumber) {
		
		ServerSocket socket = null;
		Socket clientSocket = null;		
		DataOutputStream dos = null;
		try {
			System.out.println("CreateGame ���� " + portNumber);
			socket = new ServerSocket(portNumber);
			clientSocket = socket.accept();
			System.out.println(clientSocket.getInetAddress()+ "�� ���� ����");
			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());

			this.start();

			while(true)
			{
//				Scanner sc = new Scanner(System.in);
				sendMessage = "asedfasdf";
				System.out.println(sendMessage);
				if(sendMessage==null)
				{
					
				}
				else
				{
					System.out.println("����!");
					dos.writeUTF(sendMessage);
					sendMessage=null;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("������?");
			e.printStackTrace();
		}finally {
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


	public void createGameMgr(String sendMessage)
	{
		
		this.sendMessage = sendMessage;
		
	}
}
