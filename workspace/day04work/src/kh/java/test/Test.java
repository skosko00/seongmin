package kh.java.test;

import java.util.Scanner;

public class Test {
	public void test1()
	{
		Scanner sc = new Scanner(System.in);	//Scanner Ŭ������ ���� sc�� ġȯ
		int num;
		System.out.print("������ ���� �Է��ϼ��� : ");
		num = sc.nextInt();		//num ������ Ű����� ���� �Է� ����
		if(num>0)		//num�� 0���� Ŭ ��
		{
			System.out.println("����� �Է��� �� " + num + "�� ����Դϴ�.");
		}
		if(num==0)		//num�� 0�̶� ���� ��
		{
			System.out.println("����� �Է��� ��" + num + "�� 0�Դϴ�.");
		}
		if(num<0)		//num�� 0���� ���� ��
		{
			System.out.println("����� �Է��� �� " + num + "�� �����Դϴ�.");
		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in);	//Scanner Ŭ������ ���� sc�� ġȯ
		int firstNum, secondNum;
		System.out.print("ù��° ���� �Է� �ϼ��� : ");
		firstNum = sc.nextInt();				//firstNum ������ Ű����� ���� �Է� ����
		System.out.print("�ι�° ���� �Է� �ϼ��� : ");
		secondNum = sc.nextInt();				//secondNum ������ Ű����� ���� �Է� ����

		if(firstNum > secondNum)				//firstNum�� secondNum���� Ŭ ��
		{
			System.out.println(firstNum + " > " + secondNum);
			System.out.println("ù��° ���� �� Ů�ϴ�.");
		}
		if(firstNum == secondNum)				//firstNum�� secondNum�� ���� ��
		{
			System.out.println(firstNum + " = " + secondNum);
			System.out.println("�� ���� ���� �� �Դϴ�.");
		}
		if(firstNum < secondNum)				//firstNum�� secondNum���� ���� ��
		{
			System.out.println(firstNum + " < " + secondNum);
			System.out.println("�ι�° ���� �� Ů�ϴ�.");
		}
	}

	public void test3()
	{
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char ch;
		System.out.println("���� ���α׷� ver1.0");
		System.out.print("�����ڸ� �Է��ϼ���(+,-,*,/) : ");
		ch = sc.next().charAt(0);		//ch ������ ù���ڸ� �Է� ����
		System.out.print("ù��° �� �Է� : ");
		num1 = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		num2 = sc.nextInt();

		if (ch == '+')					//ch ������ ����� ù ���� ���� + �� ��
		{
			System.out.printf("%d+%d=%d", num1, num2, num1+num2);
		}
		if (ch == '-')					//ch ������ ����� ù ���� ���� - �� ��
		{
			System.out.printf("%d-%d=%d", num1, num2, num1-num2);
		}
		if (ch == '*')					//ch ������ ����� ù ���� ���� * �� ��
		{
			System.out.printf("%d*%d=%d", num1, num2, num1*num2);			
		}
		if (ch == '/')					//ch ������ ����� ù ���� ���� / �� ��
		{
			System.out.printf("%d/%d=%.16f", num1, num2, (double)num1/num2);
		}											//(double)������ ���� ����ȯ
	}

	public void test4()
	{
		Scanner sc = new Scanner(System.in);
		int total, adult, kid;
		System.out.println("���� ���� ���α׷� v1.0");
		System.out.print("���� �Ͻ� �ο��� �� ����Դϱ�?");
		total = sc.nextInt();
		System.out.print("��� ����Դϱ�?(�ο��� 1��5õ��)");
		adult = sc.nextInt();
		System.out.print("���̴� ����Դϱ�?(�ο��� 5õ��)");
		kid = sc.nextInt();

		if(total == adult+kid)					//�Է� ���� total ���̶� adult+kid ���� ���� ��
		{
			adult *= 15000;						//adult ���� *15000�� �Ͽ� adult�� ����
			kid *= 5000;						//kid ���� *5000�� �Ͽ� adult�� ����
			System.out.printf("�����Ͻ� �� �ݾ��� %d�� �Դϴ�.", adult+kid);
		}
		else									//���� ������ ������ ��
		{
			System.out.println("�����Ͻ� �ο��� ���� �ʽ��ϴ�.");
		}
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int choice, count=0;
		System.out.println("ù��° �����Դϴ�.");
		System.out.print("����� ����� �����ϱ��?(1.Apple / 2.�⽺)");
		choice = sc.nextInt();
		if(choice == 1)				//choice ������ ��� �� ���� 1�� �� ����
		{
			System.out.println("����!!");
			count++;				//������ ��� 0���� 1�� ����
		}
		else						//���� ���ǽĿ��� false�� ��� ����
		{
			System.out.println("��!");
		}
		System.out.print("�ٳ����� ��� ������ ���� ������?(1.���� 2.���)");
		choice = sc.nextInt();
		if(choice == 1)				//choice ������ ��� �� ���� 1�� �� ����
		{
			System.out.println("����!!");
			count++;				//������ ��� 0���� 1�� ����
		}
		else						//���� ���ǽĿ��� false�� ��� ����
		{
			System.out.println("��!");
		}
		System.out.printf("�� %d ������ ���߼̽��ϴ�.",count );  //�� ī��Ʈ �� ���ڰ� ���
	}

	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		String name;
		int grade, group, num;
		char sex;
		double avg;

		System.out.print("�л� �̸� : ");
		name = sc.nextLine();
		System.out.print("�г� : ");
		grade = sc.nextInt();
		System.out.print("�� : ");
		group = sc.nextInt();
		System.out.print("��ȣ : ");
		num = sc.nextInt();
		System.out.print("���� : (���л��� M ���л��� F)");
		sex = sc.next().charAt(0);		//sex ������ ���ڸ� �Է¹���
		System.out.print("���� : ");
		avg = sc.nextDouble();

		if(sex == 'M')		//sex������ �Է� ���� ���� M�� ��� ����
		{
			System.out.printf("%d�г� %d�� %d�� ���л� %s�� ������ %.2f�̴�."
					,grade, group, num, name, avg);		//�Ҽ��� 2°�ڸ� ���� ���
		}
		else				//if���� ���� false�� ��쿡 ����
		{
			System.out.printf("%d�г� %d�� %d�� ���л� %s�� ������ %.2f�̴�"
					,grade, group, num, name, avg);		//�Ҽ��� 2°�ڸ� ���� ���
		}
	}

	public void test7()
	{
		Scanner sc = new Scanner(System.in);

		int kor, eng, math, sum;
		double avg;

		System.out.print("���� ������ �Է��ϼ��� : ");
		kor = sc.nextInt();
		System.out.print("���� ������ �Է��ϼ��� : ");
		eng = sc.nextInt();
		System.out.print("���� ������ �Է��ϼ��� : ");
		math = sc.nextInt();

		sum = kor + eng + math;
		avg = sum / 3.0;

		if (40 <= kor && 40 <= eng && 40 <= math && 60 <= avg)
			//kor, eng, math ������ �Է� ���� ���� ���� 40 �̻��� ��� �׸��� avg�� ���� 60�̻��� ��� ����
		{
			System.out.println("�հ��Դϴ�.");
		}
		else	//���� ������ �������� �� �� �� ����
		{
			System.out.println("���հ��Դϴ�.");
		}
	}

	public void test8()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.print("����� ���� �����Ͻʴϱ�?(1.yes2.no)");
		select = sc.nextInt();
		if(select == 1)		//select�� ���� 1�� ��� ����
		{
			System.out.print("����� ��踦 �ǿ�ϱ�?(1.yes 2.no)");
			select = sc.nextInt();
			if(select == 1)		//ù��° ���ǽ��� 1�̰� �ι�° ���ǽ��� 1�� ��� ����
			{
				System.out.println("���� �ǰ��� ���� �ʽ��ϴ�!!!");
			}
			else				//ù��° ���ǽ��� 1�̰� �ι�° ���ǽ��� false �� �� ����
			{
				System.out.println("��踦 �ǿ��� �ʾƵ� �� ������ ���� �����ؿ�!");
			}
		}
		else
		{
			System.out.print("����� �̼�ģ���� �ֽ��ϱ�?(1.yes,2.no)");
			select = sc.nextInt();
			if(select == 1)		//ù��° ���ǽ��� flase�̰� �ι�° ���ǽ��� 1�� ��� ����
			{
				System.out.println("��..........");
			}
			else				//ù��° ���ǽ��� flase�̰� �ι�° ���ǽ��� false �� �� ����
			{
				System.out.println("...��������.. ���������� ��ó���..?");
			}
		}
	}

	public void test9()
	{
		Scanner sc = new Scanner(System.in);
		int num;

		System.out.print("1~10 ������ ������ �Է� �ϼ��� : ");
		num = sc.nextInt();
		if(0 < num && num < 11)		//num�� ���� 1 �̻� 10 ���� �� ��쿡 ����
		{
			if(num%2 == 0)		//ù��° ���ǹ��� �����ϰ� num�� ���� 2�� ������ ���������� 0�� �� ����
			{
				System.out.println("¦����.");
			}
			else				//ù��° ���ǹ��� �����ϰ� false�� �� ����
			{
				System.out.println("Ȧ����.");
			}
		}
		else			//���ǹ��� false �� �� ����
		{
			System.out.println("�ݵ�� 1~10������ ������ �Է��ؾ� �մϴ�.");
		}
	}

	public void test10()
	{
		Scanner sc = new Scanner(System.in);
		int key, kg;
		double weight;
		System.out.print("����(cm)�� �Է��ϼ��� => ");
		key = sc.nextInt();
		System.out.print("ü��(kg)�� �Է��ϼ��� => ");
		kg = sc.nextInt();
		weight = (key-100) * 0.9;			//ǥ��ü�� ���ϴ� ����(���� ����ȯ)

		if (weight-1 < kg && kg < weight+1) 
			//ǥ��ü��-1 ���� ũ�� ǥ��ü��+1 ���� ���� �� ����
		{
			System.out.printf("ǥ��ü���� %.1fkg�Դϴ�.\n", weight);
			System.out.println("ǥ��ü�� �Դϴ�.");
		}
		else	//���ǹ��� �������� �� �Ͽ��� �� ����
		{
			if(kg < weight-1)	//ǥ��ü��-1���� ���� �� ����
			{
				System.out.printf("ǥ��ü���� %.1fkg�Դϴ�.\n", weight);
				System.out.println("��ü�� �Դϴ�.");
			}
			else		//�� ���ǵ��� ��� ������ �� ����
			{
				System.out.printf("ǥ��ü���� %.1fkg�Դϴ�.\n", weight);
				System.out.println("��ü���Դϴ�.");
			}
		}
	}

	public void test11()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.println("======= �� �� �� �� Ʈ =======");
		System.out.print("����� ������ �ֽ��ϱ�?(1.Yes 2.No)");
		select = sc.nextInt();
		if(select == 1)		//select �� ���� 1�� �� ����
		{
			System.out.print("����� �� ������ ����մϱ�?(1.Yes 2.No)");
			select = sc.nextInt();
			if(select == 1)		//ù��° ���ǽ��� 1�̰� �ι�° ���ǽ��� 1�� ��� ����
			{
				System.out.println("����� ������ ���� ����ϴ±���!");
			}
			else		//ù��° ���ǽ��� 1�̰� �ι�° ���ǽ��� false �� �� ����
			{
				System.out.println("����� ������ ������� �ʴ±���!");
			}
		}
		else
		{
			System.out.print("�׷� Ȥ�� ����� �̼��� ���ǽ� �ȿ� �ֽ��ϱ�?(1.Yes 2.No)");
			select = sc.nextInt();
			if(select == 1)		//ù��° ���ǽ��� flase�̰� �ι�° ���ǽ��� 1�� ��� ����
			{
				System.out.println("�� ���ǽ� �ȿ� ���� �ְڱ���");
			}
			else				//ù��° ���ǽ��� flase�̰� �ι�° ���ǽ��� false �� �� ����
			{
				System.out.println("���ε� ���� ���ǽ� �ȿ� �����ϴ� ����� ������");
			}
		}
	}

	public void test12()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.print("���� �Է� : ");
		ch = sc.next().charAt(0);
		System.out.println("==== ��  �� ====");
		if('a'<=ch && ch<='z')		//ch�� ���� �ҹ��� a���� z���� �� �� ����
		{
			System.out.println("�ҹ��ڸ� �Է� �Ͽ����ϴ�.");
			System.out.printf("�빮�ڷ� ��ȯ : %c", ch^32);
		}
		else if('A' <=ch && ch <='Z')		//ch�� ���� �빮�� A���� Z���� �� �� ����
		{
			System.out.println("�빮�ڸ� �Է� �Ͽ����ϴ�.");
			System.out.printf("�ҹ��ڷ� ��ȯ", ch^32);
		}
		else		//���� �� ������ ������ �� ����
		{
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �����ڸ� �Է����ּ���.");
		}
	}

	public void test13()
	{
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("���� �Է� : ");
		num = sc.nextInt();

		if(num != 0)		//num�� ���� 0�� �ƴ� �� ����
		{
			if(num%3==0 && num%4==0)	//num�� ���� 0�� �ƴϰ� 3�� 4�� ��� �� �� ����
			{
				System.out.printf("[%d]��(��) 3�� ��� �̸鼭, 4�� ����Դϴ�."
						, num);
			}
			else if(num%3==0)		//num�� ���� 0�� �ƴϰ� 3�� ��� �� �� ����
			{
				System.out.printf("[%d]��(��) 3�� ����Դϴ�.", num);
			}
			else if(num%4==0)		//num�� ���� 0�� �ƴϰ� 4�� ��� �� �� ����
			{
				System.out.printf("[%d]��(��) 4�� ����Դϴ�.", num);
			}
			else		//num�� ���� 0�� �ƴ� �� ����
			{
				System.out.printf("[%d]��(��) 3�� ����� 4�� ����� �ƴմϴ�.", num);
			}
		}
		else		//num�� ���� 0�� �� ����
		{
			System.out.println("0��(��) 3�� ����� 4�� ����� �ƴմϴ�.");
		}
	}

	public void test14()
	{
		Scanner sc = new Scanner(System.in);
		int key, kg;
		double bmi;
		System.out.print("Ű�� �Է��ϼ��� : ");
		key = sc.nextInt();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		kg = sc.nextInt();
		bmi = kg / ((key*0.01)*(key*0.01));		//bmi ���ϴ� ����

		if(18.5<=bmi && bmi<23)		//bmi�� ���� 18.5 �̻� 23 �̸� �� �� ����
		{
			System.out.println("����ü��");
		}
		else if(23<=bmi && bmi<25)		//bmi�� ���� 23�̻� 25 �̸� �� �� ����
		{
			System.out.println("��ü��");
		}
		else if(25<=bmi && bmi<30)		//bmi�� ���� 25�̻� 30 �̸� �� �� ����
		{
			System.out.println("��");
		}
		else if(30<=bmi)		//bmi�� ���� 30�̻� �� �� ����
		{
			System.out.println("����");
		}
		else		//���� ���ǵ��� �� flase �� �� ����
		{
			System.out.println("��ü��");
		}
	}

}
