package kh.com.java;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int num;
		String str = "";

		num = r.nextInt(3);
		switch(num)
		{
		case 0 :
			str = "����";
			break;
		case 1 :
			str = "����";
			break;
		case 2 :
			str = "��";
			break;
		}
		System.out.println("===================");

		if(args[0].equals("����") && num== 0 || args[0].equals("����") && num== 1 || args[0].equals("��") && num== 2)
		{
			System.out.printf("your is %s \n", args);
			System.out.printf("your is %s \n", str);
			System.out.println("Draw!");
			System.out.println("==================");
		}
		else if(args[0].equals("����") && num==1)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Lose!");
			System.out.println("==================");
		}
		else if(args[0].equals("����") && num==2)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Win");
			System.out.println("==================");
		}
		else if(args[0].equals("����") && num==0)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Win");			
			System.out.println("==================");
		}
		else if(args[0].equals("����") && num==2)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Lose!");
			System.out.println("==================");
		}
		else if(args[0].equals("��") && num==0)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Lose!");
			System.out.println("==================");
		}
		else if(args[0].equals("��") && num==1)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Win");
			System.out.println("==================");
		}
	}

}
