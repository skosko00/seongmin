package day18_work;

import java.util.Scanner;

public class Work4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
		  try {
		  System.out.print("첫번째 수 입력 : ");
		  int su1 = sc.nextInt();
		  System.out.print("두번째 수 입력 : ");
		  int su2 = sc.nextInt();
		  System.out.printf("%d + %d = %d \n",su1,su2,su1+su2);
		 }catch (Exception e) {
			System.out.println("정수만 입력해주세요");
		}finally {
			System.out.println("수고하셨습니다.");
		}
		  
	}

}
