package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("소니 스피커 객체 생성 완료");
	}
	@Override
	public void powerOn() {
		System.out.println("SonySpeaker ==> 전원이 켜졌습니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("SonySpeaker ==> 전원이 꺼졌습니다.");
	}
}
