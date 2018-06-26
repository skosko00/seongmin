package jsp.member.model.vo;

import java.sql.Date;

public class FindIdVo {

	private String id;
	private Date entDate;

	public FindIdVo(String id, Date entDate) {
		super();
		this.id = id;
		this.entDate = entDate;
	}

	public FindIdVo() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getEntDate() {
		return entDate;
	}

	public void setEntDate(Date entDate) {
		this.entDate = entDate;
	}
}
