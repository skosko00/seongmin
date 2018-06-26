package jsp.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import jsp.admin.model.vo.BoardTotalInfoVo;
import jsp.board.model.dao.BoardDao;
import jsp.board.model.vo.BoardVo;
import jsp.board.model.vo.Comment;
import jsp.board.model.vo.DataFile;
import jsp.board.model.vo.Page;
import jsp.common.JDBCTemplate;

public class BoardService {
	Connection conn = null;

	public BoardService() {

	}

	public Page selectAll(int currentPage) {
		conn = JDBCTemplate.getConnect(conn);
	
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		

		ArrayList<BoardVo> list = new BoardDao().getNoticeCurrentPage(conn, currentPage, recordCountPerPage);
		String pageCount = new BoardDao().getNoticePageCount(conn, currentPage, recordCountPerPage, naviCountPerPage);

		
		Page page = null;
		if (!list.isEmpty() && !pageCount.isEmpty()) {
			page = new Page();
			page.setList(list);
			page.setPageCount(pageCount);
		}
		JDBCTemplate.close(conn);

		return page;
	}

	public Page searchNotice(int currentPage, String search, String searchOption) {
		conn = JDBCTemplate.getConnect(conn);

		int recordCountPerPage = 10;
		int naviCountPerPage = 5;

		ArrayList<BoardVo> list = new BoardDao().getSearchCurrentPage(conn, currentPage, recordCountPerPage,search,searchOption);
		String pageCount = new BoardDao().getSearchPageCount(conn,currentPage,recordCountPerPage,naviCountPerPage,search,searchOption);
		
		Page page = null;

		if (!list.isEmpty() && !pageCount.isEmpty()) {
			page = new Page();
			page.setList(list);
			page.setPageCount(pageCount);

		}

		JDBCTemplate.close(conn);

		return page;
	}
	
	public Page searchReview(int currentPage, String search, String searchOption) {
		conn = JDBCTemplate.getConnect(conn);

		int recordCountPerPage = 10;
		int naviCountPerPage = 5;

		ArrayList<BoardVo> list = new BoardDao().getSearchReviewCurrentPage(conn, currentPage, recordCountPerPage,search,searchOption);
		String pageCount = new BoardDao().getSearchReviewpageCount(conn,currentPage,recordCountPerPage,naviCountPerPage,search,searchOption);
		
		Page page = null;

		if (!list.isEmpty() && !pageCount.isEmpty()) {
			page = new Page();
			page.setList(list);
			page.setPageCount(pageCount);

		}

		JDBCTemplate.close(conn);

		return page;
	}

	public BoardVo noticeSelect(int bdNo) {
		conn = JDBCTemplate.getConnect(conn);
		BoardVo board = new BoardDao().noticeSelect(conn, bdNo);
		JDBCTemplate.close(conn);
		return board;
	}

	public ArrayList<Comment> Comment(int cmNo) {
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<Comment> list = new BoardDao().Comment(conn, cmNo);

		return list;
	}

	public int insertComment(Comment c) {
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().insertComment(conn, c);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateComment(String CM_CONTENTS, int CM_NO) {
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().updateComment(conn, CM_CONTENTS, CM_NO);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteComment(int CM_NO) {
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().deleteComment(conn, CM_NO);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	public int insertNotice(BoardVo board) {

		conn = JDBCTemplate.getConnect(conn);

		int result = new BoardDao().insertNotice(conn, board);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	}

	public int updateNotice(BoardVo board) {
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().updateNotice(conn, board);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}

		JDBCTemplate.close(conn);

		return result;
	}

	public int deleteNotice(int bdNo) {
		conn = JDBCTemplate.getConnect(conn);

		int result = new BoardDao().deleteNotice(conn, bdNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteCommentNotice(int bdNo) {
		conn = JDBCTemplate.getConnect(conn);

		int result1 = new BoardDao().deleteCommentNotice(conn, bdNo);

		if (result1 > 0) {
			JDBCTemplate.commit(conn);
		} else if (result1 < -2) {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result1;
	}

	public int hitsCount(int bdNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().hitsCount(conn, bdNo);
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public Page reviewAll(int currentPage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		
		int recordCountPerPage = 10;
		int naviCountPerPage = 5;
		
		ArrayList<BoardVo> list = new BoardDao().getReviewCurrentPage(conn, currentPage, recordCountPerPage);
		String pageNavi = new BoardDao().getReviewPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);
		
		Page p = null;
		
		if(!list.isEmpty() && !pageNavi.isEmpty()) {
			p = new Page();
			p.setList(list);
			p.setPageCount(pageNavi);
		}
		
		JDBCTemplate.close(conn);
		return p;
	}

	public BoardVo selectReview(int bdNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		BoardVo bv = new BoardDao().selectReview(conn, bdNo);
		JDBCTemplate.close(conn);
		return bv;
	}
	
	public int recommendAdd(int bdNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().recommendAdd(conn, bdNo);
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean recommendInquiry(int bdNo, String recommendId) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		boolean result = new BoardDao().recommendInquiry(conn, bdNo, recommendId);
		JDBCTemplate.close(conn);
		return result;
	}

	public int recommendInsert(int bdNo, String recommendId) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().recommendInsert(conn, bdNo, recommendId);
		if(result > 0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollBack(conn);
		return result;
	}
	
	public BoardVo boardBdNo(int bdNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		BoardVo bv = new BoardDao().boardBdNo(conn, bdNo);
		JDBCTemplate.close(conn);
		return bv;
	}
	public boolean reViewInsert(BoardTotalInfoVo btlv) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		boolean totalResult = false;
		// int sucess = 0;
		//1. 게시판 등록
		boolean boardResult = new BoardDao().reViewInsert(conn,btlv.getBv());
		//2. 게시판 파일 등록
		// 필요한 정보 -> 게시판 번호...
		// 게시판 번호 가져오기
		//TODO: 야매
		
		int bdNo = new BoardDao().reViewSelectOne(conn,btlv.getBv()).getBdNo();
		boolean fileResult[] = new boolean[btlv.getList().size()];
		
		//3. 게시판에 첨부파일 추가
		boolean picResultFinal = true;
		for (int i = 0; i < btlv.getList().size(); i++) {
			btlv.getList().get(i).setBdFilebdNo(bdNo);
			fileResult[i] = new BoardDao().fileInsert(conn, btlv.getList().get(i));
			
			if(!fileResult[i]) {
				picResultFinal = false;
			}
		}
		
		totalResult = boardResult && picResultFinal;
		//최종결과
		if(totalResult) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		
		return totalResult;
	}

	public int reviewUpdateImage(long fileSize, String afterFileName, String afterPath, String beforeFileName) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().reviewUpdateImage(conn, fileSize, afterFileName, afterPath, beforeFileName);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else {
		JDBCTemplate.rollBack(conn);	
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int reviewDeleteImage(String deleteImage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().reviewDeleteImage(conn,deleteImage);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else {
		JDBCTemplate.rollBack(conn);	
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteReview(int bdNo) {
		conn = JDBCTemplate.getConnect(conn);

		int result = new BoardDao().deleteReview(conn, bdNo);

		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<DataFile> deleteImageFile(int bdNo) {
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<DataFile> list = new BoardDao().deleteImageFile(conn, bdNo);
		JDBCTemplate.close(conn);
		return list;
	}


	public boolean reViewUpdate(BoardTotalInfoVo btlv) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		boolean totalResult = false;
		// int sucess = 0;
		//1. 게시판 등록
		boolean boardResult = new BoardDao().reViewUpdate(conn,btlv.getBv());
		//2. 게시판 파일 등록
		// 필요한 정보 -> 게시판 번호...
		// 게시판 번호 가져오기
		//TODO: 야매
		
		int bdNo = btlv.getBv().getBdNo();
		boolean fileResult[] = new boolean[btlv.getList().size()];
		
		//3. 게시판에 첨부파일 추가
		boolean picResultFinal = true;
		for (int i = 0; i < btlv.getList().size(); i++) {
			btlv.getList().get(i).setBdFilebdNo(bdNo);
			fileResult[i] = new BoardDao().fileInsert(conn, btlv.getList().get(i));
			
			if(!fileResult[i]) {
				picResultFinal = false;
			}
		}
		
		totalResult = boardResult && picResultFinal;
		//최종결과
		if(totalResult) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		
		return totalResult;
}
	public int recommendConfirm(int bdNo, String rmId) {
		conn = JDBCTemplate.getConnect(conn);
		int result = new BoardDao().recommendConfirm(conn, bdNo, rmId);
		JDBCTemplate.close(conn);
		return result;
	}

}
