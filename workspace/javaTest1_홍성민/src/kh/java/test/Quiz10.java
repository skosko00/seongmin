package kh.java.test;

import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] array = new int[5];
		int tmp;
		for(int i =0; i<array.length; i++)
		{
			System.out.print(i+1+"��° ���� �Է� : ");
			array[i] = sc.nextInt();
		}
		for(int i=0; i<array.length;i++)
		{
			for(int j=0;j<array.length-1-i;j++)
			{
				if(array[j]>array[j+1])
				{
					tmp = array[j+1];
					array[j+1]=array[j];
					array[j]=tmp;
				}
			}
		}
		System.out.println("���� ���");
		for(int i=0; i<array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

}
