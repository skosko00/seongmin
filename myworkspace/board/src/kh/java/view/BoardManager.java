package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.controller.BoardController;
import kh.java.model.vo.Board;

public class BoardManager {
	public BoardManager() {}

	private Scanner sc = new Scanner(System.in);
	private BoardController bc = new BoardController();

	public void menu() {
		while(true)
		{
			System.out.println("게시판 서브메뉴");
			System.out.println("1. 게시판전체 검색");
			System.out.println("2. 게시물 등록");
			System.out.println("3. 작성자로 검색");
			System.out.println("4. 제목으로 검색");
			System.out.println("5. 게시물 수정(제목, 내용)");
			System.out.println("6. 게시물 삭제");
			System.out.println("7. 메인메뉴");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1: allBoard(); break;
			case 2: insertBoard(); break;
			case 3: writerSearch(); break;
			case 4: titleSearch(); break;
			case 5: updateBoard(); break;
			case 6: deleteBoard(); break;
			case 7: return;
			}
		}
	}

	private void deleteBoard() {
		System.out.print("삭제할 게시판 번호 입력 : ");
		int no = sc.nextInt();
		System.out.println(bc.deleteBoard(no));
	}

	private void updateBoard() {
		Board b = new Board();
		System.out.print("수정할 게시판 번호 입력 : ");
		b.setBoardNo(sc.nextInt());
		sc.nextLine();
		System.out.print("제목 입력 : ");
		b.setTitle(sc.nextLine());
		System.out.print("내용 입력 : ");
		b.setContent(sc.nextLine());
		System.out.println(bc.updateBoard(b));
	}

	private void titleSearch() {
		System.out.print("조회할 제목 입력 : ");
		String title = sc.next();
		ArrayList<Board> list = bc.titleSearch(title);
		if(list==null)
		{
			System.out.println("조회된 제목이 없습니다.");
		}else
		{
			System.out.println("게시판 전체 검색");
			System.out.println("번호  목록  제목  내용                    글쓴이  작성시간");
			for(Board b : list)
				System.out.println(b);
		}
		
	}

	private void writerSearch() {
		System.out.print("조회할 작성자 입력 : ");
		String writer = sc.next();
		ArrayList<Board> list = bc.writerSearch(writer);
		if(list==null)
		{
			System.out.println("조회된 작성자 게시판이 없습니다.");
		}else
		{
			System.out.println("게시판 전체 검색");
			System.out.println("번호  목록  제목  내용                    글쓴이  작성시간");
			for(Board b : list)
				System.out.println(b);
		}
	}

	private void insertBoard() {
		Board b = new Board();
		sc.nextLine();
		System.out.print("게시판 설정(공지,일반,비밀) : ");
		b.setDiv(sc.nextLine());
		System.out.print("제목 입력 : ");
		b.setTitle(sc.nextLine());
		System.out.print("내용 입력 : ");
		b.setContent(sc.nextLine());
		System.out.print("글쓴이 : ");
		b.setWriter(sc.next());
		System.out.println(bc.insertBoard(b));
	}

	private void allBoard() {
		ArrayList<Board> list = bc.allBoard();
		if(list==null)
		{
			System.out.println("조회된 게시판이 없습니다.");
		}else
		{
			System.out.println("게시판 전체 검색");
			System.out.println("번호  목록  제목  내용                    글쓴이  작성시간");
			for(Board b : list)
				System.out.println(b);
		}

	}

}
