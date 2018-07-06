package org.kh.member.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class LogAdvice {
	public void printLog() {
		System.out.println("[공통로그 - LogAdvice] : 비즈니스 로직 수행 전 로그 기록");
	}
	
	public void printTransactionLog() {
		System.out.println("[트랜잭션 로그 - LogAdvice] : 트랜잭션 처리 로그");
	}
	
	public Object arroundLog(ProceedingJoinPoint pjp)throws Throwable {
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("kk시 mm분 ss초");
		String getTime = sdf.format(date);
		
		System.out.println("[BEFORE : "+getTime+"] : 비즈니스 메소드 수행 전 로그");
		Object returnObj = pjp.proceed();	// proceed 메소드를 바탕으로 전과 후로 나누어짐
		
		now = System.currentTimeMillis();
		date = new Date(now);
		sdf = new SimpleDateFormat("kk시 mm분 ss초");
		getTime = sdf.format(date);
		System.out.println("[AFTER : "+getTime+"] : 비즈니스 메소드 수행 후 로그");
		
		System.out.println("===== 기타 정보 =====");
		Signature sig = pjp.getSignature();
		System.out.println(sig.getName());
		
		return returnObj;
	}
}
