package jsp.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import jsp.admin.model.vo.AnswerVo;
import jsp.common.JDBCTemplate;
import jsp.member.model.vo.MemberVo;
import jsp.member.model.vo.QuestionVo;

public class MemberDao {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Properties prop = new Properties();

	public MemberDao() {
		String path = MemberDao.class.getResource("").getPath();
		try {
			prop.load(new FileReader(path + "query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int signUp(Connection conn, MemberVo mv) {

		int result = 0;

		String query = prop.getProperty("signUp");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, mv.getMbId());
			pstmt.setString(2, mv.getMbPwd());
			pstmt.setDate(3, mv.getMbBirth());
			pstmt.setString(4, mv.getMbEmail());
			pstmt.setString(5, mv.getMbPhone());
			pstmt.setString(6, mv.getMbGender());
			pstmt.setString(7, mv.getMbName());
			pstmt.setString(8, mv.getMbAddress());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// 네아로 아이디 이미 있는 값 확인 때문에 임시로 제거
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int idCheck(Connection conn, String id) {

		int result = 0;

		String query = prop.getProperty("idCheck");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(id)) {
					result = 1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int emailCheck(Connection conn, String email) {

		int result = 0;

		String query = prop.getProperty("emailCheck");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(email)) {
					result = 1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MemberVo login(Connection conn, String id, String pwd) {

		MemberVo mv = null;

		String query = prop.getProperty("login");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				mv = new MemberVo();
				mv.setMbId(rs.getString(1));
				mv.setMbPwd(rs.getString(2));
				mv.setMbBirth(rs.getDate(3));
				mv.setMbEmail(rs.getString(4));
				mv.setMbPhone(rs.getString(5));
				mv.setMbGender(rs.getString(6));
				mv.setMbName(rs.getString(7));
				mv.setMbEntDate(rs.getDate(8));
				mv.setMbAddress(rs.getString(9));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return mv;
	}

	public int withDraw(Connection conn, String id, String pwd) {

		int result = 0;

		String query = prop.getProperty("withDraw");

		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MemberVo findId(Connection conn, String email, String name) {

		MemberVo data = null;

		String query = prop.getProperty("findId");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, name);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				data = new MemberVo();
				data.setMbId(rs.getString(1));
				data.setMbEntDate(rs.getDate(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return data;
	}

	public int findPwd(Connection conn, String id, String email) {

		int result = 0;
		String chkId = "";

		String query = prop.getProperty("findPwd");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				chkId = rs.getString(1);
				if (id.equals(chkId)) {
					result = 1;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public void tempPwdChange(Connection conn, String id, String email, String encryptTempPwd) {

		String query = prop.getProperty("tempPwdChange");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, encryptTempPwd);
			pstmt.setString(2, id);
			pstmt.setString(3, email);

			pstmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
	}

	public int pwdChange(Connection conn, String id, String pwdAfter) {

		int result = 0;

		String query = prop.getProperty("pwdChange");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, pwdAfter);
			pstmt.setString(2, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// ※ 페이징 (테스트 중)
	// public ArrayList<QuestionVo> getCurrentPage(Connection conn, int currentPage,
	// int recordCountPerPage) {
	//
	// ArrayList<QuestionVo> aList = new ArrayList<QuestionVo>();
	//
	// int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
	//
	// int end = currentPage * recordCountPerPage;
	//
	// String query = prop.getProperty("getCurrentPage");
	//
	// try {
	// pstmt = conn.prepareStatement(query);
	// pstmt.setInt(1, start);
	// pstmt.setInt(2, end);
	//
	// rs = pstmt.executeQuery();
	//
	// while (rs.next()) {
	// QuestionVo qv = new QuestionVo();
	// qv.setqNo(rs.getInt(1));
	// qv.setqName(rs.getString(2));
	// qv.setqContents(rs.getString(3));
	// qv.setqWriter(rs.getString(4));
	// qv.setqWriteDate(rs.getTimestamp(5));
	// qv.setqAnswerDate(rs.getTimestamp(6));
	// qv.setqAnswerCheck(rs.getString(7));
	//
	// aList.add(qv);
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// JDBCTemplate.close(rs);
	// JDBCTemplate.close(pstmt);
	// }
	// return aList;
	// }
	//
	// public String getPageNavi(Connection conn, int currentPage, int
	// recordCountPerPage, int naviCountPerPage) {
	//
	// int recordTotalCount = 0;
	//
	// String query = prop.getProperty("getPageNavi");
	//
	// try {
	// pstmt = conn.prepareStatement(query);
	//
	// rs = pstmt.executeQuery();
	//
	// if (rs.next()) {
	// recordTotalCount = rs.getInt("totalcount");
	// }
	//
	// } catch (SQLException e) {
	// e.printStackTrace();
	// } finally {
	// JDBCTemplate.close(rs);
	// JDBCTemplate.close(pstmt);
	// }
	//
	// int pageTotalCount = 0;
	//
	// if (recordTotalCount % recordCountPerPage != 0) {
	// pageTotalCount = recordTotalCount / recordCountPerPage + 1;
	// } else
	// pageTotalCount = recordTotalCount / recordCountPerPage;
	//
	// if (currentPage < 1) {
	// currentPage = 1;
	// } else if (currentPage > pageTotalCount) {
	// currentPage = pageTotalCount;
	// }
	//
	// int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage +
	// 1;
	//
	// int endNavi = startNavi + naviCountPerPage - 1;
	//
	// if (endNavi > pageTotalCount) {
	// endNavi = pageTotalCount;
	// }
	//
	// boolean needPrev = true, needNext = true;
	//
	// if (startNavi == 1) {
	// needPrev = false;
	// }
	//
	// if (endNavi == pageTotalCount) {
	// needNext = false;
	// }
	//
	// // TODO : Ajax로 넘어가게 수정 필요
	// StringBuilder sb = new StringBuilder();
	// if (needPrev) {
	// sb.append("<a href='/question?currentPage=" + (startNavi - 1) + "'> 이전
	// </a>");
	// }
	// for (int i = startNavi; i <= endNavi; i++) {
	//
	// sb.append("<a href='/question?currentPage=" + i + "'>" + i + " </a>");
	//
	// }
	//
	// if (needNext) {
	// sb.append("<a href='/question?currentPage=" + (endNavi + 1) + "'> 다음 </a>");
	// }
	// return sb.toString();
	// }

	public int memberUpdate(Connection conn, String id, String phone, String fullAddress) {

		int result = 0;

		String query = prop.getProperty("memberUpdate");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, phone);
			pstmt.setString(2, fullAddress);
			pstmt.setString(3, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<QuestionVo> questionList(Connection conn, String id) {

		ArrayList<QuestionVo> aList = new ArrayList<QuestionVo>();

		String query = prop.getProperty("questionList");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QuestionVo qv = new QuestionVo();
				qv.setqNo(rs.getInt(1));
				qv.setqName(rs.getString(2));
				qv.setqContents(rs.getString(3));
				qv.setqWriter(rs.getString(4));
				qv.setqWriteDate(rs.getTimestamp(5));
				qv.setqAnswerCheck(rs.getString(6));

				aList.add(qv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}

		return aList;
	}

	public int questionSend(Connection conn, String questionName, String questionContent, String id) {

		int result = 0;

		String query = prop.getProperty("questionSend");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, questionName);
			pstmt.setString(2, questionContent);
			pstmt.setString(3, id);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int memberLog(Connection conn, String logId, String logBrowser, String logIp, String logLocale) {

		int result = 0;

		String query = prop.getProperty("memberLog");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, logId);
			pstmt.setString(2, logBrowser);
			pstmt.setString(3, logIp);
			pstmt.setString(4, logLocale);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public QuestionVo myQuestion(Connection conn, String loadNo) {

		QuestionVo qv = null;

		String query = prop.getProperty("myQuestion");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loadNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				qv = new QuestionVo();
				qv.setqNo(rs.getInt(1));
				qv.setqName(rs.getString(2));
				qv.setqContents(rs.getString(3));
				qv.setqWriter(rs.getString(4));
				qv.setqWriteDate(rs.getTimestamp(5));
				qv.setqAnswerCheck(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return qv;
	}

	public AnswerVo myAnswer(Connection conn, String qNo) {

		AnswerVo av = null;

		String query = prop.getProperty("myAnswer");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				av = new AnswerVo();
				av.setaContents(rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return av;

	}

	// 지은 추가
	public MemberVo loginIdInfo(Connection conn, String loginId) {

		MemberVo mv = null;
		String query = prop.getProperty("loginIdInfo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, loginId);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				mv = new MemberVo();
				mv.setMbId(rs.getString(1));
				mv.setMbPwd(rs.getString(2));
				mv.setMbBirth(rs.getDate(3));
				mv.setMbEmail(rs.getString(4));
				mv.setMbPhone(rs.getString(5));
				mv.setMbGender(rs.getString(6));
				mv.setMbName(rs.getString(7));
				mv.setMbEntDate(rs.getDate(8));
				mv.setMbAddress(rs.getString(9));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return mv;
	}

	public int memberDel(Connection conn, String delId, String delEmail, Date delEntDate, String delName,
			Date delBirth) {

		int result = 0;

		String query = prop.getProperty("memberDel");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, delId);
			pstmt.setString(2, delEmail);
			pstmt.setDate(3, delEntDate);
			pstmt.setString(4, delName);
			pstmt.setDate(5, delBirth);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
