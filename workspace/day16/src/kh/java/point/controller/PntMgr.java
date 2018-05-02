package kh.java.point.controller;

import java.util.Scanner;

import kh.java.point.model.vo.Gold;
import kh.java.point.model.vo.Grade;
import kh.java.point.model.vo.Silver;
import kh.java.point.model.vo.Vip;

public class PntMgr implements PntMgrInterface{

	Scanner sc = new Scanner(System.in);

	Grade [] g = new Grade[20];
	int index=0, r_index;
	String name;
	String grade;


	@Override
	public void insertData() {
		System.out.println("======= ȸ�� �߰� ���� ======\n");
		System.out.print("��� �Է�<Silver/Gold/Vip> : ");
		grade = sc.next();
		switch(grade)
		{
		case "Silver":
			g[index] = new Silver();
			break;
		case "Gold":
			g[index] = new Gold();
			break;
		case "Vip":
			g[index] = new Vip();
			break;
		default :
			System.out.println("�߸� �Է��ϼ̽��ϴ�. ȸ���߰��� �����մϴ�");
			return;
		}
		g[index].setGrade(grade);

		System.out.print("�̸� �Է� : ");
		g[index].setName(sc.next());

		System.out.print("����Ʈ �Է� : ");
		g[index++].setPoint(sc.nextInt());
		sc.nextLine();

	}

	@Override
	public void start() {
		while(true)
		{
			System.out.println("========== ȸ�� ���� �ý��� ==========\n");
			System.out.println("1. ȸ�� �߰�");
			System.out.println("2. ȸ�� ��ü ���");
			System.out.println("3. ȸ�� ����");
			System.out.println("4. ȸ�� ����");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� : ");
			switch(sc.nextInt())
			{
			case 1:
				insertData();
				break;
			case 2:
				printData();
				break;
			case 3:
				modifyData();
				break;
			case 4:
				deleteData();
				break;
			case 0:
				stop();
				break;
			}
		}
	}

	@Override
	public int searchData() {

		for(int i=0; i<index; i++)
		{
			if(g[i].getName().equals(name))
			{
				r_index = i;
				break;
			}
			else
			{
				r_index = index+1;
			}
		}		
		
		return r_index;
	}

	@Override
	public void modifyData() {
		
		System.out.print("�˻��� ȸ�� �̸� �Է� : ");
		name = sc.next();
		searchData();
		if(0<=r_index && r_index<index)
		{
			System.out.print("������ ��� �Է�<Silver/Gold/Vip");
			grade = sc.next();
			switch(grade)
			{
			case "Silver":
				g[r_index] = new Silver();
				break;
			case "Gold":
				g[r_index] = new Gold();
				break;
			case "Vip":
				g[r_index] = new Vip();
				break;
			default :
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ȸ�������� �����մϴ�");
				return;
			}
			
			g[r_index].setGrade(grade);

			System.out.print("���� �� �̸� �Է� : ");
			g[r_index].setName(sc.next());

			System.out.print("���� �� ����Ʈ �Է� : ");
			g[r_index].setPoint(sc.nextInt());
			sc.nextLine();			
		}
		else
		{
			System.out.println("�˻��� ȸ���� �����ϴ�.");
		}
		

	}

	@Override
	public void deleteData() {
		System.out.print("�˻��� ȸ�� �̸� �Է� : ");
		name = sc.next();
		searchData();
		
		if(0<=r_index && r_index<index)
		{
			for(;r_index<index-1;r_index++)
			{
				g[r_index] = g[r_index+1];
			}
			g[r_index+1]=null;
			index--;
			System.out.println("ȸ�� ������ �����Ǿ����ϴ�.");
		}
		
		else
		{
			System.out.println("�˻��� ȸ���� �����ϴ�.");
		}

	}

	@Override
	public void printData() {
		System.out.println("========== information ==========");
		System.out.printf("%s \t%s \t%s \t%s \n","�̸�","���","����Ʈ","��������Ʈ");
		for(int i=0;i<index;i++)
		{
			System.out.printf("%s \t%s \t%d \t%.1f \n",g[i].getName(), g[i].getGrade(), g[i].getPoint(), g[i].getInterest());
		}

	}

	public void stop()
	{
		System.err.println("���α׷��� �����մϴ�.");
		System.exit(0);
	}

}
