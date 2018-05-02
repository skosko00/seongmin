package kh.java.server.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerChet {
	public ServerChet()
	{
		Scanner sc = new Scanner(System.in);
		ServerSocket socket = null;
		Socket clientSocket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		try {
			// 1. �������� ����
			socket = new ServerSocket(11111);

			// 2. Ŭ���̾�Ʈ�� ���� ����
			clientSocket = socket.accept();

			// 3. ��/��� ��Ʈ������
			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());

			// 4. ������ �����
			System.out.println("====== ���� ======");
			do {
			System.out.print("���ֵ� ������ �Է� : ");
			String message = sc.nextLine();
			dos.writeUTF(message);
			if(message.equals("exit"))
			{
				System.out.println("������ �����մϴ�.");
				break;
			}
			
			message = dis.readUTF();
			
			if(message.equals("exit"))
			{
				System.out.println("������ ������ �����մϴ�.");
				break;
			}
			System.out.println("[Ŭ���̾�Ʈ] : "+message);
			
			}while(true);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				// 5. ��� ���� ���� �� ��Ʈ�� ����
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
// ���� ����

// 1. ���� ���� ����(���� ����)
// new ServerSocket(��Ʈ��ȣ);

// 2. Ŭ���̾�Ʈ�� ���� ����
// ��������.accept();

// 3. ��/��� ��Ʈ�� ����
// Ŭ���̾�Ʈ����.getInputStream();
// Ŭ���̾�Ʈ����.getOutputStream();

// 4. ������ �����
// �Է� : �Է½�Ʈ��.readUTF();
// ��� : ��½�Ʈ��.writeUTF();

// 5. ��ſ��� ���� �� ��Ʈ�� ����
// �Է½�Ʈ��.close()
// ��½�Ʈ��.close()
// Ŭ���̾�Ʈ������.close()
// ��������.close()