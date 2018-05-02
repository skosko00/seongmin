package kh.java.com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int [] arr = new int [4];
		
		System.out.print("국어 점수 : ");
		arr[0] = sc.nextInt();
		System.out.print("영어 점수 : ");
		arr[1] = sc.nextInt();
		System.out.print("수학 점수 : ");
		arr[2] = sc.nextInt();
		arr[3] = arr[0]+arr[1]+arr[2];
		System.out.println("---------------------------");
		System.out.println("국어 : " + arr[0]);
		System.out.println("영어 : " + arr[1]);
		System.out.println("수학 : " + arr[2]);
		System.out.println("합계 : " + arr[3]);
		System.out.println("평균 : " + (arr[3])/3.0);
		
		
	}

}
