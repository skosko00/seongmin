package file.model.vo;

import java.sql.Timestamp;

import oracle.sql.TIMESTAMP;

public class DataFile {
	private String fileName;
	private String filePath;
	private int fileSize;
	private String fileUser;
	private TIMESTAMP uploadTime;
	
	public DataFile() {
		// TODO Auto-generated constructor stub
	}

	public DataFile(String fileName, String filePath, int fileSize, String fileUser, TIMESTAMP uploadTime) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileUser = fileUser;
		this.uploadTime = uploadTime;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileUser() {
		return fileUser;
	}

	public void setFileUser(String fileUser) {
		this.fileUser = fileUser;
	}

	public TIMESTAMP getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(TIMESTAMP uploadTime) {
		this.uploadTime = uploadTime;
	}
}
