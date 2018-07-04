package org.kh.member.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	// 생성자를 통해 컨트롤러를 미리 생성 해 놓고 매핑값을 넣어줌
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
	}
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
