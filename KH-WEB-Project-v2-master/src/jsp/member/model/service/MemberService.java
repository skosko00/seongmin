package jsp.member.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import jsp.admin.model.vo.AnswerVo;
import jsp.common.JDBCTemplate;
import jsp.member.model.dao.MemberDao;
import jsp.member.model.vo.MemberVo;
import jsp.member.model.vo.QuestionVo;

public class MemberService {

	private Connection conn = null;
	private MemberDao mDao = new MemberDao();

	public MemberService() {

	}

	public int signUp(MemberVo mv) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.signUp(conn, mv);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int idCheck(String id) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.idCheck(conn, id);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int emailCheck(String email) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.emailCheck(conn, email);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public MemberVo login(String id, String pwd) {
		conn = JDBCTemplate.getConnect(conn);
		MemberVo mv = mDao.login(conn, id, pwd);
		JDBCTemplate.close(conn);
		return mv;
	}

	public int withDraw(String id, String pwd) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.withDraw(conn, id, pwd);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public MemberVo findId(String email, String name) {
		conn = JDBCTemplate.getConnect(conn);
		MemberVo data = mDao.findId(conn, email, name);
		JDBCTemplate.close(conn);
		return data;
	}

	public int findPwd(String id, String email) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.findPwd(conn, id, email);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public void tempPwdChange(String id, String email, String encryptTempPwd) {
		conn = JDBCTemplate.getConnect(conn);
		mDao.tempPwdChange(conn, id, email, encryptTempPwd);
		JDBCTemplate.close(conn);
	}

	public int pwdChange(String id, String pwdAfter) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.pwdChange(conn, id, pwdAfter);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	// ※ 페이징 (테스트 중)
	// public PageDataVo question(int currentPage) {
	//
	// conn = JDBCTemplate.getConnect(conn);
	//
	// int recordCountPerPage = 10;
	//
	// int naviCountPerPage = 5;
	//
	// ArrayList<QuestionVo> aList = mDao.getCurrentPage(conn, currentPage,
	// recordCountPerPage);
	//
	// String pageNavi = mDao.getPageNavi(conn, currentPage, recordCountPerPage,
	// naviCountPerPage);
	//
	// PageDataVo pd = null;
	// if (!aList.isEmpty() && !pageNavi.isEmpty()) {
	// pd = new PageDataVo();
	// pd.setaList(aList);
	// pd.setPageNavi(pageNavi);
	// }
	//
	// JDBCTemplate.close(conn);
	//
	// return pd;
	// }

	public int memberUpdate(String id, String phone, String fullAddress) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.memberUpdate(conn, id, phone, fullAddress);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<QuestionVo> questionList(String id) {
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<QuestionVo> aList = mDao.questionList(conn, id);
		JDBCTemplate.close(conn);
		return aList;
	}

	public int questionSend(String questionName, String questionContent, String id) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.questionSend(conn, questionName, questionContent, id);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public void memberLog(String logId, String logBrowser, String logIp, String logLocale) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.memberLog(conn, logId, logBrowser, logIp, logLocale);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
	}

	public QuestionVo myQuestion(String loadNo) {
		conn = JDBCTemplate.getConnect(conn);
		QuestionVo qv = mDao.myQuestion(conn, loadNo);
		JDBCTemplate.close(conn);
		return qv;
	}

	public AnswerVo myAnswer(String qNo) {
		conn = JDBCTemplate.getConnect(conn);
		AnswerVo av = mDao.myAnswer(conn, qNo);
		JDBCTemplate.close(conn);
		return av;
	}

	// 지은 추가
	public MemberVo loginIdInfo(String loginId) {
		conn = JDBCTemplate.getConnect(conn);
		MemberVo mv = mDao.loginIdInfo(conn, loginId);
		JDBCTemplate.close(conn);
		return mv;
	}

	public void memberDel(String delId, String delEmail, Date delEntDate, String delName, Date delBirth) {
		conn = JDBCTemplate.getConnect(conn);
		int result = mDao.memberDel(conn, delId, delEmail, delEntDate, delName, delBirth);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollBack(conn);
		}
		JDBCTemplate.close(conn);
	}

}
