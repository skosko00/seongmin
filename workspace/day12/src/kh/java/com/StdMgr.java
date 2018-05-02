package kh.java.com;

import java.util.Scanner;

public class StdMgr {
	private Student s = new Student();	//정보를 담을 수 있는 그릇
	private Scanner sc = new Scanner(System.in);

	public void start()
	{
		while(true)
		{
			System.out.println("메뉴를 선택하세요");
			System.out.println("1. 학생 정보 입력");
			System.out.println("2. 학생 정보 출력");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:
				insertData();
				break;
			case 2:
				printData();
				break;
			}
		}
	}
	private void insertData()
	{
		System.out.print("이름 입력 : ");
		s.setName(sc.next());
		System.out.print("나이 입력 : ");
		s.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("주소 입력 : ");
		s.setAddr(sc.nextLine());		
	}

	private void printData()
	{
		System.out.println("= = = = = 정 보 출 력 = = = = =");
		System.out.println("이름 : "+s.getName());
		System.out.println("나이 : "+s.getAge());
		System.out.println("주소 : "+s.getAddr());
	}
}
