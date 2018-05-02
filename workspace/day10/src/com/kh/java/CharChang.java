package com.kh.java;

import java.util.Scanner;

public class CharChang {
	public void start()
	{
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.print("영문자 입력 : ");
		ch = sc.next().charAt(0);
		System.out.println("===== 변  환 ====");
		System.out.print(ch + "--> ");
		ch = charChange(ch);
		System.out.println(ch);
	}
	
	public char charChange(char a)
	{
		if('a'<=a && a<='z' || 'A'<=a && a<='Z')
		{
		a = (char) (a^32);
		}
		return a; 
	}
}
