package com.exeception.charcheck;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CharacterProcess c = new CharacterProcess();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println(c.countAlpha(sc.nextLine()));
		} catch (CharCheckException e) {
			System.out.println(e.getMessage());
		}
	}

}
