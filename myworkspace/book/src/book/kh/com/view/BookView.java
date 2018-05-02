package book.kh.com.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.kh.com.controller.BookController;
import book.kh.com.model.vo.Book;

public class BookView {
	
	BookController bc = new BookController();

	Scanner sc = new Scanner(System.in);

	public BookView() {}

	public void menu()
	{
		while(true)
		{
			System.out.println("= = = = = 책 관리 = = = = =");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 책 코드 조회");
			System.out.println("3. 책 추가");
			System.out.println("4. 책 삭제");
			System.out.println("5. 메인 메뉴로 이동");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:
				allBook();
				break;
			case 2:
				searchCode();
				break;
			case 3:
				insertBook();
				break;
			case 4:
				deleteBook();
				break;
			case 5:
				return;
			}
		}
	}

	private void deleteBook() {
		Book b = new Book();
		System.out.print("삭제 할 책의 코드를 입력해주세요 : ");
		int deleteCode = sc.nextInt();
		System.out.println(bc.deleteBook(deleteCode));
	}

	private void insertBook() {
		System.out.println("= = = = = = 책 추가  = = = = = =");
		Book b = new Book();
		System.out.print("책 코드 입력 : ");
		b.setBookNo(sc.nextInt());
		sc.nextLine();
		System.out.print("책 이름 입력 : ");
		b.setBookName(sc.nextLine());
		System.out.print("책 저자 입력 : ");
		b.setBookWriter(sc.nextLine());
		System.out.print("대여료 입력 : ");
		b.setBookPrice(sc.nextInt());
		System.out.print("출판사 입력 : ");
		b.setPublisher(sc.next());
		System.out.print("장르 입력 : ");
		b.setGenre(sc.next());
		System.out.println(bc.insertBook(b));		
	}

	private void searchCode() {
		
		System.out.print("조회할 책에 코드를 입력해주세요 : ");
		int bookCode = sc.nextInt();
		Book b = bc.searchCode(bookCode);
		if(b==null)
		{
			System.out.println(bookCode+"코드의 책이 없습니다.");
		}else
		System.out.println(b);
	}

	private void allBook() {
		ArrayList<Book> list = bc.allBook();
		if(list==null)
		{
			System.out.println("책이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = 전체 책 조회 = = = = =");
			System.out.println("책번호     책 이름                    책저자          책가격          출판사          장르");
			for (Book b : list)
			{
				System.out.println(b);
			}
		}
	}
}
