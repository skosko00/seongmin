package jsp.admin.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import jsp.admin.model.dao.AdminDao;
import jsp.admin.model.vo.AnswerVo;
import jsp.admin.model.vo.BoardAdminPageVo;
import jsp.admin.model.vo.BoardTotalInfoVo;
import jsp.admin.model.vo.LoginLogPageVo;
import jsp.admin.model.vo.MemberLoginLogVo;
import jsp.admin.model.vo.MemberPageVo;
import jsp.admin.model.vo.QnAVo;
import jsp.admin.model.vo.QuestionPageVo;
import jsp.admin.model.vo.ReserveCancelPageVo;
import jsp.admin.model.vo.ReserveHistoryPageVo;
import jsp.admin.model.vo.ReservePageVo;
import jsp.admin.model.vo.RoomTotalInfoVo;
import jsp.admin.model.vo.SalesPageVo;
import jsp.board.model.vo.BoardVo;
import jsp.board.model.vo.DataFile;
import jsp.common.JDBCTemplate;
import jsp.main.model.dao.MainDao;
import jsp.main.model.vo.MainPicTb;
import jsp.main.model.vo.PensionPicTb;
import jsp.member.model.vo.MemberVo;
import jsp.member.model.vo.QuestionVo;
import jsp.reservation.model.vo.PensionVo;
import jsp.reservation.model.vo.ReservationCancelVo;
import jsp.reservation.model.vo.ReservationHistoryVo;
import jsp.reservation.model.vo.ReservationVo;
import jsp.reservation.model.vo.SalesVo;
@SuppressWarnings("all")
public class AdminService {
	public AdminService() {
	}

	// AdminDao 연결
	private AdminDao aDao = new AdminDao();

	public ArrayList<PensionVo> AllRoomList() {

		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<PensionVo> list = new AdminDao().AllRoomList(conn);
		JDBCTemplate.close(conn);

		return list;
	}

	// 객실 정보 등록
	public boolean insertRoom(PensionVo pv) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		boolean result = new AdminDao().insertRoom(conn, pv);
		if (result) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public MemberPageVo memberList(int currentPage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		// Service 에서는 2가지 값을 정해야 함
		// 1. 한 페이지 당 보이는 리스트의 개수(게시물의 개수)
		// 2. 현재 위치를 중심으로 시작 navi에서부터 끝 navi개수
		int recordCountPerPage = 10; // 한 페이지당 갯수
		int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

		// 1. 현재 페이지 리스트
		ArrayList<MemberVo> list = new AdminDao().getMemberCurrentPage(conn, currentPage, recordCountPerPage);

		// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
		String pageNavi = new AdminDao().getMemberPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

		MemberPageVo mpv = null;
		/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
			mpv = new MemberPageVo(list, pageNavi);
		/*}*/
		JDBCTemplate.close(conn);
		return mpv;
	}

	// 게시판
	public BoardAdminPageVo boardList(int currentPage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int recordCountPerPage = 10; // 한 페이지당 갯수
		int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

		// 1. 현재 페이지 리스트
		ArrayList<BoardVo> list = new AdminDao().getBoardCurrentPage(conn, currentPage, recordCountPerPage);

		// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
		String pageNavi = new AdminDao().getBoardPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

		BoardAdminPageVo bpv = null;
		/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
			bpv = new BoardAdminPageVo(list, pageNavi);
		/*}*/
		JDBCTemplate.close(conn);
		return bpv;
	}

	// 메인 템플릿들 변경
	public int mainupdateSelect(String value, String update) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = aDao.mainupdateSelect(conn, value, update);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	// 예약 정보 시작

	public ReservePageVo reserveList(int currentPage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		// Service 에서는 2가지 값을 정해야 함
		// 1. 한 페이지 당 보이는 리스트의 개수(게시물의 개수)
		// 2. 현재 위치를 중심으로 시작 navi에서부터 끝 navi개수
		int recordCountPerPage = 10; // 한 페이지당 갯수
		int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

		// 1. 현재 페이지 리스트
		ArrayList<ReservationVo> list = new AdminDao().getReserveCurrentPage(conn, currentPage, recordCountPerPage);

		// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
		String pageNavi = new AdminDao().getReservePageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

		ReservePageVo rpv = null;
		/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
			rpv = new ReservePageVo(list, pageNavi);
		/*}*/
		JDBCTemplate.close(conn);
		return rpv;
	}

	// 매출 정보
	public SalesPageVo salesList(int currentPage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		// Service 에서는 2가지 값을 정해야 함
		// 1. 한 페이지 당 보이는 리스트의 개수(게시물의 개수)
		// 2. 현재 위치를 중심으로 시작 navi에서부터 끝 navi개수
		int recordCountPerPage = 10; // 한 페이지당 갯수
		int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

		// 1. 현재 페이지 리스트
		ArrayList<SalesVo> list = new AdminDao().getSalesCurrentPage(conn, currentPage, recordCountPerPage);

		// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
		String pageNavi = new AdminDao().getSalesPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

		SalesPageVo spv = null;
		/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
			spv = new SalesPageVo(list, pageNavi);
		/*}*/
		JDBCTemplate.close(conn);
		return spv;

	}

	// 전체 질문 보기
	public QuestionPageVo questionList(int currentPage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		
		int recordCountPerPage = 10; // 한 페이지당 갯수
		int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

		// 1. 현재 페이지 리스트
		ArrayList<QuestionVo> list = new AdminDao().getQuestionCurrentPage(conn, currentPage, recordCountPerPage);

		// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
		String pageNavi = new AdminDao().getQuestionPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

		QuestionPageVo qpv = null;
		/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
			qpv = new QuestionPageVo(list, pageNavi);
		/*}*/
		JDBCTemplate.close(conn);
		return qpv;
	}

	public QnAVo selectOneQuestion(int qNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		// 질문 가져오기
		QuestionVo qv = new AdminDao().selectOneQuestion(conn, qNo);
		// 답변 가져오기
		AnswerVo asv = new AdminDao().selectAnswer(conn, qNo);
		QnAVo qnaVo = new QnAVo(qv, asv);

		JDBCTemplate.close(conn);
		return qnaVo;

	}

	public boolean insertAnswer(AnswerVo asv) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		// 1. 답변 생성
		boolean result1 = new AdminDao().insertAnswer(conn, asv);
		// 2. 문의 테이블의 답변 여부 y 로 변경
		boolean result2 = new AdminDao().answerRegistration(conn,asv.getaQNo());
		boolean result = result1&&result2;
		if (result) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);

		return result;
	};

	//

	public boolean roomInsert(RoomTotalInfoVo ptlv) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		boolean totalResult = false;

		// 1. 객실 등록
		boolean roomResult = new AdminDao().roomInsert(conn, ptlv.getPv());
		// 2. 객실 사진 등록
		boolean picResult[] = new boolean[ptlv.getList().size()];
		boolean picResultFianl = true;
		for (int i = 0; i < ptlv.getList().size(); i++) {
			picResult[i] = new AdminDao().picInsert(conn, ptlv.getList().get(i));
			
			if (!picResult[i]) {
				picResultFianl = false;
			}
		}

		totalResult = roomResult && picResultFianl;
		// 최종 결과
		
		if (totalResult) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return totalResult;
	}

	// 객실 정보 사진과 함께 모두 가져오기
	public RoomTotalInfoVo selectRoomInfo(String psName) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);

		PensionVo pv = new AdminDao().selectRoomInfo(conn, psName);
		ArrayList<PensionPicTb> list = new MainDao().roomInfo(conn, psName);

		RoomTotalInfoVo rtiv = new RoomTotalInfoVo(pv, list);

		JDBCTemplate.close(conn);
		return rtiv;
	}

	/*public ArrayList<MemberLoginLogVo> selectAllMemberLog(int currentPage) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<MemberLoginLogVo> list = new AdminDao().selectAllMemberLog(conn);
		JDBCTemplate.close(conn);
		return list;
	}*/

	public int mainInsert(ArrayList<MainPicTb> mptlist) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = 0;

		for(int i=0; i<mptlist.size(); i++)
		{
			result += aDao.mainInsert(conn,mptlist.get(i).getMainPicPath());
		}
		if(result==mptlist.size())
		{
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
		
	}

	public int updateImage(String afterPath, String beforeFileName) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = aDao.updateImage(conn, afterPath, beforeFileName);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else {
		JDBCTemplate.rollBack(conn);	
		}
		return result;
	}
	
	// 예약 정보를 가져오는 쿼리 (달력에서)
		public ReservationVo selectOneReservation(String roomName, Date comDate) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			ReservationVo rv = new AdminDao().selectOneReservation(conn, roomName,comDate);
			JDBCTemplate.close(conn);
			return rv;
		}

		public boolean boardInsert(BoardTotalInfoVo btlv) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			boolean totalResult = false;
			int success = 0;
			// 1. 게시판 등록
			boolean boardResult = new AdminDao().boardInsert(conn, btlv.getBv());
			// 2. 게시판 파일 등록
			// 필요한 정보 -> 게시판 번호... 
			// 게시판 번호 가져오기
			// TODO: 야매
			int bdNo = new AdminDao().boardSelectOne(conn,btlv.getBv()).getBdNo();
			boolean fileResult[] = new boolean[btlv.getList().size()];
			
			// 3. 게시판에 첨부파일 추가
			boolean picResultFianl = true;
			for (int i = 0; i < btlv.getList().size(); i++) {
				btlv.getList().get(i).setBdFilebdNo(bdNo);
				fileResult[i] = new AdminDao().fileInsert(conn, btlv.getList().get(i));
				
				if (!fileResult[i]) {
					picResultFianl = false;
				}
			}

			totalResult = boardResult && picResultFianl;
			// 최종 결과
			if (totalResult) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollBack(conn);
			}
			JDBCTemplate.close(conn);
			return totalResult;
		}

		public BoardTotalInfoVo selectBoardOne(int bdNo) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);

			BoardTotalInfoVo btlv = null;
			BoardVo bv = new AdminDao().selectBoardOne(conn,bdNo);
			ArrayList<DataFile> list = new AdminDao().selectBoardFiles(conn,bdNo);
			btlv = new BoardTotalInfoVo(bv, list);
			JDBCTemplate.close(conn);
			return btlv;
		}	

		public ReservePageVo reserveList(int currentPage, String searchData, String searchOption) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			int recordCountPerPage = 10; // 한 페이지당 갯수
			int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

			// 1. 현재 페이지 리스트
			ArrayList<ReservationVo> list = new AdminDao().getReserveCurrentPage(conn, currentPage, recordCountPerPage,searchData, searchOption);
			
			// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
			String pageNavi = new AdminDao().getReservePageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,  searchData,  searchOption);

			ReservePageVo rpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				rpv = new ReservePageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return rpv;
		}

		public MemberPageVo memberList(int currentPage, String searchData, String searchOption) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			int recordCountPerPage = 10; // 한 페이지당 갯수
			int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

			// 1. 현재 페이지 리스트
			ArrayList<MemberVo> list = new AdminDao().getMemberCurrentPage(conn, currentPage, recordCountPerPage, searchData,searchOption);

			// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
			String pageNavi = new AdminDao().getMemberPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,searchData,searchOption);

			MemberPageVo mpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				mpv = new MemberPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return mpv;
		}

		public LoginLogPageVo selectAllMemberLog(int currentPage) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			int recordCountPerPage = 10; // 한 페이지당 갯수
			int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

			// 1. 현재 페이지 리스트
			ArrayList<MemberLoginLogVo> list = new AdminDao().getLoginLogPage(conn, currentPage, recordCountPerPage);

			// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
			String pageNavi = new AdminDao().getLoginLogPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

			LoginLogPageVo llpv = null;
			
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				llpv = new LoginLogPageVo(list, pageNavi);
		/*}*/
			JDBCTemplate.close(conn);
			return llpv;
		}

		public LoginLogPageVo selectAllMemberLog(int currentPage, String searchData, String searchOption) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			int recordCountPerPage = 10; // 한 페이지당 갯수
			int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

			// 1. 현재 페이지 리스트
			ArrayList<MemberLoginLogVo> list = new AdminDao().getLoginLogPage(conn, currentPage, recordCountPerPage,searchData,searchOption);

			// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
			String pageNavi = new AdminDao().getLoginLogPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,searchData,searchOption);

			LoginLogPageVo llpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				llpv = new LoginLogPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return llpv;
		}

		public QuestionPageVo questionList(int currentPage, String searchData, String searchOption) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			int recordCountPerPage = 10; // 한 페이지당 갯수
			int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

			// 1. 현재 페이지 리스트
			ArrayList<QuestionVo> list = new AdminDao().getQuestionCurrentPage(conn, currentPage, recordCountPerPage,searchData,searchOption);

			// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
			String pageNavi = new AdminDao().getQuestionPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,searchData,searchOption);

			QuestionPageVo qpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				qpv = new QuestionPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return qpv;
		}

		public BoardAdminPageVo boardList(int currentPage, String searchData, String searchOption) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int recordCountPerPage = 10; // 한 페이지당 갯수
			int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

			// 1. 현재 페이지 리스트
			ArrayList<BoardVo> list = new AdminDao().getBoardCurrentPage(conn, currentPage, recordCountPerPage, searchData, searchOption);

			// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
			String pageNavi = new AdminDao().getBoardPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,searchData, searchOption);

			BoardAdminPageVo bpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				bpv = new BoardAdminPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return bpv;
		}

		public int roomUpdateImage(String afterPath, String beforeFileName) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int result = aDao.roomUpdateImage(conn, afterPath, beforeFileName);
			if(result>0)
			{
				JDBCTemplate.commit(conn);
			}else {
			JDBCTemplate.rollBack(conn);	
			}
			JDBCTemplate.close(conn);
			return result;
		}

		public int roomDeleteImage(String deleteImage) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int result = aDao.roomDeleteImage(conn,deleteImage);
			if(result>0)
			{
				JDBCTemplate.commit(conn);
			}else {
			JDBCTemplate.rollBack(conn);	
			}
			JDBCTemplate.close(conn);
			return result;
		}

		public SalesPageVo salesList(int currentPage, String searchData, String searchOption) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			// Service 에서는 2가지 값을 정해야 함
			// 1. 한 페이지 당 보이는 리스트의 개수(게시물의 개수)
			// 2. 현재 위치를 중심으로 시작 navi에서부터 끝 navi개수
			int recordCountPerPage = 10; // 한 페이지당 갯수
			int naviCountPerPage = 10; // 페이지가 몇개씩 보일지

			// 1. 현재 페이지 리스트
			ArrayList<SalesVo> list = new AdminDao().getSalesCurrentPage(conn, currentPage, recordCountPerPage,searchData,searchOption);

			// 2. 현재 중심으로 만들어지는 NAVI 리스트(문자열)
			String pageNavi = new AdminDao().getSalesPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,searchData,searchOption);

			SalesPageVo spv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				spv = new SalesPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return spv;
		}
		
		// 회원 정보 엑셀 다운로드을 위한 멤버 리스트 출력
		public ArrayList<MemberVo> memberListDown() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			ArrayList<MemberVo> list = aDao.allMemberList(conn);
			JDBCTemplate.close(conn);
			return list;
		}
  
  		// 메인 사진 업데이트 서비스
		public int mainUpdateImage(String afterPath, String beforeFileName) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int result = aDao.mainUpdateImage(conn, afterPath, beforeFileName);
			if(result>0)
			{
				JDBCTemplate.commit(conn);
			}else {
			JDBCTemplate.rollBack(conn);	
			}
			JDBCTemplate.close(conn);
			return result;
		}

		// 메인 사진 삭제 서비스
		public int mainDeleteImage(String deleteImage) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int result = aDao.mainDeleteImage(conn,deleteImage);
			if(result>0)
			{
				JDBCTemplate.commit(conn);
			}else {
			JDBCTemplate.rollBack(conn);	
			}
			JDBCTemplate.close(conn);
			return result;
		}

		public boolean updateRoomText(PensionVo pv) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			boolean result = false;
			result = aDao.updateRoomText(conn,pv);
			if(result) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollBack(conn);
			}
			JDBCTemplate.close(conn);
			return result;
		}
		// 로그인 기록 엑셀 다운
		public ArrayList<MemberLoginLogVo> memberLogListDown() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			ArrayList<MemberLoginLogVo> list = aDao.memberLogListDown(conn);
			JDBCTemplate.close(conn);
			return list;
		}
		// 예약 정보 엑셀 다운 
		public ArrayList<ReservationVo> reservationListDown() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			ArrayList<ReservationVo> list = aDao.reservationListDown(conn);
			JDBCTemplate.close(conn);
			return list;
		}
		// 게시판 삭제
		public boolean boardCompleteDel(int bdNo) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int totalResult = aDao.boardCompleteDel(conn,bdNo);
			boolean result = false;
			if(totalResult>0) {
				JDBCTemplate.commit(conn);
				result = true;
			}else {
				JDBCTemplate.rollBack(conn);
			}
			JDBCTemplate.close(conn);
			return result;
		}
		// 파일 목록 가져오기
		public ArrayList<DataFile> boardFileList(int bdNo) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			ArrayList<DataFile> list = aDao.boardFileList(conn, bdNo);
			JDBCTemplate.close(conn);
			return list;
		}
		
		// 지은 추가
		public ReserveCancelPageVo reserveCancelList(int currentPage, String searchData, String searchOption) {
			
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			int recordCountPerPage = 10;
			int naviCountPerPage = 10;
			
			ArrayList<ReservationCancelVo> list = new AdminDao().getReserveCancelCurrentPage(conn, currentPage, recordCountPerPage,searchData, searchOption);

			String pageNavi = new AdminDao().getReserveCancelPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,  searchData,  searchOption);

			ReserveCancelPageVo rcpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				rcpv = new ReserveCancelPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return rcpv;
			
		}

		public ReserveCancelPageVo reserveCancelList(int currentPage) {
			
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);

			int recordCountPerPage = 10;
			int naviCountPerPage = 10; 

			ArrayList<ReservationCancelVo> list = new AdminDao().getReserveCancelCurrentPage(conn, currentPage, recordCountPerPage);

			String pageNavi = new AdminDao().getReserveCancelPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

			ReserveCancelPageVo rcpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				rcpv = new ReserveCancelPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return rcpv;
		}

		public ReserveHistoryPageVo reserveHistoryList(int currentPage, String searchData, String searchOption) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			
			int recordCountPerPage = 10; 
			int naviCountPerPage = 10; 


			ArrayList<ReservationHistoryVo> list = new AdminDao().getReserveHistoryCurrentPage(conn, currentPage, recordCountPerPage,searchData, searchOption);

			String pageNavi = new AdminDao().getReserveHistoryPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage,  searchData,  searchOption);

			ReserveHistoryPageVo rhpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				rhpv = new ReserveHistoryPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return rhpv;
		}

		public ReserveHistoryPageVo reserveHistoryList(int currentPage) {
			
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);

			int recordCountPerPage = 10; 
			int naviCountPerPage = 10; 


			ArrayList<ReservationHistoryVo> list = new AdminDao().getReserveHistoryCurrentPage(conn, currentPage, recordCountPerPage);

			String pageNavi = new AdminDao().getReserveHistoryPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage);

			ReserveHistoryPageVo rhpv = null;
			/*if (!list.isEmpty() && !pageNavi.isEmpty()) {*/
				rhpv = new ReserveHistoryPageVo(list, pageNavi);
			/*}*/
			JDBCTemplate.close(conn);
			return rhpv;
		}

		public ArrayList<PensionPicTb> delPicList(String roomName) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			ArrayList<PensionPicTb> list = aDao.delPicList(conn,roomName);
			
			JDBCTemplate.close(conn);
			
			return list;
		}

		public boolean roomDeleteFinal(String roomName,int size) {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			boolean result = false;
			// 1. 사진 삭제
			int row = aDao.roomDeletePics(conn, roomName);
			if(row==size) {
				// 2. 방 삭제
				boolean resultRoom = aDao.roomDeleteFinal(conn, roomName);
				if(resultRoom) {
					JDBCTemplate.commit(conn);
					result = true;
				}else {
					JDBCTemplate.rollBack(conn);
				}
			}
			return result;
		}

		public int countReserve() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int result = aDao.countReserve(conn);
			JDBCTemplate.close(conn);
			return result;

		}

		public int countQuesetion() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int result = aDao.countQuesetion(conn);
			JDBCTemplate.close(conn);
			return result;
		}

		public int countNewMember() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			int result = aDao.countNewMember(conn);
			JDBCTemplate.close(conn);
			return result;
		}

		public ArrayList<BoardVo> indexBoardList() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			 ArrayList<BoardVo> list = aDao.indexBoardList(conn);
			 JDBCTemplate.close(conn);
			 return list;
		}

		public ArrayList<QuestionVo> indexQuestionList() {
			Connection conn = null;
			conn = JDBCTemplate.getConnect(conn);
			 ArrayList<QuestionVo> list = aDao.indexQuestionList(conn);
			 JDBCTemplate.close(conn);
			 return list;
		}
}