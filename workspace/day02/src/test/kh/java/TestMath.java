package test.kh.java;
import java.util.*;

public class TestMath {
	public void math() {
		Scanner sc = new Scanner(System.in);
		int firstNum;
		int secondNum;
		
		System.out.print("ù��° �� �Է� : ");
		firstNum = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		secondNum = sc.nextInt();
		
		System.out.println("���� ��� : " + firstNum + "+" + secondNum + "=" + (firstNum+secondNum));

		System.out.println("��   ��� : " + firstNum + "-" + secondNum + "=" + (firstNum-secondNum));

		System.out.println("���� ��� : " + firstNum + "*" + secondNum + "=" + (firstNum*secondNum));

		System.out.println("���� ��� : " + firstNum + "/" + secondNum + "=" + (firstNum/secondNum));
	}
}
