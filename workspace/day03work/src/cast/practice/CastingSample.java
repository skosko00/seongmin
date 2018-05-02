package cast.practice;

import java.util.Scanner;

public class CastingSample {
	
	Scanner sc = new Scanner(System.in);
	
	public void printUniCode() {
	System.out.print("문자 입력 : ");
	char ch = sc.next().charAt(0);	//문자열을 입력 받아 0번째 인덱스의 값만 변수 ch에 저장
	System.out.println(ch + " is ASCII : " + (byte)ch);	 //ch의 저장된 문자를 byte로 강제 형변환 후에 출력
	}

	public void calculatorScore() {
		System.out.print("국어 : ");
		double kor = sc.nextDouble();
		System.out.print("영어 : ");
		double eng = sc.nextDouble();
		System.out.print("수학 : ");
		double math = sc.nextDouble();
		
		System.out.println("-------------------------출력-------------------------");
		System.out.println("총점 : " + (int)(kor+eng+math));  //변수 kor, eng, math를 다 더한후에 int형으로 강제 형변환 후 출력
		System.out.println("평균 : " + (kor+eng+math)/3);  //변수 kor, eng, math를 다 더한후에 3으로 나눈 후에 출력
	}
	
	public void printBitCount() {
		System.out.print("정수 입력 : ");
		int a = sc.nextInt();  //int a의 정수를 입력 받음
		
		System.out.println(a + "의 2진수에 포함된 1의 갯수 : " + Integer.bitCount(a));
		//java.lang.Integer 클래스의 있는 bitCount 메소드의 변수 a의 값을 전달 한 후에 리턴된 값을 출력
		//java.lang 패키지는 java의 기본 패키지
	}
}