package kh.java.com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;

public class Test2 {
	public Test2()
	{
		Calendar today = Calendar.getInstance();
		ServerSocket socket = null;
		Socket clientSocket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner sc = new Scanner(System.in);
		int hour = today.get(Calendar.HOUR);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		
		try {
			socket = new ServerSocket(10000);

			clientSocket = socket.accept();

			dis = new DataInputStream(clientSocket.getInputStream());
			dos = new DataOutputStream(clientSocket.getOutputStream());

			String time = dis.readUTF();
			if(time.equals("time"))
			{
				time = hour+"Ω√ "+minute+"∫– "+ second+"√ ";
				dos.writeUTF(time);
				time = sc.nextLine();
				dos.writeUTF(time);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
