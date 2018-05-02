package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.controller.MemberController;
import kh.java.model.vo.Member;

public class MemberManager {
	public MemberManager() {}
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	public void menu() {
		while(true)
		{
			System.out.println("회원관리 서브메뉴");
			System.out.println("1. 전체회원조회");
			System.out.println("2. 회원 아이디로 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원가입");
			System.out.println("5. 회원정보수정(주소, 전화번호, 이메일)");
			System.out.println("6. 회원탈퇴");
			System.out.println("7. 메인메뉴");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1: allMember(); break;
			case 2: searchId(); break;
			case 3: searchName(); break;
			case 4: insertMember(); break;
			case 5: updateMember(); break;
			case 6: deleteMember(); break;
			case 7: return;
			}
		}
	}
	private void deleteMember() {
		Member m = null;
		System.out.print("탈퇴할 ID를 입력하세요 : ");
		String id = sc.next();
		m = mc.serachId(id);
		if(m==null)
		{
			System.out.println("없는 ID 입니다.");
		}
		else
		{
			System.out.print("비밀번호를 입력하세요 : ");
			m.setMemberPwd(sc.next());
			System.out.print("정말로 탈퇴하시겠습니까?(y,n) : ");
			if(sc.next().toUpperCase().charAt(0)=='Y')
			{
				System.out.println(mc.deleteMember(m));
			}
		}
	}
	private void updateMember() {
		Member m = null;
		System.out.print("회원정보를 변경할 ID 입력 : ");
		String id = sc.next();
		m = mc.serachId(id);
		if(m==null)
		{
			System.out.println("없는 ID 입니다.");
		}
		else
		{
			sc.nextLine();
			System.out.print("주소 입력 : ");
			m.setAddress(sc.nextLine());
			System.out.print("전화번호 입력 : ");
			m.setPhone(sc.next());
			System.out.print("이메일 입력 : ");
			m.setEmail(sc.next());
			System.out.println(mc.updateMember(m));
		}
	}
	private void insertMember() {
		Member m = new Member();
		System.out.print("아이디 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("비밀번호 입력 : ");
		m.setMemberPwd(sc.next());
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("이메일 입력 : ");
		m.setEmail(sc.next());
		sc.nextLine();
		System.out.print("주소 입력 : ");
		m.setAddress(sc.nextLine());
		System.out.print("휴대폰 입력 : ");
		m.setPhone(sc.next());
		System.out.println(mc.insertMember(m));
	}
	private void searchName() {
		System.out.print("조회할 이름을 입력하세요 : ");
		String memberName = sc.next();
		ArrayList<Member> list = mc.searchName(memberName);
		if(list==null)
		{
			System.out.println("저장된 회원이 없습니다.");
		}else
		{
			System.out.println("전체회원조회");
			System.out.println("번호  아이디  비밀번호  이름  이메일  주소  폰번호  가입날짜");
			for(Member m : list)
				System.out.println(m);
		}		
	}
	private void searchId() {
		System.out.print("조회할 ID를 입력하세요 : ");
		String memberId = sc.next();
		Member m = mc.serachId(memberId);
		if(m==null)
		{
			System.out.println("조회된 "+memberId + "가 없습니다.");
		}
		else
		{
			System.out.println(m);
		}

	}
	private void allMember() {
		ArrayList<Member> list = mc.allMember();
		if(list==null)
		{
			System.out.println("저장된 회원이 없습니다.");
		}else
		{
			System.out.println("전체회원조회");
			System.out.println("번호  아이디  비밀번호  이름  이메일  주소  폰번호  가입날짜");
			for(Member m : list)
				System.out.println(m);
		}
	}

}
