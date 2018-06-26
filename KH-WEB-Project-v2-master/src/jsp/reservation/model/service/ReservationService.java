package jsp.reservation.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import jsp.common.JDBCTemplate;
import jsp.reservation.model.dao.ReservationDao;
import jsp.reservation.model.vo.PensionVo;
import jsp.reservation.model.vo.ReservationCancelVo;
import jsp.reservation.model.vo.ReservationHistoryVo;
import jsp.reservation.model.vo.ReservationVo;

public class ReservationService {

	// public ArrayList<ReservationVo> reservationList() { // step1. 예약 정보 전체 조회 (
	// 예약 리스트 읽어오기 )
	//
	// Connection conn = null;
	// conn = JDBCTemplate.getConnect(conn);
	// //System.out.println("DB연결확인: " + conn);
	// ArrayList<ReservationVo> list = new ReservationDao().reservationList(conn);
	// //System.out.println(list);
	// JDBCTemplate.close(conn);
	// return list;
	//
	// }

	public ArrayList<PensionVo> pensionList() { // 방 전체 정보

		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<PensionVo> list = new ReservationDao().pensionList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public PensionVo pensionInfo(String resRoomName) { // 방 1개 정보

		// 방이름(pk)으로 해당 방의 정보 검색하기
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		PensionVo pv = new ReservationDao().pensionInfo(conn, resRoomName);
		JDBCTemplate.close(conn);
		// System.out.println("Service: "+pv.getPsName());
		return pv;

	}

	// public AddPriceVo addPriceInfo(String resRoomCode) {
	//
	//
	// Connection conn = null;
	// conn = JDBCTemplate.getConnect(conn);
	// AddPriceVo apv = new ReservationDao().addPriceInfo(conn, resRoomCode);
	// JDBCTemplate.close(conn);
	//
	// return apv;
	//
	// }

	public ArrayList<ReservationVo> reservationDateList() { // 0박0일 계산하려면 필요함~!
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<ReservationVo> list = new ReservationDao().reservationDateList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public int addReservation(ReservationVo rv) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().addReservation(conn, rv);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<ReservationVo> loginIdReservationList(String loginId) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<ReservationVo> list = new ReservationDao().loginIdReservationList(conn, loginId);
		JDBCTemplate.close(conn);
		return list;
	}

	public int copyReservationList(int resNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().copyReservationList(conn, resNo);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteReservationList(int resNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().deleteReservationList(conn, resNo);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<ReservationCancelVo> loginIdCancelList(String loginId) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<ReservationCancelVo> list = new ReservationDao().loginIdCancelList(conn, loginId);
		JDBCTemplate.close(conn);
		return list;
	}

	public int moveReservationHistory(String today) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().moveReservationHistory(conn, today);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteReservationHistory(String today) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().deleteReservationHistory(conn, today);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteCheck(String id) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().deleteCheck(conn, id);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteEndCheck(String id) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().deleteEndCheck(conn, id);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<ReservationHistoryVo> loginIdHistoryList(String loginId) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<ReservationHistoryVo> list = new ReservationDao().loginIdHistoryList(conn, loginId);
		JDBCTemplate.close(conn);
		return list;
	}

	public int refundReservation(int rcNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().refundReservation(conn, rcNo);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	public int cancelReservation(int rcNo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnect(conn);
		int result = new ReservationDao().cancelReservation(conn, rcNo);
		if (result > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollBack(conn);
		JDBCTemplate.close(conn);
		return result;
	}
}