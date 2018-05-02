package com.kh.info;
import java.util.*;

public class PrintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("양수를 입력하세요 : ");
		int a = sc.nextInt();
		
		System.out.println("-------------------------출력-------------------------");
		System.out.println((~a)+1);
		
	}

}