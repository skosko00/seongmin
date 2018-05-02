package book.kh.com.controller;

import java.util.ArrayList;

import book.kh.com.model.dao.BookDAO;
import book.kh.com.model.vo.Book;

public class BookController {
	
	BookDAO bd = new BookDAO();
	
	public BookController() {}

	public ArrayList<Book> allBook() {
		ArrayList<Book> list = bd.allBook();
		if(list.isEmpty())
		{
			return null;
		}
		return list;
	}

	public Book searchCode(int bookCode) {
		Book b = bd.searchCode(bookCode);
		return b;
	}

	public String insertBook(Book b) {
		if(bd.insertBook(b)>0)
		{
			return "책이 추가되었습니다.";
		}
		else
		{
			return "책 추가에 실패하였습니다.";
		}
	}

	public String deleteBook(int deleteCode) {
		int result = bd.deleteBook(deleteCode); 
		if(result>0)
		{
			return "책이 삭제되었습니다.";
		}else if(result==0)
		{
			return "책 삭제에 실패했습니다.";
		}else
		{
			return "대여중인 책입니다.";
		}
		
	}

}
