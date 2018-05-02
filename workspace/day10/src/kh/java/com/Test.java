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
		System.out.print("건물 총 층수 입력 : ");
		String [][] apart = new String[sc.nextInt()][];
		System.out.println(apart.length+"층이 생성 되었습니다.");
		
		for(int i=0;i<apart.length;i++)
		{
		System.out.print(i+1+"층의 총 호실 입력 : ");
		apart[i] = new String[sc.nextInt()];
		}
		
		sc.nextLine();
		
		for(int i=0; i<apart.length;i++)
		{
			System.out.println(i+1+"층은 " + apart[i].length + "호실까지 생성 되었습니다.");
		}
		
		System.out.println("각 호실마다 입주자의 이름을 입력하세요");
		
		for(int i=0; i<apart.length; i++)
		{
			System.out.println("==========="+(i+1)+" 층 정보 입력"+"============");
			for(int j=0; j<apart[i].length;j++)
			{
				System.out.print((i+1)+"층 "+(j+1)+"호 입주자 : ");
				apart[i][j] = sc.nextLine();
			}
		}
		
		System.out.println("------- 각 층 입주자 정보 출력 -------");
		
		for(int i=0;i<apart.length;i++)
		{
			System.out.print(i+1+"층 : ");
			for(int j = 0;j<apart[i].length;j++)
			{
				System.out.print(apart[i][j]+" ");
			}
			System.out.println();
		}
	}
		
}
