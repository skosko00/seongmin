package com.exception.number;

import java.util.Scanner;

public class run {

	public static void main(String[] args) {
		
		NumberProcess n = new NumberProcess();
		Scanner sc = new Scanner(System.in);
		int su1, su2;
		try {
		if(n.checkDouble(su1=sc.nextInt(), su2=sc.nextInt())==true)
		{
			System.out.println(su1+"��(��) "+su2+"�� ��� �Դϴ�.");
		}
		else
		{
			System.out.println(su1+"��(��) "+su2+"�� ����� �ƴմϴ�.");
		}
		}catch (NumberRangeException e) {
			System.out.println(e.getMessage());
		}
	}

}
