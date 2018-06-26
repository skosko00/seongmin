package jsp.admin.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import jsp.admin.model.vo.AnswerVo;
import jsp.admin.model.vo.MemberLoginLogVo;
import jsp.board.model.vo.BoardVo;
import jsp.board.model.vo.DataFile;
import jsp.common.JDBCTemplate;
import jsp.main.model.vo.PensionPicTb;
import jsp.member.model.vo.MemberVo;
import jsp.member.model.vo.QuestionVo;
import jsp.reservation.model.vo.PensionVo;
import jsp.reservation.model.vo.ReservationCancelVo;
import jsp.reservation.model.vo.ReservationHistoryVo;
import jsp.reservation.model.vo.ReservationVo;
import jsp.reservation.model.vo.SalesVo;

public class AdminDao {
	// TODO: properties에서 값을 불러오는 방식으로 변경해야 함.

	private PreparedStatement pstmt = null;
	// private ResultSet rset = null;
	private Properties prop = new Properties();

	// properties 쓰기 위해 만듬
	public AdminDao() {
		String path = AdminDao.class.getResource("").getPath();
		try {
			prop.load(new FileReader(path + "query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 객실 정보 불러오는 함수
	public ArrayList<PensionVo> AllRoomList(Connection conn) {
		ArrayList<PensionVo> list = new ArrayList<PensionVo>();
		Statement stmt = null;
		ResultSet rs = null;
		String query ="select * from PENSION_TB ";

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				PensionVo pv = new PensionVo();

				pv.setPsName(rs.getString("ps_name"));
				pv.setPsPersonnel(rs.getInt("ps_personnel"));
				pv.setPsMaxPersonnel(rs.getInt("ps_max_personnel"));
				pv.setPsContents(rs.getString("ps_contents"));
				pv.setPsWeekend(rs.getInt("ps_weekend"));
				pv.setPsWeekday(rs.getInt("ps_weekday"));
				pv.setPsAddtionalPrice(rs.getInt("ps_additional_price"));

				list.add(pv);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}

		return list;
	}

	// 객실 정보를 등록하는 함수
	public boolean insertRoom(Connection conn, PensionVo pv) {
		PreparedStatement pstmt = null;
		boolean result = false;
		int row = 0;
		String query ="insert into Pension_tb values(?,?,?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pv.getPsName());
			pstmt.setInt(2, pv.getPsPersonnel());
			pstmt.setInt(3, pv.getPsMaxPersonnel());
			pstmt.setString(4, pv.getPsContents());
			pstmt.setInt(5, pv.getPsWeekend());
			pstmt.setInt(6, pv.getPsWeekday());
			pstmt.setInt(7, pv.getPsAddtionalPrice());
			row = pstmt.executeUpdate();
			if(row>0) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}


	// 회원 전체 보기 중에서... 
	// 1.
	public ArrayList<MemberVo> getMemberCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select member_tb.* , row_number() over(order by MB_ID desc) as num from member_tb) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo mv = new MemberVo();
				mv.setMbId(rs.getString(1));
				mv.setMbPwd(rs.getString(2));
				mv.setMbBirth(rs.getDate(3));
				mv.setMbEmail(rs.getString(4));
				mv.setMbPhone(rs.getString(5));
				mv.setMbGender(rs.getString(6));
				mv.setMbName(rs.getString(7));
				mv.setMbEntDate(rs.getDate(8));
				mv.setMbAddress(rs.getString(9));
				list.add(mv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}	
		return list;
	}

	// 회원 전체 보기 중에서
	// 2.
	public String getMemberPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*) as totalCount from member_tb";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어줘야 한다.
		// 현재 페이지가 1이라면... 1~5 
		// 현재 페이기자 3이라면 ... 1~5 
		// 현재 페이지가 7이라면 ... 6 ~ 10 
		// 현재 페이지가 11 이라면 ... 11 ~ 15 
		// ((현재페이지-1)/리스트개수)*리스트 개수 +1 -> 몫으로 게산을 한다...
		// 전제 조건 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminMemberList?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminMemberList?currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminMemberList?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminMemberList?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminMemberList?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminMemberList?currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	// 1. 게시판
	public ArrayList<BoardVo> getBoardCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select board_tb.* , row_number() over(order by bd_no desc) as num from board_tb where bd_category=?) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"공지사항");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVo bv = new BoardVo();
				bv.setBdNo(rs.getInt("BD_NO"));
				bv.setBdName(rs.getString("BD_NAME"));
				bv.setBdContents(rs.getString("BD_CONTENTS"));
				bv.setBdWriter(rs.getString("BD_WRITER"));
				bv.setBdWriteDate(rs.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rs.getInt("BD_VIEW_COUNT"));
				bv.setBdRecommendCount(rs.getInt("BD_RECOMMEND_COUNT"));
				bv.setBdCategory(rs.getString("BD_CATEGORY"));
				list.add(bv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}
	// 2. 게시판
	public String getBoardPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*) as totalCount from board_tb where bd_category=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "공지사항");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어줘야 한다.
		// 현재 페이지가 1이라면... 1~5 
		// 현재 페이기자 3이라면 ... 1~5 
		// 현재 페이지가 7이라면 ... 6 ~ 10 
		// 현재 페이지가 11 이라면 ... 11 ~ 15 
		// ((현재페이지-1)/리스트개수)*리스트 개수 +1 -> 몫으로 게산을 한다...
		// 전제 조건 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminBoardList?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminBoardList?currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminBoardList?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminBoardList?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminBoardList?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminBoardList?currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	// 예약 정보
	public ArrayList<ReservationVo> getReserveCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReservationVo> list = new ArrayList<ReservationVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select reservation_tb.* , row_number() over(order by res_no desc) as num from reservation_tb) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReservationVo rv = new ReservationVo();
				rv.setResNo(rs.getInt("res_no"));
				rv.setResRoomName(rs.getString("res_room_name"));
				rv.setResId(rs.getString("res_id"));
				rv.setResPersonnel(rs.getInt("res_personnel"));
				rv.setResReservationDate(rs.getTimestamp("res_reservation_date"));
				rv.setResInDate(rs.getDate("res_in_date"));
				rv.setResOutDate(rs.getDate("res_out_date"));
				rv.setResPeriod(rs.getInt("res_period"));
				rv.setResPrice(rs.getInt("res_price"));
				rv.setResPaymentDate(rs.getTimestamp("res_payment_date"));
				list.add(rv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}
	// 예약 정보2.
	public String getReservePageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*) as totalCount from reservation_tb";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어줘야 한다.
		// 현재 페이지가 1이라면... 1~5 
		// 현재 페이기자 3이라면 ... 1~5 
		// 현재 페이지가 7이라면 ... 6 ~ 10 
		// 현재 페이지가 11 이라면 ... 11 ~ 15 
		// ((현재페이지-1)/리스트개수)*리스트 개수 +1 -> 몫으로 게산을 한다...
		// 전제 조건 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminReserveManager?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminReserveManager?currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminReserveManager?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminReserveManager?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminReserveManager?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminReserveManager?currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}
	// 매출 정ㅂ조
	public ArrayList<SalesVo> getSalesCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SalesVo> list = new ArrayList<SalesVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select sales_tb.* , row_number() over(order by sales_no desc) as num from sales_tb) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SalesVo sv = new SalesVo();
				sv.setSalesNo(rs.getInt("SALES_NO"));
				sv.setSalesId(rs.getString("SALES_ID"));
				sv.setSalesPaymentPrice(rs.getInt("SALES_PAYMENT_PRICE"));
				sv.setSalesReservationNo(rs.getInt("SALES_RESERVATION_NO"));
				list.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public String getSalesPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*) as totalCount from sales_tb";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어줘야 한다.
		// 현재 페이지가 1이라면... 1~5 
		// 현재 페이기자 3이라면 ... 1~5 
		// 현재 페이지가 7이라면 ... 6 ~ 10 
		// 현재 페이지가 11 이라면 ... 11 ~ 15 
		// ((현재페이지-1)/리스트개수)*리스트 개수 +1 -> 몫으로 게산을 한다...
		// 전제 조건 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminSalesManager?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminSalesManager?currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminSalesManager?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminSalesManager?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminSalesManager?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminSalesManager?currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	// 메인 템플릿들 변경 함수
	public int mainupdateSelect(Connection conn, String value, String update) {
		String query = "";
		switch(value) {
		case "1":query = prop.getProperty("mainupdate1");break;
		case "2":query = prop.getProperty("mainupdate2");break;
		case "3":query = prop.getProperty("mainupdate3");break;
		case "4":query = prop.getProperty("mainupdate4");break;
		case "5":query = prop.getProperty("mainupdate5");break;
		case "6":query = prop.getProperty("mainupdate6");break;
		
		}
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, update);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	// 객실 등록

	public boolean roomInsert(Connection conn, PensionVo pv) {
		boolean result = false;
		PreparedStatement pstmt = null;
		int row = 0;
		String query = "insert into PENSION_TB values(?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pv.getPsName());
			pstmt.setInt(2, pv.getPsPersonnel());
			pstmt.setInt(3, pv.getPsMaxPersonnel());
			pstmt.setString(4, pv.getPsContents());
			pstmt.setInt(5, pv.getPsWeekend());
			pstmt.setInt(6, pv.getPsWeekday());
			pstmt.setInt(7, pv.getPsAddtionalPrice());

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
	// 객실의 사진 등록

	public boolean picInsert(Connection conn, PensionPicTb picVo) {
		boolean result = false;
		PreparedStatement pstmt = null;
		int row = 0;
		String query = "insert into PENSION_PIC_TB values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, picVo.getpsPicName());
			pstmt.setString(2, picVo.getPsPicPath());
			pstmt.setString(3, picVo.getPsPicMain());


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
	// 객실 정보 가져오기
	public PensionVo selectRoomInfo(Connection conn, String psName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PensionVo pv = null;
		String query = "select * from pension_tb where ps_name=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, psName);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				pv = new PensionVo(rs.getString("PS_NAME"), rs.getInt("PS_PERSONNEL"), rs.getInt("PS_MAX_PERSONNEL"), rs.getString("PS_CONTENTS"), rs.getInt("PS_WEEKEND"), rs.getInt("PS_WEEKDAY"), rs.getInt("PS_ADDITIONAL_PRICE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return pv;
	}

	public ArrayList<QuestionVo> questionList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from QUESTION_TB order by Q_NO DESC";
		ArrayList<QuestionVo> list = new ArrayList<QuestionVo>();
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionVo qv = new QuestionVo();
				qv.setqNo(rs.getInt("Q_NO"));
				qv.setqName(rs.getString("Q_NAME"));
				qv.setqContents(rs.getString("Q_CONTENTS"));
				qv.setqWriter(rs.getString("Q_WRITER"));
				qv.setqWriteDate(rs.getTimestamp("Q_WRITE_DATE"));
				qv.setqAnswerCheck(rs.getString("Q_ANSWER_ChECK"));
				list.add(qv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public QuestionVo selectOneQuestion(Connection conn, int qNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from QUESTION_TB where Q_NO=?";
		QuestionVo qv = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				qv = new QuestionVo();
				qv.setqNo(rs.getInt("Q_NO"));
				qv.setqName(rs.getString("Q_NAME"));
				qv.setqContents(rs.getString("Q_CONTENTS"));
				qv.setqWriter(rs.getString("Q_WRITER"));
				qv.setqWriteDate(rs.getTimestamp("Q_WRITE_DATE"));
				qv.setqAnswerCheck(rs.getString("Q_ANSWER_ChECK"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return qv;
	}
	// 1:1 문의 답변 생성
	public boolean insertAnswer(Connection conn, AnswerVo asv) {
		PreparedStatement pstmt = null;
		int row = 0;
		boolean result = false;
		String query ="insert into ANSWER_TB VALUES(A_NO_SEQ.NEXTVAL,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, asv.getaQNo());
			pstmt.setString(2, asv.getaContents());

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
	// 답변 했음으로 표시.
	public boolean answerRegistration(Connection conn, int qNo) {
		PreparedStatement pstmt = null;
		int row = 0 ;
		boolean result = false;
		String query = "UPDATE QUESTION_TB SET Q_ANSWER_CHECK='Y' WHERE Q_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qNo);

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
	// 전체 로그 기록 불러오기
	public ArrayList<MemberLoginLogVo> getLoginLogPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM "
				+ "(SELECT MEMBER_LOG_TB.* , ROW_NUMBER() OVER(ORDER BY MB_LOG_TIME DESC) AS NUM FROM MEMBER_LOG_TB ) "
				+"WHERE NUM BETWEEN ? AND ?";
		//		String query = "select * from MEMBER_LOG_TB order by MB_LOG_TIME DESC";
		ArrayList<MemberLoginLogVo> list = new ArrayList<MemberLoginLogVo>();

		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberLoginLogVo mllv = new MemberLoginLogVo();
				mllv.setMbLogId(rs.getString("MB_LOG_ID"));
				mllv.setMbLogTime(rs.getTimestamp("MB_LOG_TIME"));
				mllv.setMbLogBrowser(rs.getString("MB_LOG_BROWSER"));
				mllv.setMbLogIp(rs.getString("MB_LOG_IP"));
				mllv.setMbLogLocale(rs.getString("MB_LOG_LOCALE"));
				list.add(mllv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public AnswerVo selectAnswer(Connection conn, int qNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from ANSWER_TB where A_Q_NO=?";
		AnswerVo asv = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				asv = new AnswerVo();
				asv.setaNo(rs.getInt("A_NO"));
				asv.setaQNo(rs.getInt("A_Q_NO"));
				asv.setaContents(rs.getString("A_CONTENTS"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return asv;
	}

	public int mainInsert(Connection conn, String mainPicPath) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("mainImageInsert");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mainPicPath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateImage(Connection conn, String afterPath, String beforeFileName) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("mainupdate7");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, afterPath);
			pstmt.setString(2, beforeFileName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public ReservationVo selectOneReservation(Connection conn, String roomName, Date comDate) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from reservation_tb where res_room_name=? and res_in_date <= ? and res_out_date >= ?";
		ReservationVo rv = null;

		try {
			pstmt = conn.prepareStatement(query);
			//
			//
			pstmt.setString(1, roomName);
			// 시간 비교를 하는 것이 좀 그러네...
			pstmt.setDate(2, comDate);
			pstmt.setDate(3, comDate);

			rs = pstmt.executeQuery();
			while(rs.next()) {
				rv = new ReservationVo();
				rv.setResNo(rs.getInt("res_no"));
				rv.setResRoomName(rs.getString("res_room_name"));
				rv.setResId(rs.getString("res_id"));
				rv.setResPersonnel(rs.getInt("res_personnel"));
				rv.setResReservationDate(rs.getTimestamp("res_reservation_date"));
				rv.setResInDate(rs.getDate("res_in_date"));
				rv.setResOutDate(rs.getDate("res_out_date"));
				rv.setResPeriod(rs.getInt("res_period"));
				rv.setResPrice(rs.getInt("res_price"));
				rv.setResPaymentDate(rs.getTimestamp("res_payment_date"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return rv;
	}

	// 게시판 등록 (순수 게시판만...)
	public boolean boardInsert(Connection conn, BoardVo bv) {
		PreparedStatement pstmt = null;
		int row = 0 ;
		String query = "insert into board_tb values(BD_NO_SEQ.NEXTVAL,?,?,?,SYSDATE,DEFAULT,DEFAULT,?)";
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
	// 게시판 번호 가져오기
	public BoardVo boardSelectOne(Connection conn, BoardVo bv) {
		PreparedStatement pstmt = null;
		BoardVo newBv = null;	
		ResultSet rs = null;
		// 좀 그렇다... 아니면 차라리 올릴때 같이 올리도록 하는 것이 좋을 텐데...

		String query = "select * from board_tb where bd_name = ? and bd_contents=? and bd_writer=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,bv.getBdName());
			pstmt.setString(2, bv.getBdContents());
			pstmt.setString(3, bv.getBdWriter());

			rs = pstmt.executeQuery();
			if(rs.next()) {
				newBv = new BoardVo();
				newBv.setBdNo(rs.getInt("BD_NO"));
				newBv.setBdName(rs.getString("BD_NAME"));
				newBv.setBdCategory(rs.getString("BD_CATEGORY"));
				newBv.setBdContents(rs.getString("BD_CONTENTS"));
				newBv.setBdWriter(rs.getString("BD_WRITER"));
				newBv.setBdWriteDate(rs.getTimestamp("BD_WRITE_DATE"));
				newBv.setBdViewCount(rs.getInt("BD_VIEW_COUNT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return newBv;
	}
	// 파일 삽입
	public boolean fileInsert(Connection conn, DataFile dataFile) {
		PreparedStatement pstmt = null;
		String query = "insert into board_file_tb values(BD_FILE_NO_SEQ.NEXTVAL,?,?,SYSDATE,?,DEFAULT,?,?)";
		int row = 0;
		boolean result =false;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	// 게시판 정보 가져오기
	public BoardVo selectBoardOne(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from board_tb where BD_NO=?";

		BoardVo bv = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bv = new BoardVo();
				bv.setBdNo(rs.getInt("BD_NO"));
				bv.setBdName(rs.getString("BD_NAME"));
				bv.setBdCategory(rs.getString("BD_CATEGORY"));
				bv.setBdContents(rs.getString("BD_CONTENTS"));
				bv.setBdWriter(rs.getString("BD_WRITER"));
				bv.setBdWriteDate(rs.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rs.getInt("BD_VIEW_COUNT"));
				bv.setBdNo(bdNo);
				bv.setBdRecommendCount(rs.getInt("BD_RECOMMEND_COUNT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return bv;
	}

	// 게시판에 있는 사진들 가져오기
	public ArrayList<DataFile> selectBoardFiles(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from board_file_tb where BD_FILE_BD_NO=? order by BD_FILE_NO DESC";

		ArrayList<DataFile> list = new ArrayList<DataFile>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DataFile df = new DataFile();
				df.setBdFileNo(rs.getInt("BD_FILE_NO"));
				df.setBdFileSize(rs.getLong("BD_FILE_SIZE"));
				df.setBdFileName(rs.getString("BD_FILE_NAME"));
				df.setBdFileUptime(rs.getTimestamp("BD_FILE_UPTIME"));
				df.setBdFileWriter(rs.getString("BD_FILE_WRITER"));
				df.setBdFileCount(rs.getInt("BD_FILE_COUNT"));
				df.setBdFilePath(rs.getString("BD_FILE_PATH"));
				df.setBdFilebdNo(rs.getInt("BD_FILE_BD_NO"));
				list.add(df);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public ArrayList<ReservationVo> getReserveCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReservationVo> list = new ArrayList<ReservationVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "SELECT * FROM "
				+ "(SELECT RESERVATION_TB.* , ROW_NUMBER() OVER(ORDER BY RES_NO DESC) AS NUM FROM RESERVATION_TB WHERE "+searchOption+" LIKE ? ) "
				+"WHERE NUM BETWEEN ? AND ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1,"%"+searchData+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReservationVo rv = new ReservationVo();
				rv.setResNo(rs.getInt("RES_NO"));
				rv.setResRoomName(rs.getString("RES_ROOM_NAME"));
				rv.setResId(rs.getString("RES_ID"));
				rv.setResPersonnel(rs.getInt("RES_PERSONNEL"));
				rv.setResReservationDate(rs.getTimestamp("RES_RESERVATION_DATE"));
				rv.setResInDate(rs.getDate("RES_IN_DATE"));
				rv.setResOutDate(rs.getDate("RES_OUT_DATE"));
				rv.setResPeriod(rs.getInt("RES_PERIOD"));
				rv.setResPrice(rs.getInt("RES_PRICE"));
				rv.setResPaymentDate(rs.getTimestamp("RES_PAYMENT_DATE"));

				list.add(rv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public String getReservePageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)

		String query = "select count(*) as totalCount from reservation_tb where "+searchOption+" like ?";

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, "%"+searchData+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminReserveManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminReserveManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminReserveManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminReserveManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminReserveManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminReserveManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public ArrayList<MemberVo> getMemberCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select member_tb.* , row_number() over(order by MB_ID desc) as num from member_tb where "+searchOption +" like ? ) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+searchData+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo mv = new MemberVo();
				mv.setMbId(rs.getString(1));
				mv.setMbPwd(rs.getString(2));
				mv.setMbBirth(rs.getDate(3));
				mv.setMbEmail(rs.getString(4));
				mv.setMbPhone(rs.getString(5));
				mv.setMbGender(rs.getString(6));
				mv.setMbName(rs.getString(7));
				mv.setMbEntDate(rs.getDate(8));
				mv.setMbAddress(rs.getString(9));
				list.add(mv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}	
		return list;
	}

	public String getMemberPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*) as totalCount from member_tb where "+searchOption+" like ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchData+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어줘야 한다.
		// 현재 페이지가 1이라면... 1~5 
		// 현재 페이기자 3이라면 ... 1~5 
		// 현재 페이지가 7이라면 ... 6 ~ 10 
		// 현재 페이지가 11 이라면 ... 11 ~ 15 
		// ((현재페이지-1)/리스트개수)*리스트 개수 +1 -> 몫으로 게산을 한다...
		// 전제 조건 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminMemberList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminMemberList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminMemberList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminMemberList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminMemberList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminMemberList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public String getLoginLogPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)

		String query = "select count(*) as totalCount from reservation_tb ";

		try {
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminMemberLog?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminMemberLog?currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminMemberLog?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminMemberLog?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminMemberLog?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminMemberLog?currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public ArrayList<MemberLoginLogVo> getLoginLogPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM "
				+ "(SELECT MEMBER_LOG_TB.* , ROW_NUMBER() OVER(ORDER BY MB_LOG_TIME DESC) AS NUM FROM MEMBER_LOG_TB WHERE "+searchOption+" LIKE ? ) "
				+"WHERE NUM BETWEEN ? AND ?";

		ArrayList<MemberLoginLogVo> list = new ArrayList<MemberLoginLogVo>();

		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;	

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+searchData+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberLoginLogVo mllv = new MemberLoginLogVo();
				mllv.setMbLogId(rs.getString("MB_LOG_ID"));
				mllv.setMbLogTime(rs.getTimestamp("MB_LOG_TIME"));
				mllv.setMbLogBrowser(rs.getString("MB_LOG_BROWSER"));
				mllv.setMbLogIp(rs.getString("MB_LOG_IP"));
				mllv.setMbLogLocale(rs.getString("MB_LOG_LOCALE"));
				list.add(mllv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;

	}

	public String getLoginLogPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)

		String query = "select count(*) as totalCount from member_log_tb where "+searchOption+" like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchData+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트

		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		int endNavi = startNavi + naviCountPerPage -1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminMemberLog?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminMemberLog?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminMemberLog?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminMemberLog?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminMemberLog?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminMemberLog?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public ArrayList<QuestionVo> getQuestionCurrentPage(Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QuestionVo> list = new ArrayList<QuestionVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "SELECT * FROM "
				+ "(SELECT QUESTION_TB.* , ROW_NUMBER() OVER(ORDER BY Q_NO DESC) AS NUM FROM QUESTION_TB ) "
				+"WHERE NUM BETWEEN ? AND ?";		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionVo qv = new QuestionVo();
				qv.setqNo(rs.getInt("Q_NO"));
				qv.setqName(rs.getString("Q_NAME"));
				qv.setqContents(rs.getString("Q_CONTENTS"));
				qv.setqWriter(rs.getString("Q_WRITER"));
				qv.setqWriteDate(rs.getTimestamp("Q_WRITE_DATE"));
				qv.setqAnswerCheck(rs.getString("Q_ANSWER_ChECK"));
				list.add(qv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public String getQuestionPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QUESTION_TB";

		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminQuestionList?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminQuestionList?currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminQuestionList?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminQuestionList?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminQuestionList?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminQuestionList?currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public ArrayList<QuestionVo> getQuestionCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QuestionVo> list = new ArrayList<QuestionVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "SELECT * FROM "
				+ "(SELECT QUESTION_TB.* , ROW_NUMBER() OVER(ORDER BY Q_NO DESC) AS NUM FROM QUESTION_TB WHERE "+searchOption+" LIKE ? ) "
				+"WHERE NUM BETWEEN ? AND ?";		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+searchData+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionVo qv = new QuestionVo();
				qv.setqNo(rs.getInt("Q_NO"));
				qv.setqName(rs.getString("Q_NAME"));
				qv.setqContents(rs.getString("Q_CONTENTS"));
				qv.setqWriter(rs.getString("Q_WRITER"));
				qv.setqWriteDate(rs.getTimestamp("Q_WRITE_DATE"));
				qv.setqAnswerCheck(rs.getString("Q_ANSWER_ChECK"));
				list.add(qv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public String getQuestionPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QUESTION_TB where "+searchOption+" like ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchData+"%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	

		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		int endNavi = startNavi + naviCountPerPage -1;

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminQuestionList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminQuestionList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminQuestionList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminQuestionList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminQuestionList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminQuestionList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public ArrayList<BoardVo> getBoardCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select board_tb.* , row_number() over(order by bd_no desc) as num from board_tb where bd_category=?) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"공지사항");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVo bv = new BoardVo();
				bv.setBdNo(rs.getInt("BD_NO"));
				bv.setBdName(rs.getString("BD_NAME"));
				bv.setBdContents(rs.getString("BD_CONTENTS"));
				bv.setBdWriter(rs.getString("BD_WRITER"));
				bv.setBdWriteDate(rs.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rs.getInt("BD_VIEW_COUNT"));
				bv.setBdRecommendCount(rs.getInt("BD_RECOMMEND_COUNT"));
				bv.setBdCategory(rs.getString("BD_CATEGORY"));
				list.add(bv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public String getBoardPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*) as totalCount from board_tb where bd_category=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "공지사항");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어줘야 한다.
		// 현재 페이지가 1이라면... 1~5 
		// 현재 페이기자 3이라면 ... 1~5 
		// 현재 페이지가 7이라면 ... 6 ~ 10 
		// 현재 페이지가 11 이라면 ... 11 ~ 15 
		// ((현재페이지-1)/리스트개수)*리스트 개수 +1 -> 몫으로 게산을 한다...
		// 전제 조건 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminBoardList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminBoardList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminBoardList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminBoardList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminBoardList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminBoardList?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public int roomUpdateImage(Connection conn, String afterPath, String beforeFileName) {
		PreparedStatement pstmt = null;
		String query = "UPDATE PENSION_PIC_TB SET PS_PIC_PATH = ? WHERE PS_PIC_PATH=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, afterPath);
			pstmt.setString(2, beforeFileName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int roomDeleteImage(Connection conn, String deleteImage) {
		PreparedStatement pstmt = null;
		//String query = prop.getProperty("mainImageDelete");
		String query ="DELETE FROM PENSION_PIC_TB WHERE PS_PIC_PATH = ?";
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

	public ArrayList<SalesVo> getSalesCurrentPage(Connection conn, int currentPage, int recordCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SalesVo> list = new ArrayList<SalesVo>();
		// 시작 페이지 계산 
		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = currentPage*recordCountPerPage;	// 숫자가딱 맞지 않아도 된다.
		// 필드가 있어서 안 된다.
		// 
		String query = "select * from "
				+ "(select sales_tb.* , row_number() over(order by sales_no desc) as num from sales_tb  WHERE "+searchOption+" LIKE ? ) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"%"+searchData+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SalesVo sv = new SalesVo();
				sv.setSalesNo(rs.getInt("SALES_NO"));
				sv.setSalesId(rs.getString("SALES_ID"));
				sv.setSalesPaymentPrice(rs.getInt("SALES_PAYMENT_PRICE"));
				sv.setSalesReservationNo(rs.getInt("SALES_RESERVATION_NO"));
				list.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public String getSalesPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String searchData, String searchOption) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 게시물의 total갯수를 구해야 함.
		//  (total/recordCountPerPage)+1 이 페이지 갯수

		int recordTotalCount = 0; // 총 게시물 개수 저장 변수 (정보가 없으므로 초기값은 0)
		String query = "select count(*) as totalCount from sales_tb";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				recordTotalCount = rs.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	// navi 토탈 카운트
		// 페이지당 10개씩 보이게 만들어서 navi list를 만드려면?
		// 만약 나머지가 0이면 
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		// 1 페이지 보다 더 아래의 페이지를 요청하거나, 
		// 전체 페이지보다 큰 페이지를 요청했을 경우를 에러 방지.

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		// 현재 페이지를 기점으로 시작 navi와 끝 navi를 만들어줘야 한다.
		// 현재 페이지가 1이라면... 1~5 
		// 현재 페이기자 3이라면 ... 1~5 
		// 현재 페이지가 7이라면 ... 6 ~ 10 
		// 현재 페이지가 11 이라면 ... 11 ~ 15 
		// ((현재페이지-1)/리스트개수)*리스트 개수 +1 -> 몫으로 게산을 한다...
		// 전제 조건 
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		// 끝 navi 구하는 공식 (쉬움)
		int endNavi = startNavi + naviCountPerPage -1;

		// 끝 navi를 구할 때 주의해야 할 점 
		// 마지막 navi 부분은 한줄 추가를 해야 한다.
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// page navi에서 사용할 '<' 모양과 '>' 모양을 사용하기 위해
		// 필요한 변수 2개 생성 (시작과 끝은 필요없으므로 !)
		// if- else 로 쓰지 않는 이유는 게시물의 갯수가 적을 경우 둘다 쓸 수 있기 때문에
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// 여기까지가 기본적인 구조 
		StringBuilder sb = new StringBuilder();
		if(needPrev) { // 시작이 1페이지가 아니라면
			sb.append("<a href='/adminSalesManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminSalesManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");

		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminSalesManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminSalesManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminSalesManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminSalesManager?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}
		// 문자열 만들어짐.
		return sb.toString();
	}

	public ArrayList<MemberVo> allMemberList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select * from member_tb";
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVo mv = new MemberVo();
				mv.setMbId(rs.getString(1));
				mv.setMbPwd(rs.getString(2));
				mv.setMbBirth(rs.getDate(3));
				mv.setMbEmail(rs.getString(4));
				mv.setMbPhone(rs.getString(5));
				mv.setMbGender(rs.getString(6));
				mv.setMbName(rs.getString(7));
				mv.setMbEntDate(rs.getDate(8));
				mv.setMbAddress(rs.getString(9));
				list.add(mv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	// 메인사진 변경
	public int mainUpdateImage(Connection conn, String afterPath, String beforeFileName) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("mainImageUpdate");
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, afterPath);
			pstmt.setString(2, beforeFileName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 메인사진 삭제
	public int mainDeleteImage(Connection conn, String deleteImage) {
		PreparedStatement pstmt = null;
		String query = prop.getProperty("mainImageDelete");
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


	public boolean updateRoomText(Connection conn, PensionVo pv) {
		PreparedStatement pstmt = null;
		boolean result = false;
		int row = -1 ; 

		String query = "UPDATE PENSION_TB SET PS_PERSONNEL =? , PS_MAX_PERSONNEL=?,PS_CONTENTS=?,PS_WEEKEND=?,PS_WEEKDAY=?,PS_ADDITIONAL_PRICE=? WHERE PS_NAME=?";
		//UPDATE QUESTION_TB SET Q_ANSWER_CHECK='Y' WHERE Q_NO = ?
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, pv.getPsPersonnel());
			pstmt.setInt(2, pv.getPsMaxPersonnel());
			pstmt.setString(3, pv.getPsContents());
			pstmt.setInt(4, pv.getPsWeekend());
			pstmt.setInt(5, pv.getPsWeekday());
			pstmt.setInt(6, pv.getPsAddtionalPrice());
			pstmt.setString(7, pv.getPsName());
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
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////// 지은 추가
	
	// searchOption 있음
	public ArrayList<ReservationCancelVo> getReserveCancelCurrentPage(Connection conn, int currentPage,
			int recordCountPerPage, String searchData, String searchOption) {
		
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationCancelVo> list = new ArrayList<ReservationCancelVo>();

		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		String query = "SELECT * FROM "
				+ "(SELECT RES_CANCEL_TB.* , ROW_NUMBER() OVER(ORDER BY RC_NO DESC) AS NUM FROM RES_CANCEL_TB WHERE "+searchOption+" LIKE ? ) "
				+"WHERE NUM BETWEEN ? AND ? ORDER BY RC_DATE DESC";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,"%"+searchData+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				ReservationCancelVo rcv = new ReservationCancelVo();
				rcv.setRcNo(rset.getInt("rc_no"));
				rcv.setRcResNo(rset.getInt("rc_res_no"));
				rcv.setRcResRoomName(rset.getString("rc_res_room_name"));
				rcv.setRcResId(rset.getString("rc_res_id"));
				rcv.setRcResPersonnel(rset.getInt("rc_res_personnel"));
				rcv.setRcResReservationDate(rset.getTimestamp("rc_res_reservation_date"));
				rcv.setRcResInDate(rset.getDate("rc_res_in_date"));
				rcv.setRcResOutDate(rset.getDate("rc_res_out_date"));
				rcv.setRcResPeriod(rset.getInt("rc_res_period"));
				rcv.setRcResPrice(rset.getInt("rc_res_price"));
				rcv.setRcResPaymentDate(rset.getTimestamp("rc_res_payment_date"));
				rcv.setRcDate(rset.getTimestamp("rc_date"));
				rcv.setRcRefundCheck(rset.getString("rc_refund_check"));
				rcv.setRcCancelCheck(rset.getString("rc_cancel_check"));

				list.add(rcv);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public String getReserveCancelPageNavi(Connection conn, int currentPage, int recordCountPerPage,
			int naviCountPerPage, String searchData, String searchOption) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int recordTotalCount = 0; 
		
		String query = "select count(*) as totalCount from res_cancel_tb where "+searchOption+" like ?";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "%"+searchData+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	
		
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		
		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		int endNavi = startNavi + naviCountPerPage -1;
		

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
	
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) { 
			sb.append("<a href='/adminReserveCancel?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminReserveCancel?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");
	
		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminReserveCancel?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminReserveCancel?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminReserveCancel?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminReserveCancel?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}

		return sb.toString();
	}

	
	
	
	// searchOption 없음
	public ArrayList<ReservationCancelVo> getReserveCancelCurrentPage(Connection conn, int currentPage,
			int recordCountPerPage) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationCancelVo> list = new ArrayList<ReservationCancelVo>();

		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);

		int end = currentPage*recordCountPerPage;	
		
		String query = "select * from "
				+ "(select res_cancel_tb.* , row_number() over(order by rc_no desc) as num from res_cancel_tb) "
				+"where num between ? and ? ORDER BY RC_DATE DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				ReservationCancelVo rcv = new ReservationCancelVo();
				rcv.setRcNo(rset.getInt("rc_no"));
				rcv.setRcResNo(rset.getInt("rc_res_no"));
				rcv.setRcResRoomName(rset.getString("rc_res_room_name"));
				rcv.setRcResId(rset.getString("rc_res_id"));
				rcv.setRcResPersonnel(rset.getInt("rc_res_personnel"));
				rcv.setRcResReservationDate(rset.getTimestamp("rc_res_reservation_date"));
				rcv.setRcResInDate(rset.getDate("rc_res_in_date"));
				rcv.setRcResOutDate(rset.getDate("rc_res_out_date"));
				rcv.setRcResPeriod(rset.getInt("rc_res_period"));
				rcv.setRcResPrice(rset.getInt("rc_res_price"));
				rcv.setRcResPaymentDate(rset.getTimestamp("rc_res_payment_date"));
				rcv.setRcDate(rset.getTimestamp("rc_date"));
				rcv.setRcRefundCheck(rset.getString("rc_refund_check"));
				rcv.setRcCancelCheck(rset.getString("rc_cancel_check"));

				list.add(rcv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public String getReserveCancelPageNavi(Connection conn, int currentPage, int recordCountPerPage,
			int naviCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int recordTotalCount = 0; 
		String query = "select count(*) as totalCount from res_cancel_tb";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	
		
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		int endNavi = startNavi + naviCountPerPage -1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
	
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/adminReserveCancel?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminReserveCancel?currentPage="+(startNavi-1)+"'> < </a>");
		}
		
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminReserveCancel?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminReserveCancel?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/adminReserveCancel?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminReserveCancel?currentPage="+pageTotalCount+"'> >> </a>");
		}

		return sb.toString();
	}

	
	// searchOption 있음
	public ArrayList<ReservationHistoryVo> getReserveHistoryCurrentPage(Connection conn, int currentPage,
			int recordCountPerPage, String searchData, String searchOption) {
		

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationHistoryVo> list = new ArrayList<ReservationHistoryVo>();

		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		String query = "SELECT * FROM "
				+ "(SELECT RESERVATION_HISTORY_TB.* , ROW_NUMBER() OVER(ORDER BY RES_HIS_NO DESC) AS NUM FROM RESERVATION_HISTORY_TB WHERE "+searchOption+" LIKE ? ) "
				+"WHERE NUM BETWEEN ? AND ?";
		
		try {
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1,"%"+searchData+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			while(rset.next()) {
				
				ReservationHistoryVo rhv = new ReservationHistoryVo();
				rhv.setResHisNo(rset.getInt("RES_HIS_NO"));
				rhv.setResHisResNo(rset.getInt("RES_HIS_RES_NO"));
				rhv.setResHisRoomName(rset.getString("RES_HIS_ROOM_NAME"));
				rhv.setResHisId(rset.getString("RES_HIS_ID"));
				rhv.setResHisPersonnel(rset.getInt("RES_HIS_PERSONNEL"));
				rhv.setResHisReservationDate(rset.getTimestamp("RES_HIS_RESERVATION_DATE"));
				rhv.setResHisInDate(rset.getDate("RES_HIS_IN_DATE"));
				rhv.setResHisOutDate(rset.getDate("RES_HIS_OUT_DATE"));
				rhv.setResHisPeriod(rset.getInt("RES_HIS_PERIOD"));
				rhv.setResHisPrice(rset.getInt("RES_HIS_PRICE"));
				rhv.setResHisPaymentDate(rset.getTimestamp("RES_HIS_PAYMENT_DATE"));
				
				list.add(rhv);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	
	}

	public String getReserveHistoryPageNavi(Connection conn, int currentPage, int recordCountPerPage,
			int naviCountPerPage, String searchData, String searchOption) {
		

		PreparedStatement pstmt = null;
		ResultSet rset = null;

		int recordTotalCount = 0; 
		
		String query = "select count(*) as totalCount from reservation_history_tb where "+searchOption+" like ?";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, "%"+searchData+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("totalCount");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	
		
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}
		
		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		int endNavi = startNavi + naviCountPerPage -1;
		

		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
	
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		
		StringBuilder sb = new StringBuilder();
		if(needPrev) { 
			sb.append("<a href='/adminReserveHistory?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminReserveHistory?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(startNavi-1)+"'> < </a>");
	
		}
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminReserveHistory?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminReserveHistory?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		if(needNext) {
			sb.append("<a href='/adminReserveHistory?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminReserveHistory?searchData="+searchData+"&searchOption="+searchOption+"&currentPage="+pageTotalCount+"'> >> </a>");
		}

		return sb.toString();
		
		
		
	}

	// searchOption 없음
	public ArrayList<ReservationHistoryVo> getReserveHistoryCurrentPage(Connection conn, int currentPage,
			int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReservationHistoryVo> list = new ArrayList<ReservationHistoryVo>();

		int start = currentPage*recordCountPerPage - (recordCountPerPage-1);

		int end = currentPage*recordCountPerPage;	
		
		String query = "select * from "
				+ "(select reservation_history_tb.* , row_number() over(order by res_his_no desc) as num from reservation_history_tb) "
				+"where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				ReservationHistoryVo rhv = new ReservationHistoryVo();
				rhv.setResHisNo(rset.getInt("RES_HIS_NO"));
				rhv.setResHisResNo(rset.getInt("RES_HIS_RES_NO"));
				rhv.setResHisRoomName(rset.getString("RES_HIS_ROOM_NAME"));
				rhv.setResHisId(rset.getString("RES_HIS_ID"));
				rhv.setResHisPersonnel(rset.getInt("RES_HIS_PERSONNEL"));
				rhv.setResHisReservationDate(rset.getTimestamp("RES_HIS_RESERVATION_DATE"));
				rhv.setResHisInDate(rset.getDate("RES_HIS_IN_DATE"));
				rhv.setResHisOutDate(rset.getDate("RES_HIS_OUT_DATE"));
				rhv.setResHisPeriod(rset.getInt("RES_HIS_PERIOD"));
				rhv.setResHisPrice(rset.getInt("RES_HIS_PRICE"));
				rhv.setResHisPaymentDate(rset.getTimestamp("RES_HIS_PAYMENT_DATE"));
				
				list.add(rhv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public String getReserveHistoryPageNavi(Connection conn, int currentPage, int recordCountPerPage,
			int naviCountPerPage) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int recordTotalCount = 0; 
		String query = "select count(*) as totalCount from reservation_history_tb";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("totalCount");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		int pageTotalCount = 0;	
		
		if(recordTotalCount%recordCountPerPage != 0){
			pageTotalCount = recordTotalCount/recordCountPerPage +1;
		}else {
			pageTotalCount = recordTotalCount/recordCountPerPage	;
		}

		if(currentPage < 1) {
			currentPage =1;
		}
		if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage-1)/naviCountPerPage)*naviCountPerPage+1;

		int endNavi = startNavi + naviCountPerPage -1;
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
	
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi ==1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<a href='/adminReserveHistory?currentPage="+1+"'> << </a>");
			sb.append("<a href='/adminReserveHistory?currentPage="+(startNavi-1)+"'> < </a>");
		}
		
		for(int i = startNavi ; i <=endNavi ; i++) {
			if(i==currentPage) {
				sb.append("<a href='/adminReserveHistory?currentPage="+(i)+"' ><B> "+i+" </B></a>");
			}else {
				sb.append("<a href='/adminReserveHistory?currentPage="+(i)+"' > "+i+" </a>");
			}
		}
		
		if(needNext) {
			sb.append("<a href='/adminReserveHistory?currentPage="+(endNavi+1)+"'> > </a>");
			sb.append("<a href='/adminReserveHistory?currentPage="+pageTotalCount+"'> >> </a>");
		}

		return sb.toString();
		
		
	}
	
	public ArrayList<MemberLoginLogVo> memberLogListDown(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberLoginLogVo> list = new ArrayList<MemberLoginLogVo>();

		String query = "SELECT * FROM MEMBER_LOG_TB";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberLoginLogVo mllv = new MemberLoginLogVo();
				mllv.setMbLogId(rs.getString("MB_LOG_ID"));
				mllv.setMbLogTime(rs.getTimestamp("MB_LOG_TIME"));
				mllv.setMbLogBrowser(rs.getString("MB_LOG_BROWSER"));
				mllv.setMbLogIp(rs.getString("MB_LOG_IP"));
				mllv.setMbLogLocale(rs.getString("MB_LOG_LOCALE"));
				list.add(mllv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}


		return list;
	}

	public ArrayList<ReservationVo> reservationListDown(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ReservationVo> list = new ArrayList<ReservationVo>();

		String query = "SELECT * FROM RESERVATION_TB";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				ReservationVo rv = new ReservationVo();
				rv.setResNo(rs.getInt("res_no"));
				rv.setResRoomName(rs.getString("res_room_name"));
				rv.setResId(rs.getString("res_id"));
				rv.setResPersonnel(rs.getInt("res_personnel"));
				rv.setResReservationDate(rs.getTimestamp("res_reservation_date"));
				rv.setResInDate(rs.getDate("res_in_date"));
				rv.setResOutDate(rs.getDate("res_out_date"));
				rv.setResPeriod(rs.getInt("res_period"));
				rv.setResPrice(rs.getInt("res_price"));
				rv.setResPaymentDate(rs.getTimestamp("res_payment_date"));
				list.add(rv);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}		
		return list;
	}

	public int boardCompleteDel(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		int row = 0;
		String query = "delete from board_tb where bd_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return row;
	}
	// 게시판의 파일 목록  가져오기
	public ArrayList<DataFile> boardFileList(Connection conn, int bdNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<DataFile> list = new ArrayList<DataFile>();
		String query = "select * from board_File_tb where bd_file_bd_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bdNo);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DataFile df = new DataFile();
				df.setBdFileNo(rs.getInt("BD_FILE_NO"));
				df.setBdFileSize(rs.getLong("BD_FILE_SIZE"));
				df.setBdFileName(rs.getString("BD_FILE_NAME"));
				df.setBdFileUptime(rs.getTimestamp("BD_FILE_UPTIME"));
				df.setBdFileWriter(rs.getString("BD_FILE_WRITER"));
				df.setBdFileCount(rs.getInt("BD_FILE_COUNT"));
				df.setBdFilePath(rs.getString("BD_FILE_PATH"));
				df.setBdFilebdNo(rs.getInt("BD_FILE_BD_NO"));
				list.add(df);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<PensionPicTb> delPicList(Connection conn, String roomName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM PENSION_PIC_TB WHERE PS_PIC_NAME=?";
		ArrayList<PensionPicTb> list = new ArrayList<PensionPicTb>();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, roomName);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PensionPicTb ppt = new PensionPicTb(rs.getString("PS_PIC_NAME"),rs.getString("PS_PIC_PATH"),rs.getString("PS_PIC_MAIN"));
				list.add(ppt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int roomDeletePics(Connection conn,String roomName) {
		PreparedStatement pstmt = null;
		int row = 0 ; 
		String query = "delete from pension_pic_tb where ps_pic_name=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, roomName);
			row = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return row;
	}

	public boolean roomDeleteFinal(Connection conn, String roomName) {
		PreparedStatement pstmt = null;
		int row = 0 ; 
		boolean result = false;
		String query = "delete from pension_tb where ps_name=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, roomName);
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
	
	// todo: sql 
	public int countReserve(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0 ; 
		//select count(*) as count from MEMBER_TB where MB_ENTDATE >= TRUNC(sysdate,'MM') AND MB_ENTDATE<= ADD_MONTHS( TRUNC(sysdate,'MM'), 1 )-1
		String query = "select COUNT(*) as count from RESERVATION_TB where RES_RESERVATION_DATE >= TRUNC(sysdate,'MM') AND RES_RESERVATION_DATE<= ADD_MONTHS( TRUNC(sysdate,'MM'), 1 )-1";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return count;
		
	}

	public int countQuesetion(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0 ; 
		String query = "select count(*) as count from question_tb where Q_ANSWER_CHECK ='N'";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}
	// todo: sql
	public int countNewMember(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0 ; 
		String query = "select count(*) as count from MEMBER_TB where MB_ENTDATE >= TRUNC(sysdate,'MM') AND MB_ENTDATE<= ADD_MONTHS( TRUNC(sysdate,'MM'), 1 )-1";
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

	public ArrayList<BoardVo> indexBoardList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		// 시작 페이지 계산 
		int start = 1;
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = 5;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select board_tb.* , row_number() over(order by bd_no desc) as num from board_tb where bd_category=?) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"공지사항");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVo bv = new BoardVo();
				bv.setBdNo(rs.getInt("BD_NO"));
				bv.setBdName(rs.getString("BD_NAME"));
				bv.setBdContents(rs.getString("BD_CONTENTS"));
				bv.setBdWriter(rs.getString("BD_WRITER"));
				bv.setBdWriteDate(rs.getTimestamp("BD_WRITE_DATE"));
				bv.setBdViewCount(rs.getInt("BD_VIEW_COUNT"));
				bv.setBdRecommendCount(rs.getInt("BD_RECOMMEND_COUNT"));
				bv.setBdCategory(rs.getString("BD_CATEGORY"));
				list.add(bv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public ArrayList<QuestionVo> indexQuestionList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QuestionVo> list = new ArrayList<QuestionVo>();
		// 시작 페이지 계산 
		int start = 1;
		// 만약 요청한 페이지가 1이라면 1		(1*10) - (10-1) = 10-9 =1
		// 만약 요청한 페이지가 2이라면 11 		(2*10) - 9	= 11

		// 끝 페이지 계산 
		int end = 5;	// 숫자가딱 맞지 않아도 된다.

		String query = "select * from "
				+ "(select question_tb.* , row_number() over(order by Q_NO desc) as num from question_tb where Q_ANSWER_CHECK =?) "
				+"where num between ? and ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,"N");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionVo qv = new QuestionVo();
				qv.setqNo(rs.getInt("Q_NO"));
				qv.setqName(rs.getString("Q_NAME"));
				qv.setqContents(rs.getString("Q_CONTENTS"));
				qv.setqWriter(rs.getString("Q_WRITER"));
				qv.setqWriteDate(rs.getTimestamp("Q_WRITE_DATE"));
				qv.setqAnswerCheck(rs.getString("Q_ANSWER_ChECK"));
				list.add(qv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	
}