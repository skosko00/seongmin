package org.kh.test.ano;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker{
	public AppleSpeaker() {
		System.out.println("애플 스피커 객체 생성 완료");
	}
	@Override
	public void powerOn() {
		System.out.println("AppleSpeaker ==> 전원이 켜졌습니다.");
	}
	@Override
	public void powerOff() {
		System.out.println("AppleSpeaker ==> 전원이 꺼졌습니다.");
	}
}
