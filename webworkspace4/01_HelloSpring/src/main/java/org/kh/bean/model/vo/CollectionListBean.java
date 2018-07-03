package org.kh.bean.model.vo;

import java.util.List;

public class CollectionListBean {
	private List<String> nameList;

	public CollectionListBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionListBean(List<String> nameList) {
		super();
		this.nameList = nameList;
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
}
