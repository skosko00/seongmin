package kh.com.java;

import java.util.Scanner;

public class Test {
	public void test1()
	{
		for (int i=1; i<=5; i++)	//i가 1부터 5랑 같을 때 까지 반복
		{
			System.out.println("안녕하세요");
		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.print("몇번을 출력하시겠습니까?");
		int su = sc.nextInt();
		for(int i=1; i<=su; i++)	//i가 1부터 입력 받은 su랑 같을 때 까지 반복
		{
			System.out.println("안녕하세요");
		}
	}

	public void test3()
	{
		for(int i=1; i<=9;i++)		//i가 1부터 9까지 같을 때 까지 반복
		{
			System.out.println("2 * " +i+ " =" + (2*i));
		}
	}

	public void test4()
	{
		int firstNum;
		Scanner sc = new Scanner(System.in);
		System.out.print("구구단 단수를 입력하세요 : ");
		firstNum = sc.nextInt();
		for(int i=1; i<=9; i++) {		//i가 1부터 9랑 같을 때 까지 반복
			System.out.printf("%d * %d = %d \n", firstNum, i ,firstNum*i);	
		}
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int su, i, sum=0;
		for(i=0; i<5;i++) {		//i가 0부터 5보다 작을 때 까지 반복(4랑 같을 때 까지 반복)
			System.out.print("정수값을 입력하시오 : ");
			su = sc.nextInt();
			sum +=su;
		}
		System.out.printf("입력한 %d개의 정수의 합 : %d", i, sum);

	}

	public void test6()
	{
		int sum=0;
		for(int i=1; i<=100; i++)		//i가 1부터 100과 같을 때 깢까지 반복
		{
			if(i%2==0) 		//i를 2로 나누어 나머지 값이 0일 때만 실행
			{
				sum += i;
			}
		}
		System.out.println("짝수들만의 합은 : "+ sum);
	}

	public void test7() 
	{
		Scanner sc = new Scanner(System.in);
		int su, sum=0;
		System.out.print("n의 수를 입력 : ");
		su = sc.nextInt();
		for (int i=1; i<=su; i++)		//i가 1부터 입력받은 su와 같을 때 까지 반복
		{
			if(i%2==0)					//i를 2로 나눠 나온 나머지의 값이 0일 경우만 실행
			{
				sum += i;
			}
		}
		System.out.println("짝수들만의 합은 : "+sum);
	}

	public void test8()
	{
		Scanner sc = new Scanner(System.in);
		int firstNum, secondNum, sum=0;
		System.out.print("첫번째 수 입력 : ");
		firstNum = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		secondNum = sc.nextInt();
		int num1 = firstNum;
		int num2 = secondNum;


		if(firstNum<=secondNum) 		//firstNum이 secondNum 보다 작거나 클 때 실행
		{

			for( ;firstNum<=secondNum; firstNum++)	//firstNum이 secondNum 보다 작거나 클 때 까지 반복
			{
				sum += firstNum;
			}
		}
		else						//첫번째의 if조건이 맞지 않을 경우 실행
		{
			for(;firstNum>=secondNum; secondNum++)	//secondNum이 firstNum 보다 작거나 클 때 까지 반복
			{
				sum += secondNum;
			}
		}
		System.out.printf("%d ~ %d 까지의 합 : %d",num1,num2,sum);
	}

	public void test9()
	{
		Scanner sc = new Scanner(System.in);
		int firstNum, secondNum, num1, num2, sum=0, count=0;
		double avg;
		System.out.print("첫번째 정수를 입력하세요 : ");
		firstNum = sc.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		secondNum = sc.nextInt();
		num1 = firstNum;
		num2 = secondNum;
		if(firstNum<=secondNum)		//firstNum이 secondNum 보다 작거나 클 때 실행
		{
			for(;firstNum<=secondNum;firstNum++)	//firstNum이 secondNum 보다 작거나 클 때 까지 반복
			{
				if(firstNum%3==0 || firstNum%5==0)		//firstNum이 3또는 5로 나눈 나머지값이 0 일 때 실행
				{
					sum += firstNum;
					count++;
				}
			}
		}
		else		//첫번째의 if조건이 맞지 않을 경우 실행
		{
			for(;firstNum>=secondNum;secondNum++)		//secondNum이 firstNum 보다 작거나 클 때 까지 반복
			{
				if(secondNum%3==0 || secondNum%5==0)	//secondNum이 3또는 5로 나눈 나머지값이 0 일 때 실행
				{
					sum += secondNum;
					count++;
				}
			}
		}
		System.out.printf("%d ~ %d 합 : %d 평균 : %.1f", num1, num2, sum, (double)sum/count);		
	}

	public void test10()
	{
		Scanner sc= new Scanner(System.in);
		int choiceMenu, amount, total=0;
		String menuName="";
		char ch;
		do {				//do while 문은 처음 한 번 실행
			System.out.println("======김밥류========");
			System.out.println("1.원조김밥======1000원");
			System.out.println("1.치즈김밥======1200원");
			System.out.println("1.참치김밥======2000원");
			System.out.println("======라면류========");
			System.out.println("4.그냥라면======1000원");
			System.out.println("5.치즈라면======1000원");
			System.out.println("6.짬뽕라면======1000원");
			System.out.println("======튀김류========");
			System.out.println("7.튀김========1200원");
			System.out.println("8.순대========2500원");
			System.out.println("9.오뎅========1000원");
			System.out.println("10.음료수=======1000원");

			System.out.print("메뉴 선택 : ");
			choiceMenu = sc.nextInt();
			System.out.print("수량 : ");		
			amount = sc.nextInt();
			if(1<=choiceMenu || choiceMenu<=10)		//choiceMenu가 1~10 사이 일 때 실행
			{
				switch(choiceMenu)
				{
				case 1:
					menuName = "원조김밥";
					total += 1000 * amount;
					break;
				case 2:
					menuName = "치즈김밥";
					total += 1200 * amount;
					break;
				case 3:
					menuName = "참치김밥";
					total += 2000 * amount;
					break;
				case 4:
					menuName = "그냥라면";
					total += 1000 * amount;
					break;
				case 5:
					menuName = "치즈라면";
					total += 1000 * amount;
					break;
				case 6:
					menuName = "짬뽕라면";
					total += 1000 * amount;
					break;
				case 7:
					menuName = "튀김";
					total += 1200 * amount;
					break;
				case 8:
					menuName = "순대";
					total += 2500 * amount;
					break;
				case 9:
					menuName = "오뎅";
					total += 1000 * amount;
					break;
				default :
					menuName = "음료수";
					total += 1000 * amount;
					break;
				}		
			}
			else	//if문의 조건값이 맞지 않을 경우 실행
			{
				System.out.println("잘못누르셨습니다. 종료합니다.");
				return;
			}
			System.out.printf("%s을 %d개 주문하셨습니다.\n",menuName,amount);
			System.out.print("추가 주문 하시겠습니까? <y/n> : ");
			ch = sc.next().charAt(0);
		}while(ch=='y');	//ch의 값이 y일 경우 반복
		System.out.println("지불하실 금액은 총 " +total+ "원 입니다.");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
