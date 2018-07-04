package org.kh.test.ano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("comMgr")
public class ComMgr {
	@Autowired()
	private Computer com;
	public ComMgr() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComMgr(Computer com) {
		super();
		this.com = com;
	}
	public Computer getCom() {
		return com;
	}
	public void setCom(Computer com) {
		this.com = com;
	}
}
