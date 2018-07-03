package org.kh.bean.model.vo;

import java.util.Map;

public class CollectionMapBean {
	private Map<String,String> addressMap;

	public CollectionMapBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectionMapBean(Map<String,String> addressMap) {
		super();
		this.addressMap = addressMap;
	}

	public Map<String,String> getAddressMap() {
		return addressMap;
	}

	public void setAddressMap(Map<String,String> addressMap) {
		this.addressMap = addressMap;
	}
}
