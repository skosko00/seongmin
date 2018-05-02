package kh.java.test;

import java.util.Scanner;

public class Quiz06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("입력(1~5) : ");
		int select = sc.nextInt();
		if(0<select && select<6)
		{
			switch(select)
			{
			case 1:
				System.out.println("**입력이 정상적으로 되었습니다! **");
				break;
			case 2:
				System.out.println("**조회가 시작되었습니다! **");
				break;
			case 3:
				System.out.println("**수정이 정상적으로 되었습니다! **");
				break;
			case 4:
				System.out.println("**삭제가 정상적으로 되었습니다! **");
				break;
			default:
				System.out.println("**정상적으로 종료 되었습니다! **");
				break;
			}
		}
		else
		{
			System.out.println("** 다시 입력해 주세요! **");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
