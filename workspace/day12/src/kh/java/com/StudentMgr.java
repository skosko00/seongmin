package kh.java.com;

import java.util.Scanner;

public class StudentMgr {
	String name;
	int age;
	String addr;
	public void inserData()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�л� �̸� �Է� : ");
		name = sc.next();
		System.out.print("�л� ���� �Է� : ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("�л� �ּ� �Է� : ");
		addr = sc.nextLine();
	}
	
	public void printData()
	{
		System.out.println("\n ======= ���� ��� =======");
		System.out.println("   �̸�               ����               �ּ�");
		System.out.println("   "+name+"    "+age+"    "+addr);
	}
	
}
