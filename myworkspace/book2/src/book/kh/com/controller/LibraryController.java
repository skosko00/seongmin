package book.kh.com.controller;

import java.util.ArrayList;

import book.kh.com.model.service.LibraryService;
import book.kh.com.model.vo.Library;

public class LibraryController {

	public LibraryController() {}
	private LibraryService ls = new LibraryService();
	
	public ArrayList<Library> allLibrary() {
		ArrayList<Library> list = ls.allLibrary();
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}		
		
	}

	public ArrayList<Library> searchId(String userId) {
		ArrayList<Library> list = ls.searchId(userId);
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}		
		
	}

	public ArrayList<Library> searchBookName(String sBN) {
		ArrayList<Library> list = ls.searchBookName(sBN);
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}		
	}

	public String insertLibrary(Library l) {
		if(ls.insertLibrary(l)>0)
		{
			return "대여가 완료되었습니다.";
		}else
		{
			return "대여의 실패했습니다.";
		}
		
	}

}
