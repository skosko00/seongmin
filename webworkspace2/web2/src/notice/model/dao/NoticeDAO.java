package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class NoticeDAO {

	public ArrayList<Notice> getCurrentPage(Connection conn, int currentPage, int recordCountPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		// 시작 게시물 계산
		int startPage = currentPage*recordCountPage -(recordCountPage-1);
				// 만약 요청한 페이지가 1페이지라면? -> 1
				// 1 * 10 - (10-1) => 1
				// 만약 요청한 페이지가 3페이지라면? -> 21
				// 3 * 10 - (10-1) => 21
		
		
		// 끝 게시물 계산
		int endPage = currentPage*recordCountPage;
				// 만약 요청한 페이지가 1페이지라면? -> 10
				// 1 * 10 = 10
				// 만약 요청한 페이지가 3페이지라면? -> 30
				// 3 * 10 = 30
		
		String query = "select * from" + 
				"(select notice.*, row_number() over(order by noticeno desc)as num from notice)" + 
				"where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startPage);
			pstmt.setInt(2, endPage);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("noticeno"));
				n.setSubject(rset.getString("subject"));
				n.setContents(rset.getString("contents"));
				n.setUserId(rset.getString("userid"));
				n.setRegDate(rset.getDate("regdate"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String getPageNavi(Connection conn, int currentPage, int recordCountPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		
		String query = "select count(*)AS totalCount from notice";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()){
			recordTotalCount = rset.getInt("totalCount");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//124 -> navi 13
		
		int pageTotalCount = 0; // navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만들려면?
		// total 게시물이 124개 라고 했을때 124%10을 한후 +1 만큼
		// 만들어야 함
		// 만약 나머지가 0으로 떨어진다면 +1을 하지 않음
		if(recordTotalCount%recordCountPage!=0)
		{
			pageTotalCount = recordTotalCount / recordCountPage +1;
		}else
		{
			pageTotalCount = recordTotalCount / recordCountPage;
		}
		
		
		if(currentPage<1)
		{
			currentPage=1;
		}
		else if(currentPage>pageTotalCount)
		{
			currentPage = pageTotalCount;
		}
		// 사용자가 현재 페이지가 1페이지인데 더 아래 페이지를 요청할 경우
		// 혹은 마지막 페이지가 120 페이지 인데 다음 페이지를
		// 요청할 경우에 대한 에러 방지 설정
		// 1보다 아래를 요청하면 1로 셋팅
		// 마지막보다 다음 페이지를 요청하면 마지막 페이지 값으로 셋팅
		
		
		
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어야 함
		// 현재 페이지가 1이라면? 1-5
		// 현재 페이지가 3이라면? 1-5
		// 현재 페이지가 7이라면? 6-10
		// 현재 페이지가 12라면? 11-15
		// 시작 페이지 구하는 공식은?
		// -> ((현재페이지-1)/리스트개수)*리스트개수+1
		// 만약 1페이지 라면?
		// ((1-1)/5)*5+1 => 시작페이지는 1
		// 만약 3페이지 라면?
		// ((3-1)/5)*5+1) => 시작페이지는 1
		// 만약 7페이지 라면?
		// ((7-1)/5)*5+1) = 시작페이지는 6
		// 만약 2페이지 라면?
		// ((12-1)/5)*5+1) = 시작페이지는 11
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
		
		// 끝 navi 구하는 공식 (쉬움)
		// 시작navi + 보여줄 navi 개수 -1;
		// 만약 시작 navi 1이라면?
		// 1 + 5 - 1 => 5
		// 만약 시작 navi 6이라면?
		// 6 + 5 - 1 => 10
		
		int endNavi = startNavi + naviCountPerPage - 1;
		
		// 끝 navi를 구할 때 주의 해야 할 점
		// 토탈 navi 가 122라고 할 때! (현재 페이지는 121이라고 할 때)
		// 시작 navi => ((121-1)/5)*5+1 = 121
		// 끝 navi => 121 + 5 - 1 = 125
		// 이렇기 때문에 마지막 navi 부분은 아래 코드를 추가 해야 함
		
		if(endNavi>pageTotalCount)
		{
			endNavi = pageTotalCount;
		}
		
		// 페이지 navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요 없으므로 !)
		
		boolean needPrev = true;	// 이전 페이지
		boolean needNext = true;	// 다음 페이지
		
		if(startNavi==1)
		{
			needPrev=false;
		}
		if(endNavi==pageTotalCount)
		{
			needNext=false;
		}
		
		// 여기까지 기본적인 구조는 끝남
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev) { //시작이 1페이지가 아니라면!
			sb.append("<a href='/notice?currentPage="+(startNavi-1)+"'> << </a>");
			sb.append("<a href='/notice?currentPage="+(currentPage-1)+"'> < </a>");
		}
		for(int i=startNavi; i<=endNavi; i++)
		{
			if(i==currentPage)
			{
				sb.append("<a href='/notice?currentPage="+i+"'><B> "+i+" </B></a>");
			}else
			{
				sb.append("<a href='/notice?currentPage="+i+"'> "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='notice?currentPage="+(currentPage+1)+"'> > </a>");
			sb.append("<a href='notice?currentPage="+(endNavi+1)+"'> >> </a>");
		}
		
		return sb.toString();
		
	}

	public ArrayList<Notice> getSearchPage(Connection conn, int currentPage, String search, int recordCountPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		// 시작 게시물 계산
		int startPage = currentPage*recordCountPage -(recordCountPage-1);
				// 만약 요청한 페이지가 1페이지라면? -> 1
				// 1 * 10 - (10-1) => 1
				// 만약 요청한 페이지가 3페이지라면? -> 21
				// 3 * 10 - (10-1) => 21
		
		
		// 끝 게시물 계산
		int endPage = currentPage*recordCountPage;
				// 만약 요청한 페이지가 1페이지라면? -> 10
				// 1 * 10 = 10
				// 만약 요청한 페이지가 3페이지라면? -> 30
				// 3 * 10 = 30
		
		String query = "select * from" + 
				"(select notice.*, row_number() over(order by noticeno desc)as num from notice where subject like ?)" + 
				"where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setInt(2, startPage);
			pstmt.setInt(3, endPage);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("noticeno"));
				n.setSubject(rset.getString("subject"));
				n.setContents(rset.getString("contents"));
				n.setUserId(rset.getString("userid"));
				n.setRegDate(rset.getDate("regdate"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String getSearchPageNavi(Connection conn, int currentPage, String search, int recordCountPage,
			int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		// 게시물의 토탈 개수를 구해야 함
		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		
		String query = "select count(*)AS totalCount from notice where subject like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+search+"%");
			rset = pstmt.executeQuery();
			if(rset.next()){
			recordTotalCount = rset.getInt("totalCount");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		//124 -> navi 13
		
		int pageTotalCount = 0; // navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만들려면?
		// total 게시물이 124개 라고 했을때 124%10을 한후 +1 만큼
		// 만들어야 함
		// 만약 나머지가 0으로 떨어진다면 +1을 하지 않음
		if(recordTotalCount%recordCountPage!=0)
		{
			pageTotalCount = recordTotalCount / recordCountPage +1;
		}else
		{
			pageTotalCount = recordTotalCount / recordCountPage;
		}
		
		
		if(currentPage<1)
		{
			currentPage=1;
		}
		else if(currentPage>pageTotalCount)
		{
			currentPage = pageTotalCount;
		}
		// 사용자가 현재 페이지가 1페이지인데 더 아래 페이지를 요청할 경우
		// 혹은 마지막 페이지가 120 페이지 인데 다음 페이지를
		// 요청할 경우에 대한 에러 방지 설정
		// 1보다 아래를 요청하면 1로 셋팅
		// 마지막보다 다음 페이지를 요청하면 마지막 페이지 값으로 셋팅
		
		
		
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어야 함
		// 현재 페이지가 1이라면? 1-5
		// 현재 페이지가 3이라면? 1-5
		// 현재 페이지가 7이라면? 6-10
		// 현재 페이지가 12라면? 11-15
		// 시작 페이지 구하는 공식은?
		// -> ((현재페이지-1)/리스트개수)*리스트개수+1
		// 만약 1페이지 라면?
		// ((1-1)/5)*5+1 => 시작페이지는 1
		// 만약 3페이지 라면?
		// ((3-1)/5)*5+1) => 시작페이지는 1
		// 만약 7페이지 라면?
		// ((7-1)/5)*5+1) = 시작페이지는 6
		// 만약 2페이지 라면?
		// ((12-1)/5)*5+1) = 시작페이지는 11
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
		
		// 끝 navi 구하는 공식 (쉬움)
		// 시작navi + 보여줄 navi 개수 -1;
		// 만약 시작 navi 1이라면?
		// 1 + 5 - 1 => 5
		// 만약 시작 navi 6이라면?
		// 6 + 5 - 1 => 10
		
		int endNavi = startNavi + naviCountPerPage - 1;
		
		// 끝 navi를 구할 때 주의 해야 할 점
		// 토탈 navi 가 122라고 할 때! (현재 페이지는 121이라고 할 때)
		// 시작 navi => ((121-1)/5)*5+1 = 121
		// 끝 navi => 121 + 5 - 1 = 125
		// 이렇기 때문에 마지막 navi 부분은 아래 코드를 추가 해야 함
		
		if(endNavi>pageTotalCount)
		{
			endNavi = pageTotalCount;
		}
		
		// 페이지 navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요 없으므로 !)
		
		boolean needPrev = true;	// 이전 페이지
		boolean needNext = true;	// 다음 페이지
		
		if(startNavi==1)
		{
			needPrev=false;
		}
		if(endNavi==pageTotalCount)
		{
			needNext=false;
		}
		
		// 여기까지 기본적인 구조는 끝남
		
		StringBuilder sb = new StringBuilder();
		
		if(needPrev) { //시작이 1페이지가 아니라면!
			sb.append("<a href='/searchNotice?currentPage="+(startNavi-1)+"'> << </a>");
			sb.append("<a href='/searchNotice?currentPage="+(currentPage-1)+"'> < </a>");
		}
		for(int i=startNavi; i<=endNavi; i++)
		{
			if(i==currentPage)
			{
				sb.append("<a href='/searchNotice?currentPage="+i+"'><B> "+i+" </B></a>");
			}else
			{
				sb.append("<a href='/searchNotice?currentPage="+i+"'> "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='searchNotice?currentPage="+(currentPage+1)+"'> > </a>");
			sb.append("<a href='searchNotice?currentPage="+(endNavi+1)+"'> >> </a>");
		}
		
		return sb.toString();
	}

}
