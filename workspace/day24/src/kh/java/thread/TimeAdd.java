package kh.java.thread;

import java.util.Scanner;

public class TimeAdd implements Runnable{

	@Override
	public void run()
	{
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			if(sc.nextInt()==1)
			{
				TestClass.second += 10;
			}
		}
	}
}
