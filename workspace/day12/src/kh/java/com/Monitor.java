package kh.java.com;

import java.util.Scanner;

public class Monitor {
	double inch;
	int pixel, price;
	//  ������, �ػ�,  ����
	String modelName, company;
	//�𵨸� ,			����ȸ��
	boolean power = false;	//���� ���� true�� ���� ����

	public void start()
	{
		Scanner sc = new Scanner(System.in);
		monitorInfoInsert(); //����� ���� �Է�
		while(true)
		{
			menu();
			int select = sc.nextInt();
			switch(select)
			{
			case 1:
				powerOnOff();
				break;
			case 2:
				monitorInfo();
				break;
			case 3:

				break;
			}
		}
	}

	public void menu()
	{
		System.out.println("-------- ����� ���� �޴� --------");
		System.out.println("1. ���� on/off");
		System.out.println("2. ����� ���� ����");
		System.out.println("3. ���");
		System.out.print("����");
	}
	public void monitorInfoInsert()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("������� ũ�⸦ �Է��ϼ���(���� inch) : ");
		inch = sc.nextDouble();
		System.out.print("�ػ󵵸� �Է��ϼ��� (���� pixel) : ");
		pixel = sc.nextInt();
		System.out.print("�𵨸��� �Է��ϼ��� : ");
		modelName = sc.next();
		System.out.print("������ �Է��ϼ��� : ");
		price = sc.nextInt();
		sc.nextLine();
		System.out.print("����ȸ�縦 �Է��ϼ��� : ");
		company = sc.nextLine();
	}

	public void monitorInfo()
	{
		if(power==true)
		{
		System.out.printf("-------------------\n");
		System.out.printf("-������:%.2f		 -\n",inch);
		System.out.printf("-�ػ�:%d		 -\n",pixel);
		System.out.printf("-�𵨸�:%s		 -\n",modelName);
		System.out.printf("-���� : %d ��		 -\n",price);
		System.out.printf("-����ȸ�� :%s		 -\n",company);
		System.out.printf("-------------------\n");
		}
		else
		{
			System.out.println("���� ����Ͱ� off ���� �Դϴ�.");
			System.out.println("����� ������ on ���ֽð� �������ּ���.");
		}
	}
	public void print()
	{
		System.out.println();
	}

	public void powerOnOff()
	{
		if(power == false)	//������ off ���¶��!
		{
			power = true;
			System.out.println("������ �������ϴ�.");
		}
		else if(power ==true)	//������ on ���¶��!
		{
			power = false;
			System.out.println("������ �������ϴ�.");
		}
	}


}
