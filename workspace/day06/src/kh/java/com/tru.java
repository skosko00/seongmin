package kh.java.com;

import java.util.Scanner;

public class tru {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1, num2, sum = 0, count = 0;
		double avg=0;

		System.out.print("첫번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();

		if(num1<=num2) {
			while(num1<=num2)
			{
				if(num1%3==0 || num1%5==0)
				{
					sum += num1;
					count++;
					avg = (double)sum / count;
					num1++;
				}
				else
				{
					num1++;
				}

			}
		}
		else {
			while(num2<=num1)
			{
				if(num2%3==0 || num2%5==0)
				{
					sum += num2;
					count++;
					avg = (double)sum / count;
					num2++;
				}
				else
				{
					num2++;
				}
			}
		}


		System.out.printf("평균  : %.1f 합 : %d", avg, sum);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
