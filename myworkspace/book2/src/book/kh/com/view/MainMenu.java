package book.kh.com.view;

import java.util.Scanner;

public class MainMenu {

	Scanner sc = new Scanner(System.in);

	public MainMenu() {}

	public void menu() {

		while(true)
		{
			System.out.println("= = = = = 메인메뉴 = = = = =");
			System.out.println("1. 책 관리");
			System.out.println("2. 회원관리");
			System.out.println("3. 대여관리");
			System.out.println("0. 종료");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:
				new BookView().menu();
				break;
			case 2:
				new CustomerView().menu();
				break;
			case 3:
				new LibraryView().menu();
				break;
			case 0:
				System.out.print("정말 종료하시겠습니까?(y,n) : ");
				if(sc.next().toUpperCase().charAt(0)=='Y')
				{
					System.out.println("종료하였습니다.");
					System.exit(0);
				}
				break;
			default : 
				System.out.println("잘못된 선택입니다.");
			}
		}
	}

}
