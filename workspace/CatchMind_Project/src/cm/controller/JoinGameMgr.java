package cm.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import cm.view.ClientGameView;
import cm.view.ServerGameView;
import cm.vo.Member;

//----- 준 상 성 민 ----- //
public class JoinGameMgr extends Thread
{
	private String insertData =null;
	private String printMessage=null;

	Member m = new Member();
	
	
	ClientGameView cgv = null;
	Socket socket = null;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	public JoinGameMgr() {}

	public JoinGameMgr(ClientGameView cgv)
	{
		System.out.println("생성완료. " + cgv.getClient());
		this.cgv = cgv;
	}
	
	@Override
	public void run()
	{
		try {
			while(true)
			{
				if(printMessage!=null)
				{
					System.out.println("님");
					printMessage = dis.readUTF();
					System.out.println("클라 받기." + cgv.getClient());
						cgv.chatMessage(printMessage);
				}
			}
		} catch (IOException e) {
			System.out.println("왜 연결 안됌?");
			e.printStackTrace();

		} finally {
			try {
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 채팅 전송 버튼 누를시 값 저장

	public void chatMessage(String message)
	{
		insertData = message;
	}

	//	채팅 서버 연결

	public void joinGame(String ipNumber, int portNumber) 
	{
		try {
			System.out.println("아이피 " + ipNumber +" 포트 " + portNumber );
			socket = new Socket(ipNumber,portNumber);	// 서버 연결
			System.out.println("서버 접속 성공");
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			this.start();
			while(true)
			{
				if(insertData==null)
				{
					
				}
				else
				{
					System.out.println("연결");
					dos.writeUTF(insertData);	
					insertData = null;
				}
				
									
			}
		} catch (UnknownHostException e) {
			System.out.println("unno");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("연결안a");
			e.printStackTrace();
		} finally {
			try {
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
