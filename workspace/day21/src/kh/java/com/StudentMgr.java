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
			System.out.println("======== 학생 관리 프로그램 ========");
			System.out.println("1. 학생 정보 저장");
			System.out.println("2. 학생 정보 출력");
			System.out.println("0. 종료");
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
		System.out.println("======== 학생 정보 출력 ========");
		System.out.printf("%s \t%s \t%s\n","학번","이름","나이");
		while(iter.hasNext())
		{
		System.out.println(hm.get(iter.next()));
		}
	}

	private void StudentInsert() {
		System.out.println("======== 학생 정보 입력 ========");
		System.out.print("학번 입력 : ");
		int classNumber = sc.nextInt();
		if(hm.containsKey(classNumber))
		{
			System.out.println("이미 해당 학번 학생이 존재합니다.");
		}
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		
		hm.put(classNumber, new Student(classNumber, name, age));
		
	}
}
