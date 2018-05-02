package kh.java.member.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import kh.java.member.model.vo.Member;

public class MemberController {

	private HashMap<String,Member> member = new HashMap<String,Member>();

	public boolean memberJoin(Member m) {
		if(member.containsKey(m.getUserId()))
		{
			return false;
		}
		else
		{
			member.put(m.getUserId(), m);
			return true;
		}
	}

	public boolean memberCheck(String userId) {

		if(member.containsKey(userId))
		{
			return true;
		}
		return false;		

	}

	public Member memberSelect(String userId) {

		if(member.containsKey(userId))
		{
			return member.get(userId);
		}
		return null;	


	}

	public boolean memberModify(Member m) {

		if(member.containsKey(m.getUserId()))
		{
			member.put(m.getUserId(), m);
			return true;
		}
		return false;
	}

	public boolean memberDelete(String userId) {
		
		if(member.containsKey(userId))
		{
			member.remove(userId);
			return true;
		}
		return false;
	}

}
