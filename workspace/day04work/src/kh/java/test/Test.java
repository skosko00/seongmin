package kh.java.test;

import java.util.Scanner;

public class Test {
	public void test1()
	{
		Scanner sc = new Scanner(System.in);	//Scanner 클래스를 변수 sc로 치환
		int num;
		System.out.print("임의의 수를 입력하세요 : ");
		num = sc.nextInt();		//num 변수의 키보드로 값을 입력 받음
		if(num>0)		//num이 0보다 클 때
		{
			System.out.println("당신이 입력한 수 " + num + "는 양수입니다.");
		}
		if(num==0)		//num이 0이랑 같을 때
		{
			System.out.println("당신이 입력한 수" + num + "는 0입니다.");
		}
		if(num<0)		//num이 0보다 작을 때
		{
			System.out.println("당신이 입력한 수 " + num + "은 음수입니다.");
		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in);	//Scanner 클래스를 변수 sc로 치환
		int firstNum, secondNum;
		System.out.print("첫번째 수를 입력 하세요 : ");
		firstNum = sc.nextInt();				//firstNum 변수에 키보드로 값을 입력 받음
		System.out.print("두번째 수를 입력 하세요 : ");
		secondNum = sc.nextInt();				//secondNum 변수에 키보드로 값을 입력 받음

		if(firstNum > secondNum)				//firstNum이 secondNum보다 클 때
		{
			System.out.println(firstNum + " > " + secondNum);
			System.out.println("첫번째 수가 더 큽니다.");
		}
		if(firstNum == secondNum)				//firstNum이 secondNum과 같을 때
		{
			System.out.println(firstNum + " = " + secondNum);
			System.out.println("두 수가 같은 수 입니다.");
		}
		if(firstNum < secondNum)				//firstNum이 secondNum보다 작을 때
		{
			System.out.println(firstNum + " < " + secondNum);
			System.out.println("두번째 수가 더 큽니다.");
		}
	}

	public void test3()
	{
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char ch;
		System.out.println("계산기 프로그램 ver1.0");
		System.out.print("연산자를 입력하세요(+,-,*,/) : ");
		ch = sc.next().charAt(0);		//ch 변수에 첫문자를 입력 받음
		System.out.print("첫번째 수 입력 : ");
		num1 = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		num2 = sc.nextInt();

		if (ch == '+')					//ch 변수에 저장된 첫 문자 값이 + 일 때
		{
			System.out.printf("%d+%d=%d", num1, num2, num1+num2);
		}
		if (ch == '-')					//ch 변수에 저장된 첫 문자 값이 - 일 때
		{
			System.out.printf("%d-%d=%d", num1, num2, num1-num2);
		}
		if (ch == '*')					//ch 변수에 저장된 첫 문자 값이 * 일 때
		{
			System.out.printf("%d*%d=%d", num1, num2, num1*num2);			
		}
		if (ch == '/')					//ch 변수에 저장된 첫 문자 값이 / 일 때
		{
			System.out.printf("%d/%d=%.16f", num1, num2, (double)num1/num2);
		}											//(double)형으로 강제 형변환
	}

	public void test4()
	{
		Scanner sc = new Scanner(System.in);
		int total, adult, kid;
		System.out.println("놀이 공원 프로그램 v1.0");
		System.out.print("입장 하실 인원은 총 몇명입니까?");
		total = sc.nextInt();
		System.out.print("어른은 몇명입니까?(인원당 1만5천원)");
		adult = sc.nextInt();
		System.out.print("아이는 몇명입니까?(인원당 5천원)");
		kid = sc.nextInt();

		if(total == adult+kid)					//입력 받은 total 값이랑 adult+kid 값이 같을 때
		{
			adult *= 15000;						//adult 값의 *15000을 하여 adult에 저장
			kid *= 5000;						//kid 값의 *5000을 하여 adult에 저장
			System.out.printf("지불하실 총 금액은 %d원 입니다.", adult+kid);
		}
		else									//위의 조건이 거짓일 때
		{
			System.out.println("말씀하신 인원이 맞질 않습니다.");
		}
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int choice, count=0;
		System.out.println("첫번째 퀴즈입니다.");
		System.out.print("사과는 영어로 무엇일까요?(1.Apple / 2.잡스)");
		choice = sc.nextInt();
		if(choice == 1)				//choice 변수의 들어 온 값이 1일 때 실행
		{
			System.out.println("정답!!");
			count++;				//정답일 경우 0에서 1씩 증가
		}
		else						//위의 조건식에서 false일 경우 실행
		{
			System.out.println("땡!");
		}
		System.out.print("바나나는 길어 길으면 기차 기차는?(1.빨라 2.비싸)");
		choice = sc.nextInt();
		if(choice == 1)				//choice 변수의 들어 온 값이 1일 때 실행
		{
			System.out.println("정답!!");
			count++;				//정답일 경우 0에서 1씩 증가
		}
		else						//위의 조건식에서 false일 경우 실행
		{
			System.out.println("땡!");
		}
		System.out.printf("총 %d 문제를 맞추셨습니다.",count );  //총 카운트 된 숫자가 출력
	}

	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		String name;
		int grade, group, num;
		char sex;
		double avg;

		System.out.print("학생 이름 : ");
		name = sc.nextLine();
		System.out.print("학년 : ");
		grade = sc.nextInt();
		System.out.print("반 : ");
		group = sc.nextInt();
		System.out.print("번호 : ");
		num = sc.nextInt();
		System.out.print("성별 : (남학생은 M 여학생은 F)");
		sex = sc.next().charAt(0);		//sex 변수에 문자를 입력받음
		System.out.print("성적 : ");
		avg = sc.nextDouble();

		if(sex == 'M')		//sex변수에 입력 받은 값이 M일 경우 실행
		{
			System.out.printf("%d학년 %d반 %d번 남학생 %s은 성적이 %.2f이다."
					,grade, group, num, name, avg);		//소수점 2째자리 까지 출력
		}
		else				//if문의 값이 false일 경우에 실행
		{
			System.out.printf("%d학년 %d반 %d번 여학생 %s은 성적이 %.2f이다"
					,grade, group, num, name, avg);		//소수점 2째자리 까지 출력
		}
	}

	public void test7()
	{
		Scanner sc = new Scanner(System.in);

		int kor, eng, math, sum;
		double avg;

		System.out.print("국어 점수를 입력하세요 : ");
		kor = sc.nextInt();
		System.out.print("영어 점수를 입력하세요 : ");
		eng = sc.nextInt();
		System.out.print("수학 점수를 입력하세요 : ");
		math = sc.nextInt();

		sum = kor + eng + math;
		avg = sum / 3.0;

		if (40 <= kor && 40 <= eng && 40 <= math && 60 <= avg)
			//kor, eng, math 변수의 입력 받은 값이 각각 40 이상일 경우 그리고 avg의 값이 60이상일 경우 실행
		{
			System.out.println("합격입니다.");
		}
		else	//위의 조건을 만족하지 못 할 때 실행
		{
			System.out.println("불합격입니다.");
		}
	}

	public void test8()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.print("당신은 술을 좋아하십니까?(1.yes2.no)");
		select = sc.nextInt();
		if(select == 1)		//select의 값이 1일 경우 실행
		{
			System.out.print("당신은 담배를 피웁니까?(1.yes 2.no)");
			select = sc.nextInt();
			if(select == 1)		//첫번째 조건식이 1이고 두번째 조건식이 1일 경우 실행
			{
				System.out.println("담배는 건강에 좋지 않습니다!!!");
			}
			else				//첫번째 조건식이 1이고 두번째 조건식이 false 일 때 실행
			{
				System.out.println("담배를 피우지 않아도 술 때문에 간이 위험해요!");
			}
		}
		else
		{
			System.out.print("당신은 이성친구가 있습니까?(1.yes,2.no)");
			select = sc.nextInt();
			if(select == 1)		//첫번째 조건식이 flase이고 두번째 조건식이 1일 경우 실행
			{
				System.out.println("올..........");
			}
			else				//첫번째 조건식이 flase이고 두번째 조건식이 false 일 때 실행
			{
				System.out.println("...힘내세요.. 무슨낙으로 사시나요..?");
			}
		}
	}

	public void test9()
	{
		Scanner sc = new Scanner(System.in);
		int num;

		System.out.print("1~10 사이의 정수를 입력 하세요 : ");
		num = sc.nextInt();
		if(0 < num && num < 11)		//num의 값이 1 이상 10 이하 일 경우에 실행
		{
			if(num%2 == 0)		//첫번째 조건문을 만족하고 num의 값을 2로 나누어 나머지값이 0일 때 실행
			{
				System.out.println("짝수다.");
			}
			else				//첫번째 조건문을 만족하고 false일 때 실행
			{
				System.out.println("홀수다.");
			}
		}
		else			//조건문이 false 일 때 실행
		{
			System.out.println("반드시 1~10사이의 정수를 입력해야 합니다.");
		}
	}

	public void test10()
	{
		Scanner sc = new Scanner(System.in);
		int key, kg;
		double weight;
		System.out.print("신장(cm)을 입력하세요 => ");
		key = sc.nextInt();
		System.out.print("체중(kg)을 입력하세요 => ");
		kg = sc.nextInt();
		weight = (key-100) * 0.9;			//표준체중 구하는 공식(강제 형변환)

		if (weight-1 < kg && kg < weight+1) 
			//표준체중-1 보다 크고 표준체중+1 보다 작을 때 실행
		{
			System.out.printf("표준체중은 %.1fkg입니다.\n", weight);
			System.out.println("표준체중 입니다.");
		}
		else	//조건문을 만족하지 못 하였을 때 실행
		{
			if(kg < weight-1)	//표준체중-1보다 작을 때 실행
			{
				System.out.printf("표준체중은 %.1fkg입니다.\n", weight);
				System.out.println("저체중 입니다.");
			}
			else		//위 조건들이 모두 거짓일 때 실행
			{
				System.out.printf("표준체중은 %.1fkg입니다.\n", weight);
				System.out.println("과체중입니다.");
			}
		}
	}

	public void test11()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.println("======= 심 리 테 스 트 =======");
		System.out.print("당신은 애인이 있습니까?(1.Yes 2.No)");
		select = sc.nextInt();
		if(select == 1)		//select 의 값이 1일 때 실행
		{
			System.out.print("당신은 그 애인을 사랑합니까?(1.Yes 2.No)");
			select = sc.nextInt();
			if(select == 1)		//첫번째 조건식이 1이고 두번째 조건식이 1일 경우 실행
			{
				System.out.println("당신은 애인을 많이 사랑하는군요!");
			}
			else		//첫번째 조건식이 1이고 두번째 조건식이 false 일 때 실행
			{
				System.out.println("당신은 애인을 사랑하지 않는군요!");
			}
		}
		else
		{
			System.out.print("그럼 혹시 당신의 이성이 강의실 안에 있습니까?(1.Yes 2.No)");
			select = sc.nextInt();
			if(select == 1)		//첫번째 조건식이 flase이고 두번째 조건식이 1일 경우 실행
			{
				System.out.println("이 강의실 안에 지금 있겠군요");
			}
			else				//첫번째 조건식이 flase이고 두번째 조건식이 false 일 때 실행
			{
				System.out.println("애인도 없고 강의실 안에 좋아하는 사람도 없군요");
			}
		}
	}

	public void test12()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.print("문자 입력 : ");
		ch = sc.next().charAt(0);
		System.out.println("==== 결  과 ====");
		if('a'<=ch && ch<='z')		//ch의 값이 소문자 a부터 z까지 일 때 실행
		{
			System.out.println("소문자를 입력 하였습니다.");
			System.out.printf("대문자로 변환 : %c", ch^32);
		}
		else if('A' <=ch && ch <='Z')		//ch의 값이 대문자 A부터 Z까지 일 때 실행
		{
			System.out.println("대문자를 입력 하였습니다.");
			System.out.printf("소문자로 변환", ch^32);
		}
		else		//위의 두 조건이 거짓일 때 실행
		{
			System.out.println("잘못 입력하셨습니다. 영문자를 입력해주세요.");
		}
	}

	public void test13()
	{
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("정수 입력 : ");
		num = sc.nextInt();

		if(num != 0)		//num의 값이 0이 아닐 때 실행
		{
			if(num%3==0 && num%4==0)	//num의 값이 0이 아니고 3과 4의 배수 일 때 실행
			{
				System.out.printf("[%d]은(는) 3의 배수 이면서, 4의 배수입니다."
						, num);
			}
			else if(num%3==0)		//num의 값이 0이 아니고 3의 배수 일 때 실행
			{
				System.out.printf("[%d]은(는) 3의 배수입니다.", num);
			}
			else if(num%4==0)		//num의 값이 0이 아니고 4의 배수 일 때 실행
			{
				System.out.printf("[%d]은(는) 4의 배수입니다.", num);
			}
			else		//num의 값이 0이 아닐 때 실행
			{
				System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.", num);
			}
		}
		else		//num의 값이 0일 때 실행
		{
			System.out.println("0은(는) 3의 배수도 4의 배수도 아닙니다.");
		}
	}

	public void test14()
	{
		Scanner sc = new Scanner(System.in);
		int key, kg;
		double bmi;
		System.out.print("키를 입력하세요 : ");
		key = sc.nextInt();
		System.out.print("몸무게를 입력하세요 : ");
		kg = sc.nextInt();
		bmi = kg / ((key*0.01)*(key*0.01));		//bmi 구하는 공식

		if(18.5<=bmi && bmi<23)		//bmi의 값이 18.5 이상 23 미만 일 때 실행
		{
			System.out.println("정상체중");
		}
		else if(23<=bmi && bmi<25)		//bmi의 값이 23이상 25 미만 일 때 실행
		{
			System.out.println("과체중");
		}
		else if(25<=bmi && bmi<30)		//bmi의 값이 25이상 30 미만 일 때 실행
		{
			System.out.println("비만");
		}
		else if(30<=bmi)		//bmi의 값이 30이상 일 때 실행
		{
			System.out.println("고도비만");
		}
		else		//위의 조건들이 다 flase 일 때 실행
		{
			System.out.println("저체중");
		}
	}

}
