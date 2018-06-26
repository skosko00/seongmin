package jsp.reservation.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import jsp.common.JDBCTemplate;
import jsp.reservation.model.vo.PensionVo;
import jsp.reservation.model.vo.ReservationCancelVo;
import jsp.reservation.model.vo.ReservationHistoryVo;
import jsp.reservation.model.vo.ReservationVo;

public class ReservationDao {

	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = new Properties();

	public ReservationDao() {
		String path = ReservationDao.class.getResource("").getPath();
		try {
			prop.load(new FileReader(path + "query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public ArrayList<ReservationVo> reservationList(Connection conn) { // 예약리스트
	// 전체조회
	//
	// PreparedStatement pstmt = null;
	// ResultSet rset = null;
	// ArrayList<ReservationVo> list = null;
	//
	// String query = "SELECT * FROM RESERVATION_TB";
	//
	// try {
	//
	// pstmt = conn.prepareStatement(query);
	// rset = pstmt.executeQuery();
	//
	// list = new ArrayList<ReservationVo>();
	//
	// while(rset.next()) {
	// ReservationVo r = new ReservationVo();
	//
	// r.setResNo(rset.getInt("res_no"));
	// r.setResRoomName(rset.getString("res_room_name"));
	// r.setResId(rset.getString("res_id"));
	// r.setResPersonnel(rset.getInt("res_personnel"));
	// r.setResReservationDate(rset.getTimestamp("res_reservation_date"));
	// r.setResInDate(rset.getDate("res_in_date"));
	// r.setResOutDate(rset.getDate("res_out_date"));
	// r.setResPeriod(rset.getInt("res_period"));
	// r.setResPrice(rset.getInt("res_price"));
	// r.setResPaymentDate(rset.getTimestamp("res_payment_date"));
	//
	// list.add(r);
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// JDBCTemplate.close(rset);
	// JDBCTemplate.close(pstmt);
	// }
	//
	// return list;
	// }

	public ArrayList<PensionVo> pensionList(Connection conn) { // 방 정보 전체 조회
		ArrayList<PensionVo> list = null;

		String query = prop.getProperty("pensionList");

		try {

			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			list = new ArrayList<PensionVo>();

			while (rset.next()) {
				PensionVo pv = new PensionVo();

				pv.setPsName(rset.getString("ps_name"));
				pv.setPsPersonnel(rset.getInt("ps_personnel"));
				pv.setPsMaxPersonnel(rset.getInt("ps_max_personnel"));
				pv.setPsContents(rset.getString("ps_contents"));
				pv.setPsWeekend(rset.getInt("ps_weekend"));
				pv.setPsWeekday(rset.getInt("ps_weekday"));
				pv.setPsAddtionalPrice(rset.getInt("ps_additional_price"));

				list.add(pv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;

	}

	/* 두개를 합쳐서 쓸 수는 있겠지ㅣㅣㅣㅣㅣㅣ 근데 뭐가 더 편할까,,,,,????????????? */

	public PensionVo pensionInfo(Connection conn, String resRoomName) { // 방 정보 1개만 조회
		PensionVo pv = null;

		String query = prop.getProperty("pensionInfo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, resRoomName);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				pv = new PensionVo();

				pv.setPsName(rset.getString("ps_name"));
				pv.setPsPersonnel(rset.getInt("ps_personnel"));
				pv.setPsMaxPersonnel(rset.getInt("ps_max_personnel"));
				pv.setPsContents(rset.getString("ps_contents"));
				pv.setPsWeekend(rset.getInt("ps_weekend"));
				pv.setPsWeekday(rset.getInt("ps_weekday"));
				pv.setPsAddtionalPrice(rset.getInt("ps_additional_price"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		// System.out.println("DAO: "+pv.getPsName());
		return pv;

	}
	//
	// public AddPriceVo addPriceInfo(Connection conn, String resRoomCode) {
	//
	//
	// PreparedStatement pstmt = null;
	// ResultSet rset = null;
	// AddPriceVo apv = null;
	//
	// String query = "select * from add_price_tb where add_pr_room_no=?";
	// // 임시 테이블 -> 나중에 정식 테이블로 수정하기
	//
	// try {
	// pstmt = conn.prepareStatement(query);
	// pstmt.setInt(1, Integer.parseInt(resRoomCode));
	//
	// rset = pstmt.executeQuery();
	//
	// if(rset.next()) {
	// apv = new AddPriceVo();
	//
	// apv.setAddPrRoomNo(rset.getInt("add_pr_room_no"));
	// apv.setAddPrWeekend(rset.getInt("add_pr_weekend"));
	// apv.setAddPrWeekday(rset.getInt("add_pr_weekday"));
	// apv.setAddPrAddtionalPrice(rset.getInt("add_pr_addtional_price"));
	//
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// JDBCTemplate.close(rset);
	// JDBCTemplate.close(pstmt);
	// }
	//
	// return apv;
	// }

	// 추가
	public ArrayList<ReservationVo> reservationDateList(Connection conn) { // 0박0일 출력 시 필요한 메소드
		ArrayList<ReservationVo> list = null;

		String query = prop.getProperty("reservationDateList");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationVo>();

			while (rset.next()) {

				ReservationVo r = new ReservationVo();

				r.setResNo(rset.getInt("res_no"));
				r.setResRoomName(rset.getString("res_room_name"));
				r.setResId(rset.getString("res_id"));
				r.setResPersonnel(rset.getInt("res_personnel"));
				r.setResReservationDate(rset.getTimestamp("res_reservation_date"));
				r.setResInDate(rset.getDate("res_in_date"));
				r.setResOutDate(rset.getDate("res_out_date"));
				r.setResPeriod(rset.getInt("res_period"));
				r.setResPrice(rset.getInt("res_price"));
				r.setResPaymentDate(rset.getTimestamp("res_payment_date"));

				list.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public int addReservation(Connection conn, ReservationVo rv) {
		int result = 0;

		String query = prop.getProperty("addReservation");
		// 결제 날짜는 더 생각해보기

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rv.getResRoomName());
			pstmt.setString(2, rv.getResId());
			pstmt.setInt(3, rv.getResPersonnel());
			pstmt.setDate(4, rv.getResInDate());
			pstmt.setDate(5, rv.getResOutDate());
			pstmt.setInt(6, rv.getResPeriod());
			pstmt.setInt(7, rv.getResPrice());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	public ArrayList<ReservationVo> loginIdReservationList(Connection conn, String loginId) {

		ArrayList<ReservationVo> list = null;
		String query = prop.getProperty("loginIdReservationList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationVo>();

			while (rset.next()) {
				ReservationVo r = new ReservationVo();

				r.setResNo(rset.getInt("res_no"));
				r.setResRoomName(rset.getString("res_room_name"));
				r.setResId(rset.getString("res_id"));
				r.setResPersonnel(rset.getInt("res_personnel"));
				r.setResReservationDate(rset.getTimestamp("res_reservation_date"));
				r.setResInDate(rset.getDate("res_in_date"));
				r.setResOutDate(rset.getDate("res_out_date"));
				r.setResPeriod(rset.getInt("res_period"));
				r.setResPrice(rset.getInt("res_price"));
				r.setResPaymentDate(rset.getTimestamp("res_payment_date"));

				list.add(r);
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

	public int copyReservationList(Connection conn, int resNo) {

		int result = 0;
		String query = prop.getProperty("copyReservationList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, resNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;

	}

	public int deleteReservationList(Connection conn, int resNo) {

		int result = 0;
		String query = prop.getProperty("deleteReservationList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, resNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}

		return result;
	}

	public ArrayList<ReservationCancelVo> loginIdCancelList(Connection conn, String loginId) {

		ArrayList<ReservationCancelVo> list = null;
		String query = prop.getProperty("loginIdCancelList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationCancelVo>();

			while (rset.next()) {
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public int deleteCheck(Connection conn, String id) {

		int result = 0;

		String query = prop.getProperty("deleteCheck");
		String chkStr = "";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				chkStr = rset.getString(3);
				if (chkStr.equals(id)) {
					result = 1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteEndCheck(Connection conn, String id) {

		int result = 0;

		String query = prop.getProperty("deleteEndCheck");
		String chkStr1 = "";
		String chkStr2 = "";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				chkStr1 = rset.getString(13);
				chkStr2 = rset.getString(14);

				System.out.println(chkStr1);
				System.out.println(chkStr2);

				if (chkStr1.equals("N") || chkStr2.equals("N")) {
					result = 1;
				} else {
					result = 0;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
  
  public int moveReservationHistory(Connection conn, String today) {
		
		int result=0;
		String query = prop.getProperty("moveReservationHistory");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, today);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteReservationHistory(Connection conn, String today) {
		
		int result=0;
		String query = prop.getProperty("deleteReservationHistory");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, today);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ReservationHistoryVo> loginIdHistoryList(Connection conn, String loginId) {
		
		ArrayList<ReservationHistoryVo> list = null;
		String query = prop.getProperty("loginIdHistoryList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginId);
			rset = pstmt.executeQuery();

			list = new ArrayList<ReservationHistoryVo>();

			while (rset.next()) {
				
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;
	}

	public int refundReservation(Connection conn, int rcNo) {
		
		int result = 0;
		String query = prop.getProperty("refundReservation");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rcNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}

	public int cancelReservation(Connection conn, int rcNo) {
		
		int result = 0;
		String query = prop.getProperty("cancelReservation");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, rcNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}



}
