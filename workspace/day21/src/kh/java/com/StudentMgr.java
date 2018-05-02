package kh.java.com;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class StudentMgr {
	private HashMap hm = new HashMap();
	
	private Scanner sc = new Scanner(System.in);
	
	public void start()
	{
		while(true)
		{
			System.out.println("======== �л� ���� ���α׷� ========");
			System.out.println("1. �л� ���� ����");
			System.out.println("2. �л� ���� ���");
			System.out.println("0. ����");
			switch(sc.nextInt())
			{
			case 0:
				System.exit(0);
			case 1:
				StudentInsert();break;
			case 2:
				StudentPrint();break;
			}
			
			
		}
	}

	private void StudentPrint() {
		Iterator iter = hm.keySet().iterator();
		System.out.println("======== �л� ���� ��� ========");
		System.out.printf("%s \t%s \t%s\n","�й�","�̸�","����");
		while(iter.hasNext())
		{
		System.out.println(hm.get(iter.next()));
		}
	}

	private void StudentInsert() {
		System.out.println("======== �л� ���� �Է� ========");
		System.out.print("�й� �Է� : ");
		int classNumber = sc.nextInt();
		if(hm.containsKey(classNumber))
		{
			System.out.println("�̹� �ش� �й� �л��� �����մϴ�.");
		}
		System.out.print("�̸� �Է� : ");
		String name = sc.next();
		System.out.print("���� �Է� : ");
		int age = sc.nextInt();
		
		hm.put(classNumber, new Student(classNumber, name, age));
		
	}
}
