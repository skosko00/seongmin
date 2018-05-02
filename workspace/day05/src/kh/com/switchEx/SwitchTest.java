package kh.com.switchEx;

import java.util.Scanner;

public class SwitchTest {
	public void switchTest1()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.print("1~3���� ���� �Է� : ");
		select = sc.nextInt();
		switch(select)
		{
		case 1:
			System.out.println("1�� �Է��Ͽ����ϴ�.");
			break;
		case 2:
			System.out.println("2�� �Է��Ͽ����ϴ�.");
			break;
		case 3:
			System.out.println("3�� �Է��Ͽ����ϴ�.");
			break;
		default :
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
		}
	}

	public void switchTest2()
	{
		Scanner sc = new Scanner(System.in);
		String menu;
		System.out.print("\"���\", \"�ٳ���\", \"������\", \"Ű��\" �����ϼ��� : ");
		menu = sc.nextLine();

		switch(menu)
		{
		case "���" :
			System.out.println("��� - 1000��");
			break;
		case "�ٳ���" :
			System.out.println("�ٳ��� - 3000��");
			break;
		case "������" :
			System.out.println("������ - 2000��");
			break;
		case "Ű��" :
			System.out.println("Ű�� - 5000��");
			break;
		default :
			System.out.println("�����Ͻ� ������ �޴��� �����ϴ�.");
		}
	}

	public void switchTest3()
	{
		Scanner sc = new Scanner(System.in);
		int select;
		System.out.println("*******�ʱ� �޴�*******");
		System.out.println("1.�Է� \n2.���� \n3.��ȸ \n4.���� \n0.����");	
		System.out.println("********************");
		System.out.println("�޴���ȣ �Է� : '��ȣ�Է�'");
		select = sc.nextInt();

		switch(select)
		{
		case 1 :
			System.out.println("�Է¸޴�����");
			break;
		case 2 :
			System.out.println("�����޴�����");
			break;
		case 3 :
			System.out.println("��ȸ�޴�����");
			break;
		case 4 :
			System.out.println("�����޴�����");
			break;
		case 0 :
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default :
			System.out.println("��ȣ�� �߸� �����̽��ϴ�.");
		}
	}

	public void switchTest4()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		String menu = "", side = "";
		int num, won;
		System.out.println("*********�ָ޴�*********");
		System.out.println("a.�Ұ�����----------5000");
		System.out.println("b.�������-----------4000");
		System.out.println("c.ġŲ����-----------4500");
		System.out.println("d.�ѿ����----------10000");
		System.out.println("e.�����------------7000");
		System.out.println("**********************");
		System.out.print("�޴��� �����ϼ��� : ");
		ch = sc.next().charAt(0);

		switch(ch)
		{
		case 'a' :
			menu = "�Ұ�����";
			won = 5000;
			break;
		case 'b' :
			menu = "�������";
			won = 4000;
			break;
		case 'c':
			menu = "ġŲ����";
			won = 4500;
			break;
		case 'd':
			menu = "�ѿ����";
			won = 10000;
			break;
		case 'e':
			menu = "�����";
			won = 7000;
			break;
		default :
			System.out.println("��ȣ�� �߸� �����̽��ϴ�. ������ �����մϴ�.");
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
		case 1 :
			side = "�ݶ�";
			won += 1500;
			break;
		case 2 :
			side = "���̴�";
			won += 1500;
			break;
		case 3:
			side = "��ũ����ũ";
			won += 2500;
			break;
		case 4:
			side = "�����";
			won += 3000;
			break;
		default :
			System.out.println("��ȣ�� �߸� �����̽��ϴ�. ������ �����մϴ�.");
			return;			
		}
		System.out.printf("%s, %s��(��) �� %d�� �Դϴ�.",menu, side, won);
	}

	public void switchTest5()
	{
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.print("�ϼ��� �˰� ���� ���� �Է��Ͻÿ� : ");
		month = sc.nextInt();

		if(1<=month && month<=12) {
			switch(month)
			{
			case 2:
				System.out.println(month + "�� ���� 28�� �� �Դϴ�.");
				break;

			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println(month + "�� ���� 30�� �� �Դϴ�.");
				break;

			default :
				System.out.println(month + "�� ���� 31�� �� �Դϴ�.");
				break;

			}
		}
		else
		{
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
		}
	}

	public void switchTest6()
	{
		Scanner sc = new Scanner(System.in);

		System.out.println("===���� ���α׷�===");
		int num1, num2;
		char oper;
		System.out.print("������ �Է� (+, -, *, /) : ");
		oper = sc.next().charAt(0);
		if(oper =='+' || oper =='-' || oper =='*' || oper =='/')
		{
			System.out.print("ù ��° ���� �Է� : ");
			num1 = sc.nextInt();
			System.out.print("�� ��° ���� �Է� : ");
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
				System.out.println("�߸��� ������ �Դϴ�.");
				break;
			}
		}
		else
		{
			System.out.println("�߸� �Է��ϼ̽��ϴ�" + oper + "�� ���� �� �� �����ϴ�.");
		}
	}


}
