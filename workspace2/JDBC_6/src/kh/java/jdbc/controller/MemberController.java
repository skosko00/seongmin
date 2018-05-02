package kh.java.jdbc.controller;

import java.util.ArrayList;

import kh.java.jdbc.Exception.MemberException;
import kh.java.jdbc.model.service.MemberService;
import kh.java.jdbc.model.vo.Member;

// View에서 요청이 들어온 작업은
// Controller에서 DAO로 요청 작업을 해야함


public class MemberController {
	public MemberController() {}	// 기본 생성자

	public ArrayList<Member> selectAll() {
		ArrayList<Member> list=new ArrayList<Member>();
		try {
			list = new MemberService().selectAll();
		} catch (MemberException e) {
			System.out.println("Controller : 전체 회원 조회 실패");
			System.out.println(e.getMessage());
		}
		if(list.isEmpty())	// DAO에서 넘어온 list가 비워져 있다면!
		{
			return null;
		}
		else				// 그렇지 않고 채워져 있다면! (정보가 있다면!!!)
		{
			return list;	// list 객체를 리턴
		}
	}

	public Member selectOneId(String memberId) {
		Member m = new MemberService().selectOneId(memberId);		
		return m;
	}

	public ArrayList<Member> selectName(String memberName) {
		ArrayList <Member> list = new MemberService().selectName(memberName);
		if(list.isEmpty())
		{
			return null;
		}
		else
		{
		return list;
		}
	}

	public String insertMember(Member m) {
		if(new MemberService().insertMember(m)>0)
		{
			return "회원가입이 완료 되었습니다.";
		}
		else
		{
			return "회원가입에 실패하였습니다.";
		}
		
	}

	public boolean updateMember(Member m) {
		if(new MemberService().updateMember(m)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public boolean deleteMember(Member m) {
		if(new MemberService().deleteMember(m)>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}



}
