package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("computer")
public class Computer {
	public Computer() {
		System.out.println("컴퓨터 객체 생성 성공!");
	}
}
