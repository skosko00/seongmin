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
			str = "가위";
			break;
		case 1 :
			str = "바위";
			break;
		case 2 :
			str = "보";
			break;
		}
		System.out.println("===================");

		if(args[0].equals("가위") && num== 0 || args[0].equals("바위") && num== 1 || args[0].equals("보") && num== 2)
		{
			System.out.printf("your is %s \n", args);
			System.out.printf("your is %s \n", str);
			System.out.println("Draw!");
			System.out.println("==================");
		}
		else if(args[0].equals("가위") && num==1)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Lose!");
			System.out.println("==================");
		}
		else if(args[0].equals("가위") && num==2)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Win");
			System.out.println("==================");
		}
		else if(args[0].equals("바위") && num==0)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Win");			
			System.out.println("==================");
		}
		else if(args[0].equals("바위") && num==2)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Lose!");
			System.out.println("==================");
		}
		else if(args[0].equals("보") && num==0)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Lose!");
			System.out.println("==================");
		}
		else if(args[0].equals("보") && num==1)
		{
			System.out.printf("your is %s \n", args[0]);
			System.out.printf("your is %s \n", str);
			System.out.println("You Win");
			System.out.println("==================");
		}
	}

}
