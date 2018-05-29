package notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.PageData;

public class NoticeService {

	public PageData noticeAll(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		// Service에서는 2가지 값을 정해야 함
		// 1. 한 페이지당 보이는 리스트의 개수 (게시물의 개수)
		// 2. 현재 위치를 중심으로 시작 navi에서부터 끝 navi 개수

		int recordCountPage = 10;	// 한 페이지당 보이는 리스트의 개수
		int naviCountPerPage = 5;	// 현재 페이지를 중심으로 시작 navi에서부터 끝 navi 개수

		// Service에서는 DAO에 2가지 요청을 진행 해야 함
		// 1. 현재 페이지 리스트
		// 2. 현재 중심으로 만들어지는 navi 리스트

		ArrayList<Notice> list = new NoticeDAO().getCurrentPage(conn,currentPage,recordCountPage);
		String pageNavi = new NoticeDAO().getPageNavi(conn,currentPage,recordCountPage,naviCountPerPage);

		PageData pd = null;
		if(!list.isEmpty() && !pageNavi.isEmpty())
		{
			pd = new PageData();
			pd.setNoticeList(list);
			pd.setPageNavi(pageNavi);
		}
		JDBCTemplate.close(conn);
		
		return pd;
	}

	public PageData getSearchPage(int currentPage, String search) {
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPage = 10;
		int naviCountPerPage = 5;
		
		ArrayList<Notice> list = new NoticeDAO().getSearchPage(conn,currentPage,search,recordCountPage);
		String pageNavi = new NoticeDAO().getSearchPageNavi(conn,currentPage,search,recordCountPage,naviCountPerPage);
		
		PageData pd = null;
		if(!list.isEmpty() && !pageNavi.isEmpty())
		{
			pd = new PageData();
			pd.setNoticeList(list);
			pd.setPageNavi(pageNavi);
		}
		JDBCTemplate.close(conn);
		
		return pd;
		
	}

	public Notice noticeSelect(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice notice = new NoticeDAO().noticeSelect(conn,noticeNo);
		JDBCTemplate.close(conn);
		return notice;
		
	}

	public int noticeUpdate(String subject, int noticeNo, String contents) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDAO().noticeUpdate(conn,subject,noticeNo,contents);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int noticeWrite(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDAO().noticeWrite(conn,n);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int noticeDelete(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDAO().noticeDelete(conn,n);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}	
		JDBCTemplate.close(conn);
		return result;
	}

}
