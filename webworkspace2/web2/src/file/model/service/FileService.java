package file.model.service;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import common.JDBCTemplate;
import file.model.dao.FileDAO;
import file.model.vo.DataFile;
import file.model.vo.DataFile2;

public class FileService {

	public int uploadFile(DataFile df) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FileDAO().uploadFile(conn,df);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public ArrayList<DataFile> fileList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<DataFile> list = new FileDAO().fileList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public DataFile fileSelectDownLoad(String fileName, Timestamp uploadTime) {
		Connection conn = JDBCTemplate.getConnection();
		DataFile df = new FileDAO().fileSelectDownLoad(conn,fileName,uploadTime);
		JDBCTemplate.close(conn);
		return df;
	}

	public int uploadFile2(DataFile2 df) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FileDAO().uploadFile2(conn,df);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}
		else
		{
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	public ArrayList<DataFile2> fileList2() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<DataFile2> list = new FileDAO().fileList2(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public DataFile2 fileSelectDownLoad2(String afterfileName) {
		Connection conn = JDBCTemplate.getConnection();
		DataFile2 df = new FileDAO().fileSelectDownLoad2(conn,afterfileName);
		JDBCTemplate.close(conn);
		return df;
	}

	public int fileSelectDelete(String fileName, Timestamp uploadTime) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FileDAO().fileSelectDelete(conn, fileName, uploadTime);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int fileSelectDelete2(String afterfileName) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new FileDAO().fileSelectDelete2(conn, afterfileName);
		if(result>0)
		{
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
