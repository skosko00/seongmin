package kh.java.test;

import java.util.Scanner;

public class Quiz01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = sc.nextInt();
		if(1<=num && num<=100)
		{
			if(num%2==0)
			{
				System.out.println("2의 배수입니다.");
			}
			else
			{
				System.out.println("2의 배수가 아닙니다.");
			}
		}
		else
		{
			System.out.println("1~100사이의 수가 아닙니다.");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
