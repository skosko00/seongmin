package cm.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import cm.view.ClientGameView;
import cm.view.ServerGameView;
import cm.vo.Member;

//----- �� �� �� �� ----- //
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
		System.out.println("�����Ϸ�. " + cgv.getClient());
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
					System.out.println("��");
					printMessage = dis.readUTF();
					System.out.println("Ŭ�� �ޱ�." + cgv.getClient());
						cgv.chatMessage(printMessage);
				}
			}
		} catch (IOException e) {
			System.out.println("�� ���� �ȉ�?");
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

	// ä�� ���� ��ư ������ �� ����

	public void chatMessage(String message)
	{
		insertData = message;
	}

	//	ä�� ���� ����

	public void joinGame(String ipNumber, int portNumber) 
	{
		try {
			System.out.println("������ " + ipNumber +" ��Ʈ " + portNumber );
			socket = new Socket(ipNumber,portNumber);	// ���� ����
			System.out.println("���� ���� ����");
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
					System.out.println("����");
					dos.writeUTF(insertData);	
					insertData = null;
				}
				
									
			}
		} catch (UnknownHostException e) {
			System.out.println("unno");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("�����a");
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
