package org.kh.bean.model.vo;

import java.util.Set;

public class CollectionSetBean {
	private Set<String> nameList;

	public CollectionSetBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionSetBean(Set<String> nameList) {
		super();
		this.nameList = nameList;
	}

	public Set<String> getNameList() {
		return nameList;
	}

	public void setNameList(Set<String> nameList) {
		this.nameList = nameList;
	}
}
