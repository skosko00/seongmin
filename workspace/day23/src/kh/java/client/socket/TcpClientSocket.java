package kh.java.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClientSocket {
	Scanner sc = new Scanner(System.in);
	public TcpClientSocket()
	{
		String serverIpAddress = "127.0.0.1";
		int serverPort = 7777;
		Socket clientScoket = null;
		
		try {
			clientScoket = new Socket(serverIpAddress,serverPort);
			// ������ ����
			System.out.println("�������� ������ �Ǿ����ϴ�.");
			
			InputStream in = clientScoket.getInputStream();	// �Է� ��Ʈ�� ����
			DataInputStream dis = new DataInputStream(in);	// ��� ���� ��Ʈ�� ����
			OutputStream out = clientScoket.getOutputStream();	// ��� ��Ʈ�� ����
			DataOutputStream dos = new DataOutputStream(out);	// ��� ���� ��Ʈ�� ����
			
			String data = dis.readUTF();
			System.out.println("�����κ��� ���۵� �޽��� : "+data);
			
			while(true)
			{
				data = dis.readUTF();				
				System.out.println("���� : " + data);
				if(data.equals("exit"))
				{
					break;
				}
				System.out.print("�� : ");
				String s = sc.nextLine();
				dos.writeUTF(s);
				if(s.equals("exit"))
				{
					break;
				}
				
			}
			
			dis.close();			
			dos.close();
			
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
