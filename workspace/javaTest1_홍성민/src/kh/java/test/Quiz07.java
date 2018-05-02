package kh.java.test;

import java.util.Scanner;

public class Quiz07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [5];
		int sum=0;
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(i+1+"번째 수 입력 : ");
			arr[i]=sc.nextInt();
			if(arr[i]%2==1)
			{
				sum += arr[i];
			}
		}		
		System.out.println("홀수들의 합계 : "+sum);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
