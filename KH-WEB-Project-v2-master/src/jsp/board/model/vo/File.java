package jsp.board.model.vo;

import java.sql.Timestamp;

public class File {
	public File() {
	}

	private int BD_FILE_NO;
	private long BD_FILE_SIZE;
	private String BD_FILE_NAME;
	private Timestamp BD_FILE_UPTIME;
	private String BD_FILE_WRITER;
	private int BD_FILE_COUNT;
	private String BD_FILE_PATH;
	private int BD_FILE_BD_NO;

	public File(int BD_FILE_NO, long BD_FILE_SIZE, String BD_FILE_NAME, Timestamp BD_FILE_UPTIME, String BD_FILE_WRITER,
			int BD_FILE_COUNT, String BD_FILE_PATH, int BD_FILE_BD_NO) {
		super();
		this.BD_FILE_NO = BD_FILE_NO;
		this.BD_FILE_SIZE = BD_FILE_SIZE;
		this.BD_FILE_NAME = BD_FILE_NAME;
		this.BD_FILE_UPTIME = BD_FILE_UPTIME;
		this.BD_FILE_WRITER = BD_FILE_WRITER;
		this.BD_FILE_COUNT = BD_FILE_COUNT;
		this.BD_FILE_PATH = BD_FILE_PATH;
		this.BD_FILE_BD_NO = BD_FILE_BD_NO;
	}

	public int getBD_FILE_NO() {
		return this.BD_FILE_NO;
	}

	public void setBD_FILE_NO(int BD_FILE_NO) {
		this.BD_FILE_NO = BD_FILE_NO;
	}

	public long getBD_FILE_SIZE() {
		return BD_FILE_SIZE;
	}

	public void setBD_FILE_SIZE(long BD_FILE_SIZE) {
		this.BD_FILE_SIZE = BD_FILE_SIZE;
	}

	public String getBD_FILE_NAME() {
		return BD_FILE_NAME;
	}

	public void setBD_FILE_NAME(String BD_FILE_NAME) {
		this.BD_FILE_NAME = BD_FILE_NAME;
	}

	public Timestamp getBD_FILE_UPTIME() {
		return BD_FILE_UPTIME;
	}

	public void setBD_FILE_UPTIME(Timestamp BD_FILE_UPTIME) {
		this.BD_FILE_UPTIME = BD_FILE_UPTIME;
	}

	public String getBD_FILE_WRITER() {
		return BD_FILE_WRITER;
	}

	public void setBD_FILE_WRITER(String BD_FILE_WRITER) {
		this.BD_FILE_WRITER = BD_FILE_WRITER;
	}

	public int getBD_FILE_COUNT() {
		return BD_FILE_COUNT;
	}

	public void setBD_FILE_COUNT(int BD_FILE_COUNT) {
		this.BD_FILE_COUNT = BD_FILE_COUNT;
	}

	public String getBD_FILE_PATH() {
		return BD_FILE_PATH;
	}

	public void setBD_FILE_PATH(String BD_FILE_PATH) {
		this.BD_FILE_PATH = BD_FILE_PATH;
	}

	public int getBD_FILE_BD_NO() {
		return BD_FILE_BD_NO;
	}

	public void setBD_FILE_BD_NO(int BD_FILE_BD_NO) {
		this.BD_FILE_BD_NO = BD_FILE_BD_NO;
	}

}
