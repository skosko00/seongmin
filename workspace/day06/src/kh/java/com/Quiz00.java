package kh.java.com;

import java.util.Scanner;

public class Quiz00 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int num, sum = 0;
		
		while(i<5)
		{
			i++;
			System.out.print("�������� �Է��Ͻÿ� : ");
			num = sc.nextInt();
			sum += num;
		}
		
		System.out.println("�Է��� "+i+"���� ������ �� : "+sum);
	}

}
