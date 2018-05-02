package kh.java.client.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientChet {
	public ClientChet()
	{
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		try {
			// 1. �������� ���� ����
			socket = new Socket("127.0.0.1",11111);

			// 2. ����� ��Ʈ�� ����
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());

			// 3. ������ �����
			System.out.println("====== Ŭ���̾�Ʈ ======");
			do
			{
				String message = dis.readUTF();
				if(message.equals("eixt"))
				{
					System.out.println("������ ������ �����մϴ�.");
					break;
				}
				System.out.println("[����] : "+message);
				System.out.print("���ֵ� ������ �Է� : ");
				message = sc.nextLine();				
				dos.writeUTF(message);
				if(message.equals("eixt"))
				{
					System.out.println("������ �����մϴ�.");
					break;
				}

			}while(true);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 4. ��� ���� ���� �� ��Ʈ�� ����
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
// Ŭ���̾�Ʈ ����

// 1. �������� ���� ����
// new Socket(����IP,��Ʈ��ȣ);

// 2. ��/��� ��Ʈ�� ����
//Ŭ���̾�Ʈ����.getInputStream();
//Ŭ���̾�Ʈ����.getOutputStream();

// 3. ������ �����
//�Է� : �Է½�Ʈ��.readUTF();
//��� : ��½�Ʈ��.writeUTF();

// 4. ��ſ��� ���� �� ��Ʈ�� ����
// �Է½�Ʈ��.close()
// ��½�Ʈ��.close()
// �������� ���� ����.close()