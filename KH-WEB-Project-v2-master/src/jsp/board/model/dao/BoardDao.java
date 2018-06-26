package jsp.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jsp.board.model.vo.BoardVo;
import jsp.board.model.vo.Comment;
import jsp.board.model.vo.DataFile;
import jsp.common.JDBCTemplate;

public class BoardDao {
	public BoardDao() {
	}

	public ArrayList<BoardVo> getNoticeCurrentPage(Connection conn, int currentPage, int listPerCountPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 시작 ,끝 게시물
		int startTotalBoard = currentPage * listPerCountPage - (listPerCountPage - 1);
		int endTotalBoard = currentPage * listPerCountPage;

		String query = "select * from"
      + " (select Board_tb.*, row_number() over(order by bd_no desc) as num from board_tb where BD_CATEGORY='공지사항') "
	    + "where num between ? and ?";
    
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startTotalBoard);
			pstmt.setInt(2, endTotalBoard);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				BoardVo bv = new BoardVo();
				
				bv.setBdNo(rset.getInt("BD_NO"));
				bv.setBdName(rset.getString("BD_NAME"));
				bv.setBdContents(rset.getString("BD_CONTENTS"));
				bv.setBdWriter(rset.getString("BD_WRITER"));
				bv.setBdWriteDate(rset.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rset.getInt("BD_VIEW_COUNT"));
				bv.setBdRecommendCount(rset.getInt("BD_RECOMMEND_COUNT"));
				bv.setBdCategory(rset.getString("BD_CATEGORY"));
				
				
				
				list.add(bv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String getNoticePageCount(Connection conn, int currentPage, int listPerCountPage, int countPerPage) {
		// 게시물 총개수
		int TotalCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "select count(*) as TotalCount from board_tb where BD_CATEGORY='공지사항'";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				TotalCount = rset.getInt("TotalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		int pageTotalCount = 0;

		if (TotalCount % listPerCountPage != 0) {
			pageTotalCount = TotalCount / listPerCountPage + 1;
		} else {
			pageTotalCount = TotalCount / listPerCountPage;
		}

		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > TotalCount) {
			currentPage = TotalCount;
		}
		// 시작 navi 구하기
		int startCount = ((currentPage - 1) / countPerPage) * countPerPage + 1;
		int endCount = startCount + countPerPage - 1;
		if (endCount > pageTotalCount) {
			endCount = pageTotalCount;
		}

		boolean gotoPrev = true;
		boolean gotoNext = true;
		if (startCount == 1) {
			gotoPrev = false;
		}
		if (endCount == pageTotalCount) {
			gotoNext = false;
		}

		StringBuilder sb = new StringBuilder();
		
		if(gotoPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a class='item' href='/board?currentPage=" + (startCount - 1) + "'><i class='left chevron icon'></i></a>");
		}
		
		for(int i=startCount; i<=endCount; i++) {
			if(i == currentPage) {
				sb.append("<a class='item' href='/board?currentPage=" + i + "'><b> " + i + " </b></a>");
			}
			else {
				sb.append("<a class='item' href='/board?currentPage=" + i + "'> " + i + " </a>");
			}
		}
		
		if(gotoNext) { // 끝 페이지가 아니라면
			sb.append("<a class='item' href='/board?currentPage=" + (endCount + 1) + "'><i class='right chevron icon'></i></a>"); 
		}
		
		return sb.toString();
	}

	public ArrayList<BoardVo> getSearchCurrentPage(Connection conn, int currentPage, int listPerCountPage,
			String search, String searchOption) {
		 //PreparedStatement pstmt =null;
		   Statement stmt = null;
		   ResultSet rset = null;
		   String option = null;
		   // 시작 ,끝 게시물
		   int startTotalBoard = currentPage * listPerCountPage - (listPerCountPage-1);
		   int endTotalBoard = currentPage*listPerCountPage;
		   
		   if(searchOption.equals("title")) {
		      option = "BD_NAME";
		   }else if (searchOption.equals("contents")) {
		      option = "BD_CONTENTS";
		   }else if (searchOption.equals("writer")) {
		      option = "BD_WRITER";
		   }
		   
		   //System.out.println("option값:"+option);
		   
		   
		   String query = "select * from"
		   + " (select Board_tb.*, row_number() over(order by bd_no desc) as num from board_tb where "+option+" like '%" + search + "%') "
		   + "where num between " + startTotalBoard +" and " + endTotalBoard +" and BD_CATEGORY='공지사항'";

		/* System.out.println(query); */
		   
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();

		try {
			stmt = conn.prepareStatement(query);
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				BoardVo board = new BoardVo();
				board.setBdNo(rset.getInt("BD_NO"));
				board.setBdName(rset.getString("BD_NAME"));
				board.setBdCategory(rset.getString("BD_CATEGORY"));
				board.setBdContents(rset.getString("BD_CONTENTS"));
				board.setBdWriter(rset.getString("BD_WRITER"));
				board.setBdWriteDate(rset.getTimestamp("BD_WRITE_DATE"));
				board.setBdViewCount(rset.getInt("BD_VIEW_COUNT"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
			
			/*System.out.println(list);*/
			
		}
		return list;
	}

	public String getSearchPageCount(Connection conn, int currentPage, int listPerCountPage, int countPerPage,
			String search, String searchOption) {
		int TotalCount = 0; //게시물
		   
		   ResultSet rset = null;
		   Statement stmt = null;
		   String option = null;
		   //System.out.println("dao : " +searchOption);
		   if(searchOption.equals("title")) {
		      option = "BD_NAME";
		   }else if(searchOption.equals("contents")){
		      option = "BD_CONTENTS";
		   }else if(searchOption.equals("writer")) {
		      option = "BD_WRITER";
		   }
		   
		   String query = "select count(*) as totalCount from Board_TB where "+ option +" like '%" +search + "%' and BD_CATEGORY='공지사항'";
		   //System.out.println(query);
		   try {
		      stmt = conn.createStatement();
		      rset = stmt.executeQuery(query);

			if (rset.next()) {
				TotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		int pageTotalCount = 0;

		if (TotalCount % listPerCountPage != 0) {
			pageTotalCount = TotalCount / listPerCountPage + 1;
		} else {
			pageTotalCount = TotalCount / listPerCountPage;
		}

		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startCount = ((currentPage - 1) / countPerPage) * countPerPage + 1;
		int endCount = startCount + countPerPage - 1;

		if (endCount > pageTotalCount) {
			endCount = pageTotalCount;
		}

		boolean gotoPrev = true;
		boolean gotoNext = true;
		if (startCount == 1) {
			gotoPrev = false;
		}
		if (endCount == pageTotalCount) {
			gotoNext = false;
		}

		StringBuilder sb = new StringBuilder();

		if (gotoPrev) {
			sb.append("<a class='item' href='/search?searchOption="+searchOption+"&search=" + search + "&currentPage=" + (startCount - 1) + "'><i class='left chevron icon'></i></a>");

		}

		for (int i = startCount; i <= endCount; i++) {
			if (i == currentPage) {
				sb.append("<a class='item' href='/search?searchOption="+searchOption+"&search=" + search + "&currentPage=" + i + "'><b>" + i + "</b></a>");

			} else {
				sb.append("<a class='item' href='/search?searchOption="+searchOption+"&search="+search+"&currentPage=" + i + "'>" + i + "</a>");
			}
		}
		if (gotoNext) {
			sb.append("<a class='item' href='/search?searchOption="+searchOption+"&search=" + search + "&currentPage=" + (endCount + 1) + "'><i class='right chevron icon'></i></a>");
		}

		return sb.toString();
	}
	
	public ArrayList<BoardVo> getSearchReviewCurrentPage(Connection conn, int currentPage, int listPerCountPage,
			String search, String searchOption) {
		 //PreparedStatement pstmt =null;
		   Statement stmt = null;
		   ResultSet rset = null;
		   String option = null;
		   // 시작 ,끝 게시물
		   int startTotalBoard = currentPage * listPerCountPage - (listPerCountPage-1);
		   int endTotalBoard = currentPage*listPerCountPage;
		   
		   if(searchOption.equals("title")) {
		      option = "BD_NAME";
		   }else if (searchOption.equals("contents")) {
		      option = "BD_CONTENTS";
		   }else if (searchOption.equals("writer")) {
		      option = "BD_WRITER";
		   }
		   
		   /*System.out.println("option값:"+option);*/
		   
		   
		   String query = "select * from"
		   + " (select Board_tb.*, row_number() over(order by bd_no desc) as num from board_tb where "+option+" like '%" + search + "%') "
		   + "where num between " + startTotalBoard +" and " + endTotalBoard +"and BD_CATEGORY='후기'";

		ArrayList<BoardVo> list = new ArrayList<BoardVo>();

		try {
			stmt = conn.prepareStatement(query);
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				BoardVo board = new BoardVo();
				board.setBdNo(rset.getInt("BD_NO"));
				board.setBdName(rset.getString("BD_NAME"));
				board.setBdCategory(rset.getString("BD_CATEGORY"));
				board.setBdContents(rset.getString("BD_CONTENTS"));
				board.setBdWriter(rset.getString("BD_WRITER"));
				board.setBdWriteDate(rset.getTimestamp("BD_WRITE_DATE"));
				board.setBdViewCount(rset.getInt("BD_VIEW_COUNT"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return list;
	}

	public String getSearchReviewpageCount(Connection conn, int currentPage, int listPerCountPage, int countPerPage,
			String search, String searchOption) {
		int TotalCount = 0; //게시물
		   
		   ResultSet rset = null;
		   Statement stmt = null;
		   String option = null;
		   //System.out.println("dao : " +searchOption);
		   if(searchOption.equals("title")) {
		      option = "BD_NAME";
		   }else if(searchOption.equals("contents")){
		      option = "BD_CONTENTS";
		   }else if(searchOption.equals("writer")) {
		      option = "BD_WRITER";
		   }
		   
		   String query = "select count(*) as totalCount from Board_TB where "+ option +" like '%" +search + "%' and BD_CATEGORY='후기'";
		  /* System.out.println(query);*/
		   try {
		      stmt = conn.createStatement();
		      rset = stmt.executeQuery(query);

			if (rset.next()) {
				TotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		int pageTotalCount = 0;

		if (TotalCount % listPerCountPage != 0) {
			pageTotalCount = TotalCount / listPerCountPage + 1;
		} else {
			pageTotalCount = TotalCount / listPerCountPage;
		}

		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startCount = ((currentPage - 1) / countPerPage) * countPerPage + 1;
		int endCount = startCount + countPerPage - 1;

		if (endCount > pageTotalCount) {
			endCount = pageTotalCount;
		}

		boolean gotoPrev = true;
		boolean gotoNext = true;
		if (startCount == 1) {
			gotoPrev = false;
		}
		if (endCount == pageTotalCount) {
			gotoNext = false;
		}

		StringBuilder sb = new StringBuilder();
		if (gotoPrev) {
			sb.append("<a class='item' href='/reviewSearch?searchOption="+searchOption+"&search=" + search + "&currentPage=" + (startCount - 1) + "'><i class='left chevron icon'></i></a>");

		}

		for (int i = startCount; i <= endCount; i++) {
			if (i == currentPage) {
				sb.append("<a class='item' href='/reviewSearch?searchOption="+searchOption+"&search=" + search + "&currentPage=" + i + "'><b>" + i + "</b></a>");

			} else {
				sb.append("<a class='item' href='/reviewSearch?searchOption="+searchOption+"&search="+search+"&currentPage=" + i + "'>" + i + "</a>");
			}
		}
		if (gotoNext) {
			sb.append("<a class='item' href='/reviewSearch?searchOption="+searchOption+"&search=" + search + "&currentPage=" + (endCount + 1) + "'><i class='right chevron icon'></i></a>");
		}

		return sb.toString();
	}
	

	public BoardVo noticeSelect(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BoardVo board = null;
		String query = "select * from board_TB where BD_NO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				board = new BoardVo();
				board.setBdNo(rset.getInt("BD_NO"));
				board.setBdName(rset.getString("BD_NAME"));
				board.setBdContents(rset.getString("BD_CONTENTS"));
				board.setBdWriter(rset.getString("BD_WRITER"));
				board.setBdWriteDate(rset.getTimestamp("BD_WRITE_DATE"));
				board.setBdViewCount(rset.getInt("BD_VIEW_COUNT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return board;
	}

	public ArrayList<Comment> Comment(Connection conn, int cmNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from comment_tb where CM_BD_NO=?";
		ArrayList<Comment> list = new ArrayList<Comment>();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, cmNo);

			rset = pstmt.executeQuery();
			while (rset.next()) {
				Comment c = new Comment();
				c.setCmNo(rset.getInt("CM_NO"));
				c.setCmBdNo(rset.getInt("CM_BD_NO"));
				c.setCmContents(rset.getString("CM_CONTENTS"));
				c.setCmWriter(rset.getString("CM_WRITER"));
				c.setCmWriteDate(rset.getTimestamp("CM_WRITE_DATE"));
				c.setCmRecCount(rset.getInt("CM_RECOMMEND_COUNT"));
				list.add(c);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertComment(Connection conn, Comment c) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "insert into comment_tb values (CM_NO_SEQ.nextval,?,?,?,sysdate,default)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, c.getCmBdNo());
			pstmt.setString(2, c.getCmWriter());
			pstmt.setString(3, c.getCmContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateComment(Connection conn, String CM_CONTENTS, int CM_NO) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update comment_tb set CM_CONTENTS=? where CM_NO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, CM_CONTENTS);
			pstmt.setInt(2, CM_NO);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int deleteComment(Connection conn, int CM_NO) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from comment_tb where CM_NO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, CM_NO);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	public int insertNotice(Connection conn, BoardVo board) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "insert into Board_TB values(BD_NO_SEQ.NEXTVAL,?,?,?,sysdate,0,0,'후기')";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBdName());
			pstmt.setString(2, board.getBdContents());
			pstmt.setString(3, board.getBdWriter());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateNotice(Connection conn, BoardVo board) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "update board_tb set BD_NAME=?, BD_CONTENTS=? where BD_NO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, board.getBdName());
			pstmt.setString(2, board.getBdContents());
			pstmt.setInt(3, board.getBdNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int deleteNotice(Connection conn, int bdNo) { // 게시판삭제
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "delete from Board_tb where BD_NO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public int deleteCommentNotice(Connection conn, int bdNo) { // 게시판 삭제하기전 게시판에 달려있는 모든 댓글 삭제
		PreparedStatement pstmt = null;
		int result1 = -1;

		String query = "delete from Comment_tb where CM_BD_NO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			result1 = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result1;
	}

	public int hitsCount(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update BOARD_TB set BD_VIEW_COUNT = BD_VIEW_COUNT+1 where BD_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	// 고객 후기 페이징 처리
	public ArrayList<BoardVo> getReviewCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
	
		int end = currentPage * recordCountPerPage;
	
		
		String query = "select * from " + 
				"(select board_tb.*, row_number() over(order by bd_no desc) as num from board_tb where BD_CATEGORY='후기') " + 
				"where num between ? and ?";
		
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();

			
			while(rset.next()) {
				BoardVo bv = new BoardVo();
				
				bv.setBdNo(rset.getInt("BD_NO"));
				bv.setBdName(rset.getString("BD_NAME"));
				bv.setBdContents(rset.getString("BD_CONTENTS"));
				bv.setBdWriter(rset.getString("BD_WRITER"));
				bv.setBdWriteDate(rset.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rset.getInt("BD_VIEW_COUNT"));
				bv.setBdRecommendCount(rset.getInt("BD_RECOMMEND_COUNT"));
				bv.setBdCategory(rset.getString("BD_CATEGORY"));
				
				list.add(bv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public String getReviewPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		int recordTotalCount = 0;
	
		String query = "select count(*) as totalCount from board_tb where bd_category='후기'";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		int pageTotalCount = 0; // navi 토탈 카운트
		
		
		if(recordTotalCount%recordCountPerPage != 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage +1;
		}
		else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		if(currentPage < 1) currentPage = 1;
		else if(currentPage > pageTotalCount) currentPage = pageTotalCount;
		
	
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;
		
		
		int endNavi = startNavi + naviCountPerPage-1;
		
	
		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		
		boolean needPrev = true;
		boolean needNext = true;
		
		if(startNavi == 1) {
			needPrev = false;
		}
		
		if(endNavi == pageTotalCount){
			needNext = false;
		}
		
		
		StringBuilder sb = new StringBuilder(); 
		
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a class='item' href='/review?currentPage=" + (startNavi - 1) + "'><i class='left chevron icon'></i></a>");
		}
		
		for(int i=startNavi; i<=endNavi; i++) {
			if(i == currentPage) {
				sb.append("<a class='item' href='/review?currentPage=" + i + "'><b> " + i + " </b></a>");
			}
			else {
				sb.append("<a class='item' href='/review?currentPage=" + i + "'> " + i + " </a>");
			}
		}
		
		if(needNext) { // 끝 페이지가 아니라면
			sb.append("<a class='item' href='/review?currentPage=" + (endNavi + 1) + "'><i class='right chevron icon'></i></a>"); 
		}
		
		
		
		return sb.toString();
	}

	public BoardVo selectReview(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BoardVo bv = null;
		
		String query = "select * from BOARD_TB where BD_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bv = new BoardVo();
				
				bv.setBdNo(rset.getInt("BD_NO"));
				bv.setBdName(rset.getString("BD_NAME"));
				bv.setBdContents(rset.getString("BD_CONTENTS"));
				bv.setBdWriter(rset.getString("BD_WRITER"));
				bv.setBdWriteDate(rset.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rset.getInt("BD_VIEW_COUNT"));
				bv.setBdRecommendCount(rset.getInt("BD_RECOMMEND_COUNT"));
				bv.setBdCategory(rset.getString("BD_CATEGORY"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return bv;
	}
	
	public int recommendAdd(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update BOARD_TB set BD_RECOMMEND_COUNT = BD_RECOMMEND_COUNT+1 where BD_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public boolean recommendInquiry(Connection conn, int bdNo, String recommendId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		
		String query = "select * from RECOMMEND_BOARD_TB where MB_ID=? and BD_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, recommendId);
			pstmt.setInt(2, bdNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int recommendInsert(Connection conn, int bdNo, String recommendId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into RECOMMEND_BOARD_TB values (RECOMMEND_BOARD_SEQ.NEXTVAL,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, recommendId);
			pstmt.setInt(2, bdNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public BoardVo boardBdNo(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BoardVo bv = null;
		
		String query = "select * from BOARD_TB where BD_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				bv = new BoardVo();
				bv.setBdNo(rset.getInt("BD_NO"));
				bv.setBdName(rset.getString("BD_NAME"));
				bv.setBdContents(rset.getString("BD_CONTENTS"));
				bv.setBdWriter(rset.getString("BD_WRITER"));
				bv.setBdWriteDate(rset.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rset.getInt("BD_VIEW_COUNT"));
				bv.setBdRecommendCount(rset.getInt("BD_RECOMMEND_COUNT"));
				bv.setBdCategory(rset.getString("BD_CATEGORY"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return bv;
	}
	
	public boolean reViewInsert(Connection conn, BoardVo bv) {
		PreparedStatement pstmt = null;
		int row = 0 ;
		String query = "INSERT INTO BOARD_TB VALUES(BD_NO_SEQ.NEXTVAL,?,?,?,SYSDATE,DEFAULT,DEFAULT,?)";
		boolean result = false;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bv.getBdName());
			pstmt.setString(2, bv.getBdContents());
			pstmt.setString(3, bv.getBdWriter());
			pstmt.setString(4, bv.getBdCategory());
			row = pstmt.executeUpdate();
			if(row>0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public BoardVo reViewSelectOne(Connection conn, BoardVo bv) {
		PreparedStatement pstmt = null;
		BoardVo newBv = null;
		ResultSet rset = null;
		
		String query = "select * from board_tb where bd_name = ? and bd_writer=?";
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, bv.getBdName());
				pstmt.setString(2, bv.getBdWriter());
				
				rset = pstmt.executeQuery();
				if(rset.next()) {
					newBv = new BoardVo();
					newBv.setBdNo(rset.getInt("BD_NO"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
				
			}
			
		return newBv;
	}

	public boolean fileInsert(Connection conn, DataFile dataFile) {
		PreparedStatement pstmt = null;
		String query = "insert into board_file_tb values(BD_FILE_NO_SEQ.NEXTVAL,?,?,SYSDATE,?,0,?,?)";
		int row = 0;
		boolean result = false;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, dataFile.getBdFileSize());
			pstmt.setString(2, dataFile.getBdFileName());
			pstmt.setString(3, dataFile.getBdFileWriter());
			pstmt.setString(4, dataFile.getBdFilePath());
			pstmt.setInt(5, dataFile.getBdFilebdNo());
			row = pstmt.executeUpdate();
			if(row>0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int reviewUpdateImage(Connection conn, long fileSize, String afterPath, String afterFileName, String beforeFileName) {
		PreparedStatement pstmt = null;
		String query = "UPDATE BOARD_FILE_TB SET BD_FILE_SIZE=?, BD_FILE_NAME=?, BD_FILE_UPTIME=SYSDATE, BD_FILE_PATH=? WHERE BD_FILE_PATH=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, fileSize);
			pstmt.setString(2, afterPath);
			pstmt.setString(3, afterFileName);
			pstmt.setString(4, beforeFileName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int reviewDeleteImage(Connection conn, String deleteImage) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM BOARD_FILE_TB WHERE BD_FILE_PATH = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, deleteImage);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteReview(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		int result = 0;

		String query = "delete from Board_tb where BD_NO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public ArrayList<DataFile> deleteImageFile(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<DataFile> list = new ArrayList<DataFile>();
		
		String query = "SELECT * FROM BOARD_FILE_TB WHERE BD_FILE_BD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				DataFile df = new DataFile();
				df.setBdFilePath(rset.getString("BD_FILE_PATH"));
				list.add(df);
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


	public boolean reViewUpdate(Connection conn, BoardVo bv) {
		int row = 0;
		PreparedStatement pstmt = null;
		String query = "update board_tb set BD_NAME=?, BD_CONTENTS=? where BD_NO=?";
		boolean result = false;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bv.getBdName());
			pstmt.setString(2, bv.getBdContents());
			pstmt.setInt(3, bv.getBdNo());
			row = pstmt.executeUpdate();
			if(row>0) {
				result = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
  return result;
}

	public int recommendConfirm(Connection conn, int bdNo, String rmId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = "SELECT * FROM RECOMMEND_BOARD_TB WHERE BD_NO=? and MB_ID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			pstmt.setString(2, rmId);
			rset = pstmt.executeQuery();
			if(rset.next())
			{
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
