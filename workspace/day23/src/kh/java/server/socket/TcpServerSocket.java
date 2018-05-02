package kh.java.server.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpServerSocket {
	Scanner sc = new Scanner(System.in);
	public TcpServerSocket()
	{
		ServerSocket serverSocket = null;	// ������ ����
		Socket clientSocket = null;	// Ŭ���̾�Ʈ�� ����
		int port = 7777;
		try {
			serverSocket = new ServerSocket(port);	// ���� ����
			System.out.println("Port listen Ok!!");
			clientSocket = serverSocket.accept();	// Ŭ���̾�Ʈ ����
			OutputStream out = clientSocket.getOutputStream();	// ���
			DataOutputStream dos = new DataOutputStream(out);	// ������Ʈ��
			InputStream In = clientSocket.getInputStream();		// �Է�
			DataInputStream dis = new DataInputStream(In);

			System.out.println(clientSocket.getInetAddress() + " Ŭ���̾�Ʈ�� �����Ͽ����ϴ�.");

			dos.writeUTF("[Notice] SMLOVE ������ ���Ű��� ȯ�� �մϴ�.");
			// �ش� Ŭ���̾�Ʈ���� �����ϴ� �޽���

			System.out.println("�޽��� ���� �Ϸ�");
			while(true)
			{
				System.out.print("�� : ");
				String s = sc.nextLine();
				dos.writeUTF(s);
				if(s.equals("exit"))
				{
					break;
				}
				String data = dis.readUTF();
				System.out.println("���� : "+data);
				if(data.equals("exit"))
				{
					break;
				}
				
			}
			dos.close();
			dis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();	// Ŭ���̾�Ʈ ���� ����
				serverSocket.close();	// ���� ���� ����
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
