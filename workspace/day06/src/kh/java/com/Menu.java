package kh.java.com;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menu, choice, num=0;
		int value=0, total=0;
		char ch;
		String menuName="";
		do {
			System.out.println("����==================");
			System.out.println("1.�������==========1000��");
			System.out.println("2.ġ����==========1200��");
			System.out.println("3.��ġ���==========2000��");
			System.out.println("���====================");
			System.out.println("4.�׳ɶ��==========1200��");
			System.out.println("5.ġ����==========1500��");
			System.out.println("6.«�Ͷ��==========2000��");
			System.out.println("��Ÿ=====================");
			System.out.println("7.Ƣ��=============2000��");
			System.out.println("8.����=============2000��");
			System.out.println("9.����=============2000��");
			System.out.println("10.�����===========2000��");

			System.out.print("�޴����� : ");
			menu = sc.nextInt();
			if(1<=menu && menu<=10)
			{
				switch(menu)
				{
				case 1:
					menuName = "�������";
					value = 1000;
					break;
				case 2:
					menuName = "ġ����";
					value = 1200;
					break;
				case 3:
					menuName = "��ġ���";
					value = 2000;
					break;
				case 4:
					menuName = "�׳ɶ��";
					value = 1200;
					break;
				case 5:
					menuName = "ġ����";
					value = 1500;
					break;
				case 6:
					menuName = "«�Ͷ��";
					value = 2000;
					break;
				case 7:
					menuName = "Ƣ��";
					value = 2000;
					break;
				case 8:
					menuName = "����";
					value = 2000;
					break;
				case 9:
					menuName = "����";
					value = 2000;
					break;
				default:
					menuName = "�����";
					value = 2000;
					break;
				}
			}
			System.out.print("�������� : ");
			choice = sc.nextInt();
			num = value * choice;
			total += num;
			System.out.println(menuName+"�� "+choice+"�� �ֹ��ϼ̽��ϴ�.");

			System.out.print("�߰��ֹ��Ͻðڽ��ϱ�?");
			ch = sc.next().charAt(0);
		}

		while(ch=='y');

		System.out.println("�����Ͻ� �ݾ��� ��" +total+" �Դϴ�");		
	}

}
