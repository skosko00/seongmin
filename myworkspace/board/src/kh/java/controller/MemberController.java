package kh.java.controller;

import java.util.ArrayList;

import kh.java.model.service.MemberService;
import kh.java.model.vo.Member;

public class MemberController {
	public MemberController() {}
	private MemberService ms = new MemberService();
	
	public ArrayList<Member> allMember() {
		ArrayList<Member> list = ms.allMember();
		if(list.isEmpty())
			return null;
		else
			return list;
	}
	public Member serachId(String memberId) {
		Member m = ms.serachId(memberId);
		return m;
	}
	public ArrayList<Member> searchName(String memberName) {
		ArrayList<Member> list = ms.searchName(memberName);
		if(list.isEmpty())
			return null;
		else
			return list;		
	}
	public String insertMember(Member m) {
	int result = ms.insertMember(m);
	if(result>0)
	{
		return "회원가입 되었습니다";
	}
	else
	{
		return "회원가입에 실패하였습니다.";
	}
	}
	public String updateMember(Member m) {
		int result = ms.updateMember(m);
		if(result>0)
		{
			return "회원정보가 수정되었습니다.";
		}
		else
		{
			return "회원정보 수정에 실패하였습니다.";
		}
	}
	public String deleteMember(Member m) {
		int result = ms.deleteMember(m);
		if(result>0)
		{
			return "회원탈퇴 되었습니다.";
		}
		else
		{
			return "회원탈퇴가 정상처리되지 않았습니다.";
		}
	}
}
