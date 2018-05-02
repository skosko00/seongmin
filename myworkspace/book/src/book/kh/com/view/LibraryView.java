package book.kh.com.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.kh.com.controller.CustomerController;
import book.kh.com.controller.LibraryController;
import book.kh.com.model.vo.Customer;
import book.kh.com.model.vo.Library;

public class LibraryView {

	LibraryController lc = new LibraryController();
	Scanner sc = new Scanner(System.in);

	public LibraryView() {}

	public void menu()
	{
		while(true)
		{
			System.out.println("= = = = = 대여 관리 = = = = =");
			System.out.println("1. 대여 관리 전체 조회");
			System.out.println("2. 회원 아이디로 대여 조회");
			System.out.println("3. 책 이름으로 대여 조회");
			System.out.println("4. 대여정보 추가");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:
				allLibrary();
				break;
			case 2:
				searchId();
				break;
			case 3:
				searchBookName();
				break;
			case 4:
				insertLibrary();
				break;				
			case 5:
				return;
			}
		}
	}

	private void insertLibrary() {
		Library l = new Library();
		System.out.println("= = = = = 대여 = = = = =");
		System.out.print("대여번호 입력 : ");
		l.setLeaseNo(sc.nextInt());
		System.out.print("회원아이디 입력 : ");
		l.setUserId(sc.next());
		System.out.print("책이름 입력 : ");
		l.setBookName(sc.next());
		System.out.println(lc.insertLibrary(l));

	}
	private void searchBookName() {
		System.out.print("대여목록에서 조회할 책 이름 입력 : ");
		String sBN = sc.next();
		ArrayList<Library> list = lc.searchBookName(sBN);
		if(list==null)
		{
			System.out.println("대여 목록이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = = 대여 책 이름 조회 = = = = = =");
			System.out.println("대여번호    회원ID    회원이름    책이름");
			for(Library l : list)
			{
				System.out.println(l);
			}
		}		
	}

	private void searchId() {
		System.out.print("대여목록에서 조회할 회원 아이디 입력 : ");
		String userId = sc.next();
		ArrayList<Library> list = lc.searchId(userId);
		if(list==null)
		{
			System.out.println("대여 목록이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = = 대여 ID 조회 = = = = = =");
			System.out.println("대여번호    회원ID    회원이름    책이름");
			for(Library l : list)
			{
				System.out.println(l);
			}
		}		
	}

	private void allLibrary() {
		ArrayList<Library> list = lc.allLibrary();

		if(list==null)
		{
			System.out.println("대여 목록이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = = 대여 전체 조회 = = = = = =");
			System.out.println("대여번호    회원ID    회원이름    책이름");
			for(Library l : list)
			{
				System.out.println(l);
			}
		}		
	}
}
