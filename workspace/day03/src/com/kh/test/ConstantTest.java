package com.kh.test;
import java.util.*;

public class ConstantTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("ù��° �� �Է� : ");
		int firstNum = sc.nextInt();
		System.out.print("�ι�° �� �Է� : ");
		int secondNum = sc.nextInt();
		
		System.out.println("------------���------------");
		
		System.out.println("���� �� : " + (firstNum + secondNum));
		System.out.println("��    �� : " + (firstNum - secondNum));
		System.out.println("���� �� : " + (firstNum * secondNum));
		System.out.println("���� �� : " + ((double)firstNum) / secondNum);

	}

}