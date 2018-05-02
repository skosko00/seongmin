package test.kh.java;
import java.util.*;

public class TestMath {
	public void math() {
		Scanner sc = new Scanner(System.in);
		int firstNum;
		int secondNum;
		
		System.out.print("첫번째 수 입력 : ");
		firstNum = sc.nextInt();
		System.out.print("두번째 수 입력 : ");
		secondNum = sc.nextInt();
		
		System.out.println("더한 결과 : " + firstNum + "+" + secondNum + "=" + (firstNum+secondNum));

		System.out.println("뺀   결과 : " + firstNum + "-" + secondNum + "=" + (firstNum-secondNum));

		System.out.println("곱한 결과 : " + firstNum + "*" + secondNum + "=" + (firstNum*secondNum));

		System.out.println("나눈 결과 : " + firstNum + "/" + secondNum + "=" + (firstNum/secondNum));
	}
}
