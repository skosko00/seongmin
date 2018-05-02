package kh.java.work;

import java.util.Scanner;

public class HomeWorkTest {
	public void test1()
	{
		Scanner sc = new Scanner(System.in);
		String fruit;
		System.out.println("과일을 선택하세요");
		System.out.println("사과 , 바나나, 복숭아, 키위");
		fruit = sc.nextLine();

		switch(fruit)
		{
		case "사과" :			//사과 입력시 아래의 실행문 실행
			System.out.println("사과의 가격은 1000원 입니다.");
			break;
		case "바나나" :		//바나나 입력시 아래의 실행문 실행
			System.out.println("바나나의 가격은 3000원 입니다.");
			break;
		case "복숭아" :		//복숭아 입력시 아래의 실행문 실행
			System.out.println("복숭아의 가격은 2000원 입니다.");
			break;
		case "키위" :			//키위 입력시 아래의 실행문 실행
			System.out.println("키위의 가격은 5000원 입니다.");
			break;

		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("*******초기 메뉴*******");
		System.out.println("1.입력");
		System.out.println("2.수정");
		System.out.println("3.조회");
		System.out.println("4.삭제");
		System.out.println("0.종료");
		System.out.println("********************");
		System.out.print("메뉴번호 입력 : ");
		num = sc.nextInt();
		switch(num)
		{
		case 1:			// 2 입력시 아래의 실행문 실행
			System.out.println("입력메뉴선택");
			break;
		case 2:			// 3 입력시 아래의 실행문 실행
			System.out.println("수정메뉴선택");
			break;
		case 3:			// 4 입력시 아래의 실행문 실행
			System.out.println("조회메뉴선택");
			break;
		case 4:			// 5 입력시 아래의 실행문 실행
			System.out.println("삭제메뉴선택");
			break;
		case 0:			// 0 입력시 아래의 실행문 실행
			System.out.println("프로그램을 종료합니다.");
			break;
		default:		// 위의 조건에 만족하는 결과가 없을 경우 실행
			System.out.println("번호를 잘못 누르셨습니다.");
			break;
		}
	}

	public void test3()
	{
		int num;
		Scanner sc= new Scanner(System.in);
		System.out.println("**********메  뉴**********");
		System.out.println("1. 떡볶이-------------1000");
		System.out.println("2. 김밥--------------2000");
		System.out.println("3. 오뎅--------------1000");
		System.out.println("4. 순대--------------2000");
		System.out.println("5. 튀김--------------3000");
		System.out.println("6. 떡튀순-------------8000");
		System.out.println("************************");
		System.out.print("메뉴번호 입력 : ");

		num = sc.nextInt();

		switch(num)
		{
		case 1:			// 1 입력시 아래의 실행문이 실행
			System.out.println("떡볶이는 1000원입니다.");
			break;
		case 2:			// 2 입력시 아래의 실행문이 실행
			System.out.println("김밥은 2000원입니다.");
			break;
		case 3:			// 3 입력시 아래의 실행문이 실행
			System.out.println("오뎅은 1000원입니다.");
			break;
		case 4:			// 4 입력시 아래의 실행문이 실행
			System.out.println("순대는 2000원입니다.");
			break;
		case 5:			// 5 입력시 아래의 실행문이 실행
			System.out.println("튀김은 3000원입니다.");
			break;
		case 6:			// 6 입력시 아래의 실행문이 실행
			System.out.println("떡튀순은 8000원입니다.");
			break;
		default :		// 위의 조건에 만족하는 결과가 없을 경우 실행
			System.out.println("번호가 잘못 입력되었습니다. 영업을 종료합니다");
			return;
		}
	}

	public void test4()
	{
		Scanner sc = new Scanner(System.in);
		int num, won;
		String menu="", side="";
		char menuSelect;

		System.out.println("*********주메뉴*********");
		System.out.println("a.불고기버거----------5000");
		System.out.println("b.새우버거-----------4000");
		System.out.println("c.치킨버거-----------4500");
		System.out.println("d.한우버거----------10000");
		System.out.println("e.디버거------------7000");
		System.out.println("**********************");
		System.out.print("메뉴를 선택하세요 : ");
		menuSelect = sc.next().charAt(0);

		switch(menuSelect)
		{
		case 'a':		//a 입력시 아래의 실행문이 실행
			menu = "불고기버거";
			won = 5000;
			break;
		case 'b':		//b 입력시 아래의 실행문이 실행
			menu = "새우버거";
			won = 4000;
			break;
		case 'c':		//c 입력시 아래의 실행문이 실행
			menu = "치킨버거";
			won = 4500;
			break;
		case 'd':		//d 입력시 아래의 실행문이 실행
			menu = "한우버거";
			won = 10000;
			break;
		case 'e':		//e 입력시 아래의 실행문이 실행
			menu = "디버거";
			won = 7000;
			break;
		default:		// 위의 결과값들이 참이 되지 않을 경우 실행
			System.out.println("번호를 잘못 누르셨습니다. 영업을 종료합니다");
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
		case 1:			//1 입력시 아래의 실행문이 실행
			side = "콜라";
			won += 1500;
			break;
		case 2:			//2 입력시 아래의 실행문이 실행
			side = "사이다";
			won += 1500;
			break;
		case 3:			//3 입력시 아래의 실행문이 실행
			side = "밀크쉐이크";
			won += 2500;
			break;
		case 4:			//4 입력시 아래의 실행문이 실행
			side = "레드불";
			won += 3000;
			break;
		default:		// 위의 결과값들이 참이 되지 않을 실행
			System.out.println("번호를 잘못 누르셨습니다. 영업을 종료합니다.");
			return;
		}
		System.out.printf("%s, %s은 총 %d원입니다.", menu, side, won);
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.print("일수를 알고 싶은 달을 입력하시오 : ");
		month = sc.nextInt();
		if(1<=month && month<=12) {			//month의 값이 1~12 사이일 경우 실행
			switch(month)
			{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:		// break문이 없어서 month의 값이 1,3,5,6,7,10,12 일 경우 아래의 코드가 실행
				System.out.println(month + "월달은 31일수입니다.");
				break;

			case 2:			// month의 값이 2일 때 실행
				System.out.println(month + "월달은 28일수입니다.");
				break;

			case 4:
			case 6:
			case 9:
			case 11:		// month의 값이 4, 6, 9, 11 일 때 아래의 코드가 실행
				System.out.println(month + "월달은 30일수입니다.");
				break;
			}
		}
		else		// month의 값이 1~12를 벗어 났을 때 실행
		{
			System.out.println("달을 잘못 입력하셨습니다.");
		}
	}

	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		char grade;
		System.out.println("장학금 지불 시스템 입니다.");
		System.out.println("학생 학점을 입력해주세요");
		System.out.print("(A학점, B학점, C학점, D학점, F학점)");
		grade = sc.next().charAt(0);
		switch(grade)
		{
		case 'A':		//A가 입력 되었을 시에 아래의 실행문을 실행
			System.out.println("수고하셨습니다. 장학금을 100% 지급해드리겠습니다.");
			break;
		case 'B':		//B가 입력 되었을 시에 아래의 실행문을 실행
			System.out.println("수고하셨습니다. 장학금을 50% 지급해드리겠습니다.");
			break;
		case 'C':		//C가 입력 되었을 시에 아래의 실행문을 실행
			System.out.println("이번 학기 장학금은 없네요.. 힘내세요");
			break;
		case 'D':		//D가 입력 되었을 시에 아래의 실행문을 실행
			System.out.println("장학금보다는 학고는 면하셨네요..노력하세요");
			break;
		case 'F':		//F가 입력 되었을 시에 아래의 실행문을 실행
			System.out.println("이번학기 장학금으로 학고를 맞으셨습니다. 3Go일시 제적");
			break;			
		}
	}

	public void test7()
	{
		char oper;
		int num1, num2;
		Scanner sc = new Scanner(System.in);

		System.out.println("=== 계산기 프로그램 ===\n");
		System.out.print("연산자 입력(+, -, *, /) : ");
		oper = sc.next().charAt(0);
		System.out.print("첫번째 숫자 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 숫자 입력 : ");
		num2 = sc.nextInt();
		System.out.println("====== 결 과 ======");
		if(oper == '+' || oper == '-' || oper == '*' || oper == '/')
			// oper의 값이 +, -, *, /가 입력 될 시 실행
		{
			switch(oper)
			{
			case '+':	// + 일 경우 실행
				System.out.printf("%d + %d = %d", num1, num2, num1+num2);
				break;
			case '-':	// - 일 경우 실행
				System.out.printf("%d - %d = %d", num1, num2, num1-num2);
				break;
			case '*':	// * 일 경우 실행
				System.out.printf("%d * %d = %d", num1, num2, num1*num2);
				break;
			case '/':	// / 일 경우 실행
				System.out.printf("%d / %d = %.1f", num1, num2, (double)num1/num2);
				break;
			}
		}
		else		// oper의 값이 +, -, *, / 가 아닐경우 실행
		{
			System.out.println("잘못된 연산자 입니다.");
		}
	}

	public void test8()
	{
		Scanner sc = new Scanner(System.in);
		int score;
		System.out.print("점수 입력 : ");
		score = sc.nextInt();

		if(0<=score && score<=100)		//0~100 까지의 score 점수가 입력 될 경우 실행
		{	
			switch(score/10)		// case의 경우의 수가 많아서 10을 나눈후에 처리
			{
			case 10:		
			case 9:					//90~ 100 사이는 아래의 코드를 실행
				System.out.println("A등급");
				break;
			case 8:					//80~ 90 사이는 아래의 코드를 실행
				System.out.println("B등급");
				break;
			case 7:					//70~ 80 사이는 아래의 코드를 실행
				System.out.println("C등급");
				break;
			case 6:					//60~ 70 사이는 아래의 코드를 실행
				System.out.println("D등급");
				break;
			default :				//60미만은 아래의 코드를 실행
				System.out.println("F등급");
				break;
			}
		}
		else			//0~100 까지의 score 점수가 입력되지 않았을 경우 실행
		{
			System.out.println("잘못된 입력(0~100사이 입력)");
		}
	}

	public void test9()
	{
		int i = 0;
		while(i<5)	//i가 0부터 5보다 작을 때 까지 반복
		{
			i++;
			System.out.println("안녕하세요");
		}
	}
	
	public void test10()
	{
		Scanner sc = new Scanner(System.in);
		int x=0, y;
		System.out.print("몇번을 출력 하시겠습니까?");
		y = sc.nextInt();
		
		while(x<y)		//x가 y보다 작을 때 출력
		{
			System.out.println("안녕하세요");
			x++;		//x의 값이 증가
		}
	}
	
	public void test11()
	{
		int i = 0;
		System.out.println("2단입니다.");
		while(i<9)		//i가 0부터 9보다 작을 때 까지 실행
		{
			i++;
			System.out.printf("2 * %d = %d \n", i, 2*i);
		}
	}
	
	public void test12()
	{
		Scanner sc = new Scanner(System.in);
		int x, y = 0;
		System.out.print("몇단을 출력하시겠습니까?");
		x = sc.nextInt();
		System.out.println(x + "단 입니다.");
		while(y <= 8)		//y가 0부터 8과 같을 때 까지 실행
		{
			y++;
			System.out.printf("%d * %d = %d \n", x, y, x*y);
		}
	}
	
	public void test13()
	{
		Scanner sc = new Scanner(System.in);
		int i = 0, sum = 0;
		while(i<5)		//i가 0부터 5보다 작을 때 까지 실행
		{
			i++;
			System.out.print("정수값을 입력하시오 : ");
			sum += sc.nextInt();	//sum = sum + 입력받은 값
		}
		System.out.println("입력한 " + i + "개의 정수의 합 : " + sum);
	}
}
