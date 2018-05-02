package kh.java.com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Test1 extends Thread{

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
				System.out.println("¼­¹ö : "+message);
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

	public Test1()
	{
		Socket clientSocket = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);

		try {

			clientSocket = new Socket("192.168.0.100", 20000);


			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());

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





		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dis.close();
				dos.close();
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
