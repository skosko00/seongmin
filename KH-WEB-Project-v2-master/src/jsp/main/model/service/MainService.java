package jsp.main.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import jsp.common.JDBCTemplate;
import jsp.main.model.dao.MainDao;
import jsp.main.model.vo.MainPicTb;
import jsp.main.model.vo.PensionPicTb;
import jsp.main.model.vo.DescriptionTb;

public class MainService {

	private Connection conn = null;
	private MainDao mDao = new MainDao();
// index Image 가져오는 Service
	public ArrayList<MainPicTb> indexImage() {
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<MainPicTb> list = mDao.indexImage(conn);
		JDBCTemplate.close(conn);
		return list;
	}
// description_tb 가져오는 Service
	public DescriptionTb introduce() {
		conn = JDBCTemplate.getConnect(conn);
		DescriptionTb r = mDao.introduce(conn);
		JDBCTemplate.close(conn);
		return r;
	}
// PensionPicTb 갖고 오는 Service
	public ArrayList<PensionPicTb> room() {
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<PensionPicTb> list = mDao.room(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
// 방 사진을 갖고 오는 Service
	public ArrayList<PensionPicTb> roomInfo(String roomName) {
		conn = JDBCTemplate.getConnect(conn);
		ArrayList<PensionPicTb> roomNameImage = mDao.roomInfo(conn,roomName);
		JDBCTemplate.close(conn);
		return roomNameImage;
	}

}
