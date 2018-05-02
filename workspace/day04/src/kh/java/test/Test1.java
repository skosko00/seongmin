package kh.java.test;

import java.util.Scanner;

public class Test1 {
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("임의의 수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>0)
		{
			System.out.printf("당신이 입력한 수 %d는 양수입니다.",num);
		}
		if(num==0)
		{
			System.out.printf("당신이 입력한 수 %d는 0 입니다.", num);
		}
		if(num<0)
				{
			System.out.printf("당신이 입력한 수 %d는 음수입니다.", num);
		}
	}
	
	public void test2() {
		int num1, num2;
		System.out.println(" = = = = = 두 수 비교 프로그램 ver 1.0 = = = = =");
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수를 입력 하세요 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 수를 입력 하세요 : ");
		num2 = sc.nextInt();
		
		if (num1 > num2)
		{
			System.out.println(num1 + " > " + num2);
			System.out.println("첫번째 수가 더 큽니다.");
		}
		if (num1 < num2)
		{
			System.out.println(num1 + " + " + num2);
			System.out.println("첫번째 수가 두번째 수 보다 작습니다.");
		}
		if (num1 == num2)
		{
			System.out.println(num1 + " = " + num2);
			System.out.println("첫번째 수와 두번째 수가 같습니다.");
		}
	}
	
	public void test3() {
		int num1, num2;
		char oper;
		Scanner sc = new Scanner(System.in);
		System.out.println("계산기 프로그램 ver 1.0");
		System.out.printf("연산자를 입력하세요(+,-,*,/)");
		oper = sc.next().charAt(0);
		System.out.print("첫번째 수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		num2 = sc.nextInt();
		
		if (oper == '+')
		{
			System.out.printf("%d+%d=%d", num1, num2, num1+num2);
		}
		if (oper == '-')
		{
			System.out.printf("%d-%d=%d", num1, num2, num1-num2);
		}
		if (oper == '=')
		{
			System.out.printf("%d*%d=%d", num1, num2, num1*num2);
		}
		if (oper == '/')
		{
			System.out.printf("%d/%d=%f", num1, num2, (double)num1/num2);
		}
	}
	
	public void test4()
	{
		Scanner sc = new Scanner(System.in);
		int su;
		System.out.print("정수 입력 : ");
		su = sc.nextInt();
		if(su>0)
		{
			System.out.println("입력 값은 0보다 크다");
		}
		else
		{
			System.out.println("입력 값은 0보다 크지 않다.");
		}
	}
	
	public void test5() 
	{
	Scanner sc = new Scanner(System.in);
	
	int total, adult, child;
	System.out.println("놀이 공원 프로그램 v1.0");
	System.out.print("입장 하실 인원은 총 몇명입니까?");
	total = sc.nextInt();
	
	System.out.print("어른은 몇명입니까? (인원당 1만 5천원)");
	adult = sc.nextInt();
	System.out.print("아이는 몇명입니까? (인원당 5천원)");
	child = sc.nextInt();
	
	if (total == adult + child) 
	{
		adult *= 15000;
		child *= 5000;
		System.out.println("지불하실 총 금액은 " + (adult + child) + "원 입니다.");
	}
	else
	{
		System.out.println("말씀하신 인원이 맞질 않습니다.");
	}
	}
	
	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		
		int select, count = 0;
		
		System.out.println("첫번째 퀴즈입니다.");		
		System.out.print("사과는 영어로 무엇일까요?(1.Apple / 2.잡스) :");
		select = sc.nextInt();
		
		if (select == 1)
		{
			System.out.println("정답!!");
			count++;
		}
		else
		{
			System.out.println("땡!");
		}
		System.out.println("두번째 퀴즈입니다.");
		System.out.print("바나나는 길어 길으면 기차 기차는?(1.빨라 2.비싸) :");
		select = sc.nextInt();
		if (select == 1)
		{
			System.out.println("정답!!");
			count++;
		}
		else 
		{
			System.out.println("땡!");
		}
		System.out.println("총 " + count + "문제를 맞추셨습니다.");
	}
	
	public void test7() 
	{
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.print("1부터 100까지의 수 중 선택 : ");
		num1 = sc.nextInt();
		if(num1 > 0 && num1 <= 100) 
		{
			if(num1%2 == 0)
			{
				System.out.println("입력한 수는 짝수 입니다.\n");
			}
			else
			{
				System.out.println("입력한 수는 홀수 입니다");
			}
		}
		else
		{
			System.out.println("잘못된 수를 입력하였습니다.");
		}
	}
	
	public void test8()
	{
		Scanner sc= new Scanner(System.in);
		
		int select;
		System.out.println("= = = = = = 심리 테스트 v1.0 = = = = = = \n");
		System.out.print("당신은 술을 좋아하십니까?(1.yes, 2.no)");
		select = sc.nextInt();
		if (select == 1)
		{
			System.out.print("당신은 담배를 피웁니까?(1.yes, 2.no)");
			select = sc.nextInt();
			if (select == 1)
			{
				System.out.println("담배는 건강에 좋지 않습니다!!!");
			}
			else
			{
				System.out.println("담배는 피우지 않아도 술 때문에 간이 위험해요!");
			}
		}
		else
		{
			System.out.print("당신은 이성친구가 있습니까?(1.yes, 2.no)");
			select = sc.nextInt();
			if (select == 1)
			{
				System.out.println("올.......");
			}
			else
			{
				System.out.println("...힘내세요.. 무슨낙으로 사시나요..?");
			}
		}
	}
	
	public void test9()
	{
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.print("Input Number 1 ~ 3 : ");
		num1 = sc.nextInt();
		if(num1 == 1)
		{
			System.out.println("One !");
		}
		else if(num1 == 2)
		{
			System.out.println("Two !");
		}
		else if(num1 == 3)
		{
			System.out.println("Three !");
		}
		else
		{
			System.out.println("Error !");
		}
	}

	public void test10()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.print("문자 입력 : ");
		ch = sc.next().charAt(0);
		System.out.println("==== 결과 ====");
		if ('A' <= ch && ch <='Z')	//대문자
		{
			System.out.println("대문자를 입력 하였습니다.");
			System.out.printf("소문자로 변환 : %c \n",(ch^32));
			System.out.println("-------------------->Restart");
		}
		else if ('a' <=ch && ch <= 'z')	//소문자
		{
			System.out.println("소문자를 입력 하였습니다.");
			System.out.printf("대문자로 변환 : %c \n",(ch^32));
			System.out.println("-------------------->Restart");
		}
		else	//잘못입력
		{
			System.out.println("잘못 입력하셨습니다 영문자를 입력해주세요");
		}
	}
	
	public void test11()
	{
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("정수 입력 : ");
		num = sc.nextInt();
		
		if (num!=0)
		{
			if(num%3==0 && num%4==0)
			{
				System.out.printf("[%d]은(는) 3의 배수 이면서, 4의 배수입니다.",num);
			}
			else if(num%3==0)
			{
				System.out.printf("[%d]은(는) 3의 배수입니다.",num);
			}
			else if(num%4==0)
			{
				System.out.printf("[%d]은(는) 4의 배수입니다.",num);
			}
			else
			{
				System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.",num);
			}
		}
		else
		{
			System.out.printf("%d은(는) 3의 배수도 4의 배수도 아닙니다.",num);
		}
	}
}