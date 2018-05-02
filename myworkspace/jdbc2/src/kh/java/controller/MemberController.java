package kh.java.controller;

import java.util.ArrayList;

import kh.java.model.service.MemberService;
import kh.java.model.vo.Member;

public class MemberController {

	public MemberController() {}

	public ArrayList<Member> allMember() {
		ArrayList<Member> list = new MemberService().allMember();

		if(list.isEmpty())
		{
			return null;
		}
		else
		{
			return list;
		}

	}

	public Member selectId(String memberId) {
		Member m = new MemberService().selectId(memberId);
		return m;
	}

	public ArrayList<Member> selectName(String memberName) {
		ArrayList<Member> list = new MemberService().selectName(memberName);

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
			return "회원가입이 되었습니다.";
		}
		else
		{
			return "회원가입에 실패하였습니다.";
		}
	}

	public String updateMember(Member m) {
		if(new MemberService().updateMember(m)>0)
		{
			return "회원정보가 변경되었습니다.";
		}
		else
		{
			return "회원정보 변경에 실패하였습니다.";
		}
		
	}

	public String deleteMember(Member m) {
		if(new MemberService().deleteMember(m)>0)
		{
			return m.getMemberId()+"회원이 탈퇴되었습니다.";
		}
		else
		{
			return "회원탈퇴에 실패하였습니다.";
		}
		
	}

}
