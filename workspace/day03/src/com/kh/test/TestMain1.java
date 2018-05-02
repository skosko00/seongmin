package com.kh.test;
import java.util.*;

public class TestMain1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
		System.out.print("이름을 적으세요 : ");
		String name = sc.nextLine();
		System.out.print("나이를 적으세요 : ");
		int age = sc.nextInt();
		System.out.print("주소를 적으세요 : ");
		sc.nextLine();
		String addr = sc.nextLine();
		System.out.print("키를 적으세요 : ");
		double key = sc.nextDouble();
		System.out.print("몸무게를 적으세요 : ");
		double wei = sc.nextDouble();
		System.out.println("성별을 적으세요 : ");
		sc.nextLine();
		char sex = sc.next().charAt(0);
		
		System.out.println("--------출력--------");
		System.out.println("당신의 이름은 " + name + " 이군요");
		System.out.println("당신의 나이는 " + age + "세 이군요");
		System.out.println("당신의 주소는 " + addr + " 이군요");
		System.out.println("당신의 키는" + key + "cm 이군요");
		System.out.println("당신의 몸무게는 " + wei + "kg 이군요");
		System.out.println("당신의 성별은 " + sex + " 이군요");
	}

}