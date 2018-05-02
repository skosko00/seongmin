package cm.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import cm.view.ServerGameView;

//----- 준 상  성민 ----- //
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
					System.out.println("연결");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("흑흑 CreateGameMgr");
			e.printStackTrace();
		}finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("왜 그러니?ㅠㅠ");
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
			System.out.println("CreateGame 소켓 " + portNumber);
			socket = new ServerSocket(portNumber);
			clientSocket = socket.accept();
			System.out.println(clientSocket.getInetAddress()+ "님 접속 성공");
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
					System.out.println("연결!");
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
			System.out.println("누구임?");
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
