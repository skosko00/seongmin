package jsp.board.model.vo;

import java.sql.Timestamp;

public class DataFile {
	public DataFile() {
	}

	private int bdFileNo;
	private long bdFileSize;
	private String bdFileName;
	private Timestamp bdFileUptime;
	private String bdFileWriter;
	private int bdFileCount;
	private String bdFilePath;
	private int bdFilebdNo;

	public DataFile(int bdFileNo, long bdFileSize, String bdFileName, Timestamp bdFileUptime, String bdFileWriter,
			int bdFileCount, String bdFilePath, int bdFilebdNo) {
		super();
		this.bdFileNo = bdFileNo;
		this.bdFileSize = bdFileSize;
		this.bdFileName = bdFileName;
		this.bdFileUptime = bdFileUptime;
		this.bdFileWriter = bdFileWriter;
		this.bdFileCount = bdFileCount;
		this.bdFilePath = bdFilePath;
		this.bdFilebdNo = bdFilebdNo;
	}

	public int getBdFileNo() {
		return this.bdFileNo;
	}

	public void setBdFileNo(int bdFileNo) {
		this.bdFileNo = bdFileNo;
	}

	public long getBdFileSize() {
		return bdFileSize;
	}

	public void setBdFileSize(long bdFileSize) {
		this.bdFileSize = bdFileSize;
	}

	public String getBdFileName() {
		return bdFileName;
	}

	public void setBdFileName(String bdFileName) {
		this.bdFileName = bdFileName;
	}

	public Timestamp getBdFileUptime() {
		return bdFileUptime;
	}

	public void setBdFileUptime(Timestamp bdFileUptime) {
		this.bdFileUptime = bdFileUptime;
	}

	public String getBdFileWriter() {
		return bdFileWriter;
	}

	public void setBdFileWriter(String bdFileWriter) {
		this.bdFileWriter = bdFileWriter;
	}

	public int getBdFileCount() {
		return bdFileCount;
	}

	public void setBdFileCount(int bdFileCount) {
		this.bdFileCount = bdFileCount;
	}

	public String getBdFilePath() {
		return bdFilePath;
	}

	public void setBdFilePath(String bdFilePath) {
		this.bdFilePath = bdFilePath;
	}

	public int getBdFilebdNo() {
		return bdFilebdNo;
	}

	public void setBdFilebdNo(int bdFilebdNo) {
		this.bdFilebdNo = bdFilebdNo;
	}

}
