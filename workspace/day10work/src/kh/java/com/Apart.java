package kh.java.com;

import java.util.Scanner;

public class Apart {
	public void apart()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("----- A ����Ʈ ���� �Է� -----");
		System.out.print("�ǹ� �� ���� �Է� : ");
		
		String [][] apart = new String [sc.nextInt()][];
		
		System.out.println(apart.length+" ���� ���� �Ǿ����ϴ�");
		
		for(int i=0; i<apart.length; i++)
		{
			System.out.print(i+1+"���� �� ȣ�� �Է� : ");
			apart[i] = new String[sc.nextInt()];
		}
		
		for(int i=0; i<apart.length; i++)
		{
			System.out.println((i+1)+"����  " + apart[i].length + "ȣ�Ǳ��� ���� �Ǿ����ϴ�");
		}
		
		sc.nextLine();
		
		System.out.println("�� ȣ�Ǹ��� �������� �̸��� �Է��ϼ���");
		
		for(int i=0; i<apart.length; i++)
		{
			System.out.println("========="+(i+1)+" �� ���� �Է� =========");
			for(int j=0; j<apart[i].length; j++)
			{
				System.out.print(i+1+"�� " +j+"ȣ ������ : ");
				apart[i][j] = sc.nextLine();
			}
		}
		
		for(int i=0; i<apart.length; i++)
		{
			System.out.println("========="+(i+1)+" �� ���� ��� =========");
			System.out.print(i+1+"�� ������ : ");
			for(int j=0; j<apart[i].length; j++)
			{
				System.out.print(apart[i][j]+" ");
			}
			System.out.println();
		}
	}
}
