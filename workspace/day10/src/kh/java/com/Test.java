package kh.java.com;

import java.util.Scanner;

public class Test {

	public void test1()
	{
		int [][] arr = new int[3][];
		arr[0] = new int[] {1,2,3};
		arr[1] = new int[] {4,5};
		arr[2] = new int[] {6,7,8,9,10};
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void test2()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("�ǹ� �� ���� �Է� : ");
		String [][] apart = new String[sc.nextInt()][];
		System.out.println(apart.length+"���� ���� �Ǿ����ϴ�.");
		
		for(int i=0;i<apart.length;i++)
		{
		System.out.print(i+1+"���� �� ȣ�� �Է� : ");
		apart[i] = new String[sc.nextInt()];
		}
		
		sc.nextLine();
		
		for(int i=0; i<apart.length;i++)
		{
			System.out.println(i+1+"���� " + apart[i].length + "ȣ�Ǳ��� ���� �Ǿ����ϴ�.");
		}
		
		System.out.println("�� ȣ�Ǹ��� �������� �̸��� �Է��ϼ���");
		
		for(int i=0; i<apart.length; i++)
		{
			System.out.println("==========="+(i+1)+" �� ���� �Է�"+"============");
			for(int j=0; j<apart[i].length;j++)
			{
				System.out.print((i+1)+"�� "+(j+1)+"ȣ ������ : ");
				apart[i][j] = sc.nextLine();
			}
		}
		
		System.out.println("------- �� �� ������ ���� ��� -------");
		
		for(int i=0;i<apart.length;i++)
		{
			System.out.print(i+1+"�� : ");
			for(int j = 0;j<apart[i].length;j++)
			{
				System.out.print(apart[i][j]+" ");
			}
			System.out.println();
		}
	}
		
}
