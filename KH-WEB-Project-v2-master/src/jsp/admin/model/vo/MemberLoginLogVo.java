package jsp.admin.model.vo;

import java.sql.Timestamp;

public class MemberLoginLogVo {
	private String mbLogId;
	private Timestamp mbLogTime;
	private String mbLogBrowser;
	private String mbLogIp;
	private String mbLogLocale;
	public String getMbLogId() {
		return mbLogId;
	}
	public void setMbLogId(String mbLogId) {
		this.mbLogId = mbLogId;
	}
	public Timestamp getMbLogTime() {
		return mbLogTime;
	}
	public void setMbLogTime(Timestamp mbLogTime) {
		this.mbLogTime = mbLogTime;
	}
	public String getMbLogBrowser() {
		return mbLogBrowser;
	}
	public void setMbLogBrowser(String mbLogBrowser) {
		this.mbLogBrowser = mbLogBrowser;
	}
	public String getMbLogIp() {
		return mbLogIp;
	}
	public void setMbLogIp(String mbLogIp) {
		this.mbLogIp = mbLogIp;
	}
	public String getMbLogLocale() {
		return mbLogLocale;
	}
	public void setMbLogLocale(String mbLogLocale) {
		this.mbLogLocale = mbLogLocale;
	}
	
	public MemberLoginLogVo() {
		super();
	}
	public MemberLoginLogVo(String mbLogId, Timestamp mbLogTime, String mbLogBrowser, String mbLogIp,
			String mbLogLocale) {
		super();
		this.mbLogId = mbLogId;
		this.mbLogTime = mbLogTime;
		this.mbLogBrowser = mbLogBrowser;
		this.mbLogIp = mbLogIp;
		this.mbLogLocale = mbLogLocale;
	}
	@Override
	public String toString() {
		return "MemberLoginLogVo [mbLogId=" + mbLogId + ", mbLogTime=" + mbLogTime + ", mbLogBrowser=" + mbLogBrowser
				+ ", mbLogIp=" + mbLogIp + ", mbLogLocale=" + mbLogLocale + "]";
	}
	
	
}
