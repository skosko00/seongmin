package kh.java.work;

import java.util.Scanner;

public class HomeWorkTest {
	public void test1()
	{
		Scanner sc = new Scanner(System.in);
		String fruit;
		System.out.println("������ �����ϼ���");
		System.out.println("��� , �ٳ���, ������, Ű��");
		fruit = sc.nextLine();

		switch(fruit)
		{
		case "���" :			//��� �Է½� �Ʒ��� ���๮ ����
			System.out.println("����� ������ 1000�� �Դϴ�.");
			break;
		case "�ٳ���" :		//�ٳ��� �Է½� �Ʒ��� ���๮ ����
			System.out.println("�ٳ����� ������ 3000�� �Դϴ�.");
			break;
		case "������" :		//������ �Է½� �Ʒ��� ���๮ ����
			System.out.println("�������� ������ 2000�� �Դϴ�.");
			break;
		case "Ű��" :			//Ű�� �Է½� �Ʒ��� ���๮ ����
			System.out.println("Ű���� ������ 5000�� �Դϴ�.");
			break;

		}
	}

	public void test2()
	{
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("*******�ʱ� �޴�*******");
		System.out.println("1.�Է�");
		System.out.println("2.����");
		System.out.println("3.��ȸ");
		System.out.println("4.����");
		System.out.println("0.����");
		System.out.println("********************");
		System.out.print("�޴���ȣ �Է� : ");
		num = sc.nextInt();
		switch(num)
		{
		case 1:			// 2 �Է½� �Ʒ��� ���๮ ����
			System.out.println("�Է¸޴�����");
			break;
		case 2:			// 3 �Է½� �Ʒ��� ���๮ ����
			System.out.println("�����޴�����");
			break;
		case 3:			// 4 �Է½� �Ʒ��� ���๮ ����
			System.out.println("��ȸ�޴�����");
			break;
		case 4:			// 5 �Է½� �Ʒ��� ���๮ ����
			System.out.println("�����޴�����");
			break;
		case 0:			// 0 �Է½� �Ʒ��� ���๮ ����
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:		// ���� ���ǿ� �����ϴ� ����� ���� ��� ����
			System.out.println("��ȣ�� �߸� �����̽��ϴ�.");
			break;
		}
	}

	public void test3()
	{
		int num;
		Scanner sc= new Scanner(System.in);
		System.out.println("**********��  ��**********");
		System.out.println("1. ������-------------1000");
		System.out.println("2. ���--------------2000");
		System.out.println("3. ����--------------1000");
		System.out.println("4. ����--------------2000");
		System.out.println("5. Ƣ��--------------3000");
		System.out.println("6. ��Ƣ��-------------8000");
		System.out.println("************************");
		System.out.print("�޴���ȣ �Է� : ");

		num = sc.nextInt();

		switch(num)
		{
		case 1:			// 1 �Է½� �Ʒ��� ���๮�� ����
			System.out.println("�����̴� 1000���Դϴ�.");
			break;
		case 2:			// 2 �Է½� �Ʒ��� ���๮�� ����
			System.out.println("����� 2000���Դϴ�.");
			break;
		case 3:			// 3 �Է½� �Ʒ��� ���๮�� ����
			System.out.println("������ 1000���Դϴ�.");
			break;
		case 4:			// 4 �Է½� �Ʒ��� ���๮�� ����
			System.out.println("����� 2000���Դϴ�.");
			break;
		case 5:			// 5 �Է½� �Ʒ��� ���๮�� ����
			System.out.println("Ƣ���� 3000���Դϴ�.");
			break;
		case 6:			// 6 �Է½� �Ʒ��� ���๮�� ����
			System.out.println("��Ƣ���� 8000���Դϴ�.");
			break;
		default :		// ���� ���ǿ� �����ϴ� ����� ���� ��� ����
			System.out.println("��ȣ�� �߸� �ԷµǾ����ϴ�. ������ �����մϴ�");
			return;
		}
	}

	public void test4()
	{
		Scanner sc = new Scanner(System.in);
		int num, won;
		String menu="", side="";
		char menuSelect;

		System.out.println("*********�ָ޴�*********");
		System.out.println("a.�Ұ�����----------5000");
		System.out.println("b.�������-----------4000");
		System.out.println("c.ġŲ����-----------4500");
		System.out.println("d.�ѿ����----------10000");
		System.out.println("e.�����------------7000");
		System.out.println("**********************");
		System.out.print("�޴��� �����ϼ��� : ");
		menuSelect = sc.next().charAt(0);

		switch(menuSelect)
		{
		case 'a':		//a �Է½� �Ʒ��� ���๮�� ����
			menu = "�Ұ�����";
			won = 5000;
			break;
		case 'b':		//b �Է½� �Ʒ��� ���๮�� ����
			menu = "�������";
			won = 4000;
			break;
		case 'c':		//c �Է½� �Ʒ��� ���๮�� ����
			menu = "ġŲ����";
			won = 4500;
			break;
		case 'd':		//d �Է½� �Ʒ��� ���๮�� ����
			menu = "�ѿ����";
			won = 10000;
			break;
		case 'e':		//e �Է½� �Ʒ��� ���๮�� ����
			menu = "�����";
			won = 7000;
			break;
		default:		// ���� ��������� ���� ���� ���� ��� ����
			System.out.println("��ȣ�� �߸� �����̽��ϴ�. ������ �����մϴ�");
			return;
		}
		System.out.println("*********�ָ޴�*********");
		System.out.println("1.�ݶ�--------------1500");
		System.out.println("2.���̴�-------------1500");
		System.out.println("3.��ũ����ũ----------2500");
		System.out.println("4.�����-------------3000");
		System.out.println("**********************");
		System.out.print("���̵�޴��� �����ϼ��� : ");
		num = sc.nextInt();

		switch(num)
		{
		case 1:			//1 �Է½� �Ʒ��� ���๮�� ����
			side = "�ݶ�";
			won += 1500;
			break;
		case 2:			//2 �Է½� �Ʒ��� ���๮�� ����
			side = "���̴�";
			won += 1500;
			break;
		case 3:			//3 �Է½� �Ʒ��� ���๮�� ����
			side = "��ũ����ũ";
			won += 2500;
			break;
		case 4:			//4 �Է½� �Ʒ��� ���๮�� ����
			side = "�����";
			won += 3000;
			break;
		default:		// ���� ��������� ���� ���� ���� ����
			System.out.println("��ȣ�� �߸� �����̽��ϴ�. ������ �����մϴ�.");
			return;
		}
		System.out.printf("%s, %s�� �� %d���Դϴ�.", menu, side, won);
	}

	public void test5()
	{
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.print("�ϼ��� �˰� ���� ���� �Է��Ͻÿ� : ");
		month = sc.nextInt();
		if(1<=month && month<=12) {			//month�� ���� 1~12 ������ ��� ����
			switch(month)
			{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:		// break���� ��� month�� ���� 1,3,5,6,7,10,12 �� ��� �Ʒ��� �ڵ尡 ����
				System.out.println(month + "������ 31�ϼ��Դϴ�.");
				break;

			case 2:			// month�� ���� 2�� �� ����
				System.out.println(month + "������ 28�ϼ��Դϴ�.");
				break;

			case 4:
			case 6:
			case 9:
			case 11:		// month�� ���� 4, 6, 9, 11 �� �� �Ʒ��� �ڵ尡 ����
				System.out.println(month + "������ 30�ϼ��Դϴ�.");
				break;
			}
		}
		else		// month�� ���� 1~12�� ���� ���� �� ����
		{
			System.out.println("���� �߸� �Է��ϼ̽��ϴ�.");
		}
	}

	public void test6()
	{
		Scanner sc = new Scanner(System.in);
		char grade;
		System.out.println("���б� ���� �ý��� �Դϴ�.");
		System.out.println("�л� ������ �Է����ּ���");
		System.out.print("(A����, B����, C����, D����, F����)");
		grade = sc.next().charAt(0);
		switch(grade)
		{
		case 'A':		//A�� �Է� �Ǿ��� �ÿ� �Ʒ��� ���๮�� ����
			System.out.println("�����ϼ̽��ϴ�. ���б��� 100% �����ص帮�ڽ��ϴ�.");
			break;
		case 'B':		//B�� �Է� �Ǿ��� �ÿ� �Ʒ��� ���๮�� ����
			System.out.println("�����ϼ̽��ϴ�. ���б��� 50% �����ص帮�ڽ��ϴ�.");
			break;
		case 'C':		//C�� �Է� �Ǿ��� �ÿ� �Ʒ��� ���๮�� ����
			System.out.println("�̹� �б� ���б��� ���׿�.. ��������");
			break;
		case 'D':		//D�� �Է� �Ǿ��� �ÿ� �Ʒ��� ���๮�� ����
			System.out.println("���бݺ��ٴ� �а�� ���ϼ̳׿�..����ϼ���");
			break;
		case 'F':		//F�� �Է� �Ǿ��� �ÿ� �Ʒ��� ���๮�� ����
			System.out.println("�̹��б� ���б����� �а� �����̽��ϴ�. 3Go�Ͻ� ����");
			break;			
		}
	}

	public void test7()
	{
		char oper;
		int num1, num2;
		Scanner sc = new Scanner(System.in);

		System.out.println("=== ���� ���α׷� ===\n");
		System.out.print("������ �Է�(+, -, *, /) : ");
		oper = sc.next().charAt(0);
		System.out.print("ù��° ���� �Է� : ");
		num1 = sc.nextInt();
		System.out.print("�ι�° ���� �Է� : ");
		num2 = sc.nextInt();
		System.out.println("====== �� �� ======");
		if(oper == '+' || oper == '-' || oper == '*' || oper == '/')
			// oper�� ���� +, -, *, /�� �Է� �� �� ����
		{
			switch(oper)
			{
			case '+':	// + �� ��� ����
				System.out.printf("%d + %d = %d", num1, num2, num1+num2);
				break;
			case '-':	// - �� ��� ����
				System.out.printf("%d - %d = %d", num1, num2, num1-num2);
				break;
			case '*':	// * �� ��� ����
				System.out.printf("%d * %d = %d", num1, num2, num1*num2);
				break;
			case '/':	// / �� ��� ����
				System.out.printf("%d / %d = %.1f", num1, num2, (double)num1/num2);
				break;
			}
		}
		else		// oper�� ���� +, -, *, / �� �ƴҰ�� ����
		{
			System.out.println("�߸��� ������ �Դϴ�.");
		}
	}

	public void test8()
	{
		Scanner sc = new Scanner(System.in);
		int score;
		System.out.print("���� �Է� : ");
		score = sc.nextInt();

		if(0<=score && score<=100)		//0~100 ������ score ������ �Է� �� ��� ����
		{	
			switch(score/10)		// case�� ����� ���� ���Ƽ� 10�� �����Ŀ� ó��
			{
			case 10:		
			case 9:					//90~ 100 ���̴� �Ʒ��� �ڵ带 ����
				System.out.println("A���");
				break;
			case 8:					//80~ 90 ���̴� �Ʒ��� �ڵ带 ����
				System.out.println("B���");
				break;
			case 7:					//70~ 80 ���̴� �Ʒ��� �ڵ带 ����
				System.out.println("C���");
				break;
			case 6:					//60~ 70 ���̴� �Ʒ��� �ڵ带 ����
				System.out.println("D���");
				break;
			default :				//60�̸��� �Ʒ��� �ڵ带 ����
				System.out.println("F���");
				break;
			}
		}
		else			//0~100 ������ score ������ �Էµ��� �ʾ��� ��� ����
		{
			System.out.println("�߸��� �Է�(0~100���� �Է�)");
		}
	}

	public void test9()
	{
		int i = 0;
		while(i<5)	//i�� 0���� 5���� ���� �� ���� �ݺ�
		{
			i++;
			System.out.println("�ȳ��ϼ���");
		}
	}
	
	public void test10()
	{
		Scanner sc = new Scanner(System.in);
		int x=0, y;
		System.out.print("����� ��� �Ͻðڽ��ϱ�?");
		y = sc.nextInt();
		
		while(x<y)		//x�� y���� ���� �� ���
		{
			System.out.println("�ȳ��ϼ���");
			x++;		//x�� ���� ����
		}
	}
	
	public void test11()
	{
		int i = 0;
		System.out.println("2���Դϴ�.");
		while(i<9)		//i�� 0���� 9���� ���� �� ���� ����
		{
			i++;
			System.out.printf("2 * %d = %d \n", i, 2*i);
		}
	}
	
	public void test12()
	{
		Scanner sc = new Scanner(System.in);
		int x, y = 0;
		System.out.print("����� ����Ͻðڽ��ϱ�?");
		x = sc.nextInt();
		System.out.println(x + "�� �Դϴ�.");
		while(y <= 8)		//y�� 0���� 8�� ���� �� ���� ����
		{
			y++;
			System.out.printf("%d * %d = %d \n", x, y, x*y);
		}
	}
	
	public void test13()
	{
		Scanner sc = new Scanner(System.in);
		int i = 0, sum = 0;
		while(i<5)		//i�� 0���� 5���� ���� �� ���� ����
		{
			i++;
			System.out.print("�������� �Է��Ͻÿ� : ");
			sum += sc.nextInt();	//sum = sum + �Է¹��� ��
		}
		System.out.println("�Է��� " + i + "���� ������ �� : " + sum);
	}
}
