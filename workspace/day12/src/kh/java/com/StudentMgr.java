package kh.java.com;

import java.util.Scanner;

public class StudentMgr {
	String name;
	int age;
	String addr;
	public void inserData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 이름 입력 : ");
		name = sc.next();
		System.out.print("학생 나이 입력 : ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("학생 주소 입력 : ");
		addr = sc.nextLine();
	}
	
	public void printData()
	{
		System.out.println("\n ======= 정보 출력 =======");
		System.out.println("   이름               나이               주소");
		System.out.println("   "+name+"    "+age+"    "+addr);
	}
	
}
