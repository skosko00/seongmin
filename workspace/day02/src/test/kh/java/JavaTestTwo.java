package test.kh.java;
import java.util.Scanner;

public class JavaTestTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in); // Scanner 선언 
		
		int age; // age 선언
		
		System.out.print("나이를 입력하세요:"); //출력
		age = sc.nextInt();  //age에 값을 입력
		
		System.out.println("당신의 나이는 " + age + "세 이군요."); //출력
		
	}

}
