package kh.java.com;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class TestMain2 {
	private static Properties prop = new Properties();
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		try {
			prop.load(new FileReader("resources/test.Properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(prop.getProperty("Serial").equals("demo"))
		{
			demoMenu();
		}
		else if(prop.getProperty("Serial").equals("smlove")) 
		{
			mainMenu();
		}

	}
	private static void mainMenu() {
		System.out.println("======== 학생 관리 프로그램 ========");
		System.out.println("1. 학생 정보 저장");
		System.out.println("2. 학생 정보 출력");
		System.out.println("3. 학생 한명 출력");
		System.out.println("0. 종료");
		switch(sc.nextInt())
		{
		case 0:
			System.exit(0);
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		}

	}
	private static void demoMenu() {
		System.out.println("======== 학생 관리 프로그램 ========");
		System.out.println("1. 학생 정보 저장");
		System.out.println("2. 학생 정보 출력");
		System.out.println("0. 종료");
		switch(sc.nextInt())
		{
		case 0:
			System.exit(0);
		case 1:
			break;
		case 2:
			break;
		}
	}
}
