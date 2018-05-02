package kh.java.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpClientSocket1 {
	public TcpClientSocket1()
	{

		Scanner sc = new Scanner(System.in);

		String serverIpAddress = "127.0.0.1";
		int serverPort = 10000;
		Socket clientScoket = null;

		try {
			clientScoket = new Socket(serverIpAddress, serverPort);
			System.out.println("������ ����Ǿ����ϴ�.");

			InputStream in = clientScoket.getInputStream();	// �Է� ��Ʈ�� ����
			DataInputStream dis = new DataInputStream(in);	// �Է� ���� ��Ʈ�� ����
			OutputStream out = clientScoket.getOutputStream();	// ��� ��Ʈ�� ����
			DataOutputStream dos = new DataOutputStream(out);	// ��� ���� ��Ʈ�� ����

			dos.writeUTF(sc.nextLine());
			
			String data = dis.readUTF();
			System.out.println("�����κ��� ���۵� �޽��� : "+ data);
			data = dis.readUTF();
			System.out.println("�����κ��� ���۵� �޽��� : "+ data);
			
			
			dos.close();
			dis.close();
			
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
