package jsp.main.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import jsp.common.JDBCTemplate;
import jsp.main.model.vo.DescriptionTb;
import jsp.main.model.vo.MainPicTb;
import jsp.main.model.vo.PensionPicTb;

public class MainDao {

	private PreparedStatement pstmt = null;
	private ResultSet rset = null;
	private Properties prop = new Properties();

	public MainDao() {
		String path = MainDao.class.getResource("").getPath();
		try {
			prop.load(new FileReader(path + "query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

// 펜션 메인 사진을 갖고 오는 DAO
	public ArrayList<MainPicTb> indexImage(Connection conn) {
		ArrayList<MainPicTb> list = new ArrayList<MainPicTb>();
		String query = prop.getProperty("image");

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				MainPicTb m = new MainPicTb();
				m.setMainPicPath(rset.getString("main_pic_path"));
				list.add(m);
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

// 펜션 정보를 가지고 오는 DAO
	public DescriptionTb introduce(Connection conn) {
		DescriptionTb r = null;
		String query = prop.getProperty("contents");
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				r = new DescriptionTb();
				r.setDesImagePath(rset.getString("DES_IMAGEPATH"));
				r.setDesAttention(rset.getString("DES_ATTENTION"));
				r.setDesRefund(rset.getString("DES_REFUND"));
				r.setDesAccount(rset.getString("DES_ACCOUNT"));
				r.setDesMainView(rset.getString("DES_MAINVIEW"));
				r.setDesPensionAbout(rset.getString("DES_PENSION_ABOUT"));
				r.setDesRoom(rset.getString("DES_ROOM"));
				r.setDesEtc(rset.getString("DES_ETC"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return r;
	}

// 펜션 메인 사진을 가지고 오는 DAO
	public ArrayList<PensionPicTb> room(Connection conn) {
		ArrayList<PensionPicTb> list = new ArrayList<PensionPicTb>();
		String query = prop.getProperty("room");
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				PensionPicTb ppt = new PensionPicTb();
				ppt.setpsPicName(rset.getString("ps_pic_name"));
				ppt.setPsPicPath(rset.getString("ps_pic_path"));
				ppt.setPsPicMain(rset.getString("ps_pic_main"));
				list.add(ppt);
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

// 방 사진을 가지고 오는 DAO
	public ArrayList<PensionPicTb> roomInfo(Connection conn, String roomName) {
		ArrayList<PensionPicTb> roomNameImage = new ArrayList<PensionPicTb>();
		String query = prop.getProperty("roomName");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, roomName);
			rset = pstmt.executeQuery();
			while(rset.next())
			{
				PensionPicTb ppt = new PensionPicTb();
				ppt.setPsPicPath(rset.getString("PS_PIC_PATH"));
				roomNameImage.add(ppt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return roomNameImage;
	}


}
