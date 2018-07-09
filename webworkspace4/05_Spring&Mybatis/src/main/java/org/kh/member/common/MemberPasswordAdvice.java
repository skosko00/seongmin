package org.kh.member.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.kh.member.model.vo.Member;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MemberPasswordAdvice {
	
	@Pointcut("execution (* org.kh.member.model.service.*ServiceImpl.*Member(org.kh.member.model.vo.Member))")
	public void encrytionPass() {}
	
	@Before("encrytionPass()")
	public void passwordEncrytion(JoinPoint jp) throws Exception{
		Member vo = (Member)jp.getArgs()[0];
		
		String userPw = vo.getUserPw();	// 유저 비밀번호
		String encryPw = SHA256Util.encryptData(userPw);
		
		vo.setUserPw(encryPw);
		
		System.out.println("비밀번호 암호화 완료");
		System.out.println("암호화 전 데이터 : " + userPw);
		System.out.println("암호화 후 데이터 : " + encryPw);
		
	}
	
}
