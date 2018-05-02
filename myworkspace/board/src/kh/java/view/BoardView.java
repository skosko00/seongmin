package kh.java.view;

import java.util.Scanner;

public class BoardView {
	public BoardView() {}
	private Scanner sc = new Scanner(System.in);
	public void mainMenu()
	{
		while(true)
		{
			System.out.println("메인메뉴");
			System.out.println("1. 회원관리");
			System.out.println("2. 게시판관리");
			System.out.println("3. 프로그램 종료");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1: new MemberManager().menu(); break;
			case 2: new BoardManager().menu(); break;
			case 3: System.out.print("정말 프로그램을 종료하시겠습니까?(y,n) : ");
			if(sc.next().toUpperCase().charAt(0)=='Y')
			{
				System.out.println("종료합니다.");
				System.exit(0);
			}
			}
		}
	}
}
