package kh.java.com;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int [] arr = new int [4];
		
		System.out.print("���� ���� : ");
		arr[0] = sc.nextInt();
		System.out.print("���� ���� : ");
		arr[1] = sc.nextInt();
		System.out.print("���� ���� : ");
		arr[2] = sc.nextInt();
		arr[3] = arr[0]+arr[1]+arr[2];
		System.out.println("---------------------------");
		System.out.println("���� : " + arr[0]);
		System.out.println("���� : " + arr[1]);
		System.out.println("���� : " + arr[2]);
		System.out.println("�հ� : " + arr[3]);
		System.out.println("��� : " + (arr[3])/3.0);
		
		
	}

}
