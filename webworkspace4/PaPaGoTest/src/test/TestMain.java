package test;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		PaPaGo ppg = new PaPaGo();
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String data = sc.nextLine();
		System.out.println(ppg.testPaPaGo(data));

	}

}
