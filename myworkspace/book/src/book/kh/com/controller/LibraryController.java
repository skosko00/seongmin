package book.kh.com.controller;

import java.util.ArrayList;

import book.kh.com.model.dao.LibraryDAO;
import book.kh.com.model.vo.Library;

public class LibraryController {

	public LibraryController() {}
	LibraryDAO ld = new LibraryDAO();
	
	public ArrayList<Library> allLibrary() {
		ArrayList<Library> list = ld.allLibrary();
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
		ArrayList<Library> list = ld.searchId(userId);
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
		ArrayList<Library> list = ld.searchBookName(sBN);
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
		if(ld.insertLibrary(l)>0)
		{
			return "대여가 완료되었습니다.";
		}else
		{
			return "대여의 실패했습니다.";
		}
		
	}

}
