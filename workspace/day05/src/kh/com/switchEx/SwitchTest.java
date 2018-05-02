package kh.com.switchEx;

import java.util.Scanner;

public class SwitchTest {
	public void switchTest1()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.print("1~3까지 숫자 입력 : ");
		select = sc.nextInt();
		switch(select)
		{
		case 1:
			System.out.println("1을 입력하였습니다.");
			break;
		case 2:
			System.out.println("2을 입력하였습니다.");
			break;
		case 3:
			System.out.println("3을 입력하였습니다.");
			break;
		default :
			System.out.println("잘못된 값을 입력하셨습니다.");
		}
	}

	public void switchTest2()
	{
		Scanner sc = new Scanner(System.in);
		String menu;
		System.out.print("\"사과\", \"바나나\", \"복숭아\", \"키위\" 선택하세요 : ");
		menu = sc.nextLine();

		switch(menu)
		{
		case "사과" :
			System.out.println("사과 - 1000원");
			break;
		case "바나나" :
			System.out.println("바나나 - 3000원");
			break;
		case "복숭아" :
			System.out.println("복숭아 - 2000원");
			break;
		case "키위" :
			System.out.println("키위 - 5000원");
			break;
		default :
			System.out.println("선택하신 과일이 메뉴에 없습니다.");
		}
	}

	public void switchTest3()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.println("*******초기 메뉴*******");
		System.out.println("1.입력 \n2.수정 \n3.조회 \n4.삭제 \n0.종료");	
		System.out.println("********************");
		System.out.println("메뉴번호 입력 : '번호입력'");
		select = sc.nextInt();

		switch(select)
		{
		case 1 :
			System.out.println("입력메뉴선택");
			break;
		case 2 :
			System.out.println("수정메뉴선택");
			break;
		case 3 :
			System.out.println("조회메뉴선택");
			break;
		case 4 :
			System.out.println("삭제메뉴선택");
			break;
		case 0 :
			System.out.println("프로그램을 종료합니다.");
			break;
		default :
			System.out.println("번호를 잘못 누르셨습니다.");
		}
	}

	public void switchTest4()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		String menu = "", side = "";
		int num, won;
		System.out.println("*********주메뉴*********");
		System.out.println("a.불고기버거----------5000");
		System.out.println("b.새우버거-----------4000");
		System.out.println("c.치킨버거-----------4500");
		System.out.println("d.한우버거----------10000");
		System.out.println("e.디버거------------7000");
		System.out.println("**********************");
		System.out.print("메뉴를 선택하세요 : ");
		ch = sc.next().charAt(0);

		switch(ch)
		{
		case 'a' :
			menu = "불고기버거";
			won = 5000;
			break;
		case 'b' :
			menu = "새우버거";
			won = 4000;
			break;
		case 'c':
			menu = "치킨버거";
			won = 4500;
			break;
		case 'd':
			menu = "한우버거";
			won = 10000;
			break;
		case 'e':
			menu = "디버거";
			won = 7000;
			break;
		default :
			System.out.println("번호를 잘못 누르셨습니다. 영업을 종료합니다.");
			return;
		}

		System.out.println("*********주메뉴*********");
		System.out.println("1.콜라--------------1500");
		System.out.println("2.사이다-------------1500");
		System.out.println("3.밀크쉐이크----------2500");
		System.out.println("4.레드불-------------3000");
		System.out.println("**********************");
		System.out.print("사이드메뉴를 선택하세요 : ");
		num = sc.nextInt();

		switch(num)
		{
		case 1 :
			side = "콜라";
			won += 1500;
			break;
		case 2 :
			side = "사이다";
			won += 1500;
			break;
		case 3:
			side = "밀크쉐이크";
			won += 2500;
			break;
		case 4:
			side = "레드불";
			won += 3000;
			break;
		default :
			System.out.println("번호를 잘못 누르셨습니다. 영업을 종료합니다.");
			return;			
		}
		System.out.printf("%s, %s은(는) 총 %d원 입니다.",menu, side, won);
	}

	public void switchTest5()
	{
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.print("일수를 알고 싶은 달을 입력하시오 : ");
		month = sc.nextInt();

		if(1<=month && month<=12) {
			switch(month)
			{
			case 2:
				System.out.println(month + "월 달은 28일 수 입니다.");
				break;

			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(month + "월 달은 30일 수 입니다.");
				break;

			default :
				System.out.println(month + "월 달은 31일 수 입니다.");
				break;

			}
		}
		else
		{
			System.out.println("잘못된 달을 입력하셨습니다.");
		}
	}

	public void switchTest6()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("===계산기 프로그램===");
		int num1, num2;
		char oper;
		System.out.print("연산자 입력 (+, -, *, /) : ");
		oper = sc.next().charAt(0);
		if(oper =='+' || oper =='-' || oper =='*' || oper =='/')
		{
			System.out.print("첫 번째 숫자 입력 : ");
			num1 = sc.nextInt();
			System.out.print("두 번째 숫자 입력 : ");
			num2 = sc.nextInt();

			switch(oper) 
			{
			case '+':
				System.out.printf("%d + %d = %d", num1, num2, num1+num2);
				break;
			case '-':
				System.out.printf("%d - %d = %d", num1, num2, num1-num2);
				break;
			case '*':
				System.out.printf("%d * %d = %d", num1, num2, num1*num2);
				break;
			case '/':
				System.out.printf("%d / %d = %.1f", num1, num2, (double)num1/num2);
				break;
			default:
				System.out.println("잘못된 연산자 입니다.");
				break;
			}
		}
		else
		{
			System.out.println("잘못 입력하셨습니다" + oper + "는 연산 할 수 없습니다.");
		}
	}


}
