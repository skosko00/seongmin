package kh.java.com;

import java.util.Scanner;

public class Monitor {
	double inch;
	int pixel, price;
	//  사이즈, 해상도,  가격
	String modelName, company;
	//모델명 ,			제조회사
	boolean power = false;	//전원 꺼짐 true는 전원 켜짐

	public void start()
	{
		Scanner sc = new Scanner(System.in);
		monitorInfoInsert(); //모니터 정보 입력
		while(true)
		{
			menu();
			int select = sc.nextInt();
			switch(select)
			{
			case 1:
				powerOnOff();
				break;
			case 2:
				monitorInfo();
				break;
			case 3:

				break;
			}
		}
	}

	public void menu()
	{
		System.out.println("-------- 모니터 제어 메뉴 --------");
		System.out.println("1. 전원 on/off");
		System.out.println("2. 모니터 정보 보기");
		System.out.println("3. 출력");
		System.out.print("선택");
	}
	public void monitorInfoInsert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("모니터의 크기를 입력하세요(단위 inch) : ");
		inch = sc.nextDouble();
		System.out.print("해상도를 입력하세요 (단위 pixel) : ");
		pixel = sc.nextInt();
		System.out.print("모델명을 입력하세요 : ");
		modelName = sc.next();
		System.out.print("가격을 입력하세요 : ");
		price = sc.nextInt();
		sc.nextLine();
		System.out.print("제조회사를 입력하세요 : ");
		company = sc.nextLine();
	}

	public void monitorInfo()
	{
		if(power==true)
		{
		System.out.printf("-------------------\n");
		System.out.printf("-사이즈:%.2f		 -\n",inch);
		System.out.printf("-해상도:%d		 -\n",pixel);
		System.out.printf("-모델명:%s		 -\n",modelName);
		System.out.printf("-가격 : %d 원		 -\n",price);
		System.out.printf("-제조회사 :%s		 -\n",company);
		System.out.printf("-------------------\n");
		}
		else
		{
			System.out.println("현재 모니터가 off 상태 입니다.");
			System.out.println("모니터 전원을 on 해주시고 실행해주세요.");
		}
	}
	public void print()
	{
		System.out.println();
	}

	public void powerOnOff()
	{
		if(power == false)	//전원이 off 상태라면!
		{
			power = true;
			System.out.println("전원이 켜졌습니다.");
		}
		else if(power ==true)	//전원이 on 상태라면!
		{
			power = false;
			System.out.println("전원이 꺼졌습니다.");
		}
	}


}
