package kh.java.com;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int [] score = new int [5];
		int sum=0;
		for(int i=1;i<score.length+1;i++)
		{
			System.out.printf("%d ��° �л��� ���� :",i);
			score[i-1] = sc.nextInt();
			sum += score[i-1];
		}
		System.out.printf("�л����� �� �հ� : %d \n",sum);
		System.out.printf("�л����� ��� ���� : %.2f",(double)sum/score.length);
		
	}

}
