package kh.com.java;

import java.util.Scanner;

public class Test {
	public void test1()
	{
		for (int i=1; i<=5; i++)	//i�� 1���� 5�� ���� �� ���� �ݺ�
		{
			System.out.println("�ȳ��ϼ���");
		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in); 
		System.out.print("����� ����Ͻðڽ��ϱ�?");
		int su = sc.nextInt();
		for(int i=1; i<=su; i++)	//i�� 1���� �Է� ���� su�� ���� �� ���� �ݺ�
		{
			System.out.println("�ȳ��ϼ���");
		}
	}

	public void test3()
	{
		for(int i=1; i<=9;i++)		//i�� 1���� 9���� ���� �� ���� �ݺ�
		{
			System.out.println("2 * " +i+ " =" + (2*i));
		}
	}

	public void test4()
	{
		int firstNum;
		Scanner sc = new Scanner(System.in);
		System.out.print("������ �ܼ��� �Է��ϼ��� : ");
		firstNum = sc.nextInt();
		for(int i=1; i<=9; i++) {		//i�� 1���� 9�� ���� �� ���� �ݺ�
			System.out.printf("%d * %d = %d \n", firstNum, i ,firstNum*i);	
		}
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int su, i, sum=0;
		for(i=0; i<5;i++) {		//i�� 0���� 5���� ���� �� ���� �ݺ�(4�� ���� �� ���� �ݺ�)
			System.out.print("�������� �Է��Ͻÿ� : ");
			su = sc.nextInt();
			sum +=su;
		}
		System.out.printf("�Է��� %d���� ������ �� : %d", i, sum);

	}

	public void test6()
	{
		int sum=0;
		for(int i=1; i<=100; i++)		//i�� 1���� 100�� ���� �� ������ �ݺ�
		{
			if(i%2==0) 		//i�� 2�� ������ ������ ���� 0�� ���� ����
			{
				sum += i;
			}
		}
		System.out.println("¦���鸸�� ���� : "+ sum);
	}

	public void test7() 
	{
		Scanner sc = new Scanner(System.in);
		int su, sum=0;
		System.out.print("n�� ���� �Է� : ");
		su = sc.nextInt();
		for (int i=1; i<=su; i++)		//i�� 1���� �Է¹��� su�� ���� �� ���� �ݺ�
		{
			if(i%2==0)					//i�� 2�� ���� ���� �������� ���� 0�� ��츸 ����
			{
				sum += i;
			}
		}
		System.out.println("¦���鸸�� ���� : "+sum);
	}

	public void test8()
	{
		Scanner sc = new Scanner(System.in);
		int firstNum, secondNum, sum=0;
		System.out.print("ù��° �� �Է� : ");
		firstNum = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		secondNum = sc.nextInt();
		int num1 = firstNum;
		int num2 = secondNum;


		if(firstNum<=secondNum) 		//firstNum�� secondNum ���� �۰ų� Ŭ �� ����
		{

			for( ;firstNum<=secondNum; firstNum++)	//firstNum�� secondNum ���� �۰ų� Ŭ �� ���� �ݺ�
			{
				sum += firstNum;
			}
		}
		else						//ù��°�� if������ ���� ���� ��� ����
		{
			for(;firstNum>=secondNum; secondNum++)	//secondNum�� firstNum ���� �۰ų� Ŭ �� ���� �ݺ�
			{
				sum += secondNum;
			}
		}
		System.out.printf("%d ~ %d ������ �� : %d",num1,num2,sum);
	}

	public void test9()
	{
		Scanner sc = new Scanner(System.in);
		int firstNum, secondNum, num1, num2, sum=0, count=0;
		double avg;
		System.out.print("ù��° ������ �Է��ϼ��� : ");
		firstNum = sc.nextInt();
		System.out.print("�ι�° ������ �Է��ϼ��� : ");
		secondNum = sc.nextInt();
		num1 = firstNum;
		num2 = secondNum;
		if(firstNum<=secondNum)		//firstNum�� secondNum ���� �۰ų� Ŭ �� ����
		{
			for(;firstNum<=secondNum;firstNum++)	//firstNum�� secondNum ���� �۰ų� Ŭ �� ���� �ݺ�
			{
				if(firstNum%3==0 || firstNum%5==0)		//firstNum�� 3�Ǵ� 5�� ���� ���������� 0 �� �� ����
				{
					sum += firstNum;
					count++;
				}
			}
		}
		else		//ù��°�� if������ ���� ���� ��� ����
		{
			for(;firstNum>=secondNum;secondNum++)		//secondNum�� firstNum ���� �۰ų� Ŭ �� ���� �ݺ�
			{
				if(secondNum%3==0 || secondNum%5==0)	//secondNum�� 3�Ǵ� 5�� ���� ���������� 0 �� �� ����
				{
					sum += secondNum;
					count++;
				}
			}
		}
		System.out.printf("%d ~ %d �� : %d ��� : %.1f", num1, num2, sum, (double)sum/count);		
	}

	public void test10()
	{
		Scanner sc= new Scanner(System.in);
		int choiceMenu, amount, total=0;
		String menuName="";
		char ch;
		do {				//do while ���� ó�� �� �� ����
			System.out.println("======����========");
			System.out.println("1.�������======1000��");
			System.out.println("1.ġ����======1200��");
			System.out.println("1.��ġ���======2000��");
			System.out.println("======����========");
			System.out.println("4.�׳ɶ��======1000��");
			System.out.println("5.ġ����======1000��");
			System.out.println("6.«�Ͷ��======1000��");
			System.out.println("======Ƣ���========");
			System.out.println("7.Ƣ��========1200��");
			System.out.println("8.����========2500��");
			System.out.println("9.����========1000��");
			System.out.println("10.�����=======1000��");

			System.out.print("�޴� ���� : ");
			choiceMenu = sc.nextInt();
			System.out.print("���� : ");		
			amount = sc.nextInt();
			if(1<=choiceMenu || choiceMenu<=10)		//choiceMenu�� 1~10 ���� �� �� ����
			{
				switch(choiceMenu)
				{
				case 1:
					menuName = "�������";
					total += 1000 * amount;
					break;
				case 2:
					menuName = "ġ����";
					total += 1200 * amount;
					break;
				case 3:
					menuName = "��ġ���";
					total += 2000 * amount;
					break;
				case 4:
					menuName = "�׳ɶ��";
					total += 1000 * amount;
					break;
				case 5:
					menuName = "ġ����";
					total += 1000 * amount;
					break;
				case 6:
					menuName = "«�Ͷ��";
					total += 1000 * amount;
					break;
				case 7:
					menuName = "Ƣ��";
					total += 1200 * amount;
					break;
				case 8:
					menuName = "����";
					total += 2500 * amount;
					break;
				case 9:
					menuName = "����";
					total += 1000 * amount;
					break;
				default :
					menuName = "�����";
					total += 1000 * amount;
					break;
				}		
			}
			else	//if���� ���ǰ��� ���� ���� ��� ����
			{
				System.out.println("�߸������̽��ϴ�. �����մϴ�.");
				return;
			}
			System.out.printf("%s�� %d�� �ֹ��ϼ̽��ϴ�.\n",menuName,amount);
			System.out.print("�߰� �ֹ� �Ͻðڽ��ϱ�? <y/n> : ");
			ch = sc.next().charAt(0);
		}while(ch=='y');	//ch�� ���� y�� ��� �ݺ�
		System.out.println("�����Ͻ� �ݾ��� �� " +total+ "�� �Դϴ�.");

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
