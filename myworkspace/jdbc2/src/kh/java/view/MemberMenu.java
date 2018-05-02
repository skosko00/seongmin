package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.controller.MemberController;
import kh.java.model.vo.Member;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);

	public MemberMenu() {}

	public void Menu()
	{
		while(true)
		{
			System.out.println("= = = = = = 회원 관리 프로그램 = = = = = =");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 회원 아이디 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택(0~6) : ");
			switch(sc.nextInt())
			{
			case 1:
				allMember();
				break;
			case 2:
				selectId();
				break;
			case 3:
				selectName();
				break;
			case 4:
				insertMember();
				break;
			case 5:
				updateMember();
				break;
			case 6:
				deleteMember();
				break;
			case 0:
				System.out.print("정말 종료하시겠습니까?(y,n)");
				if(sc.next().toUpperCase().charAt(0)=='Y')
				{
					System.out.println("프로그램이 종료되었습니다.");
					System.exit(0);
				}
			}
		}
	}
	private void allMember() {
		ArrayList<Member> list = new MemberController().allMember();
		if(list==null)
		{
			System.out.println("검색된 회원이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = 전체 회원 조회 = = = = =");
			System.out.println("아이디  비밀번호  이름  성별  나이  이메일  폰번호  주소  취미 가입날짜");
			for(Member m : list) 
			{
				System.out.println(m);
			}
		}

	}
	
	private void selectId() {
		
		System.out.print("조회할 아이디를 입력하세요 : ");
		String memberId = sc.next();
		Member m = new MemberController().selectId(memberId);
		
		if(m==null)
		{
			System.out.println(memberId + "회원이 없습니다.");
		}else
		{
			System.out.println(m);
		}
	}
	
	private void selectName() {
		
		System.out.print("검색할 회원의 이름을 입력하세요 : ");
		String memberName = sc.next();
		ArrayList<Member> list = new MemberController().selectName(memberName);
		
		if(list==null)
		{
			System.out.println("검색된 회원이 없습니다.");
		}
		else
		{
			for(Member m :list)
			{
				System.out.println(m);
			}
		}

	}
	
	private void insertMember() {
		Member m = new Member();
		System.out.println("----------- 회 원 가 입 -----------");
		System.out.print("아이디 입력 : ");
		m.setMemberId(sc.next());
		System.out.print("비밀번호 입력 : ");
		m.setMemberPwd(sc.next());
		System.out.print("이름 입력 : ");
		m.setMemberName(sc.next());
		System.out.print("나이 입력 : ");
		m.setAge(sc.nextInt());
		System.out.print("성별(남/여) : ");
		String gender = sc.next();
		if(gender.equals("남")) m.setGender("M");
		else if(gender.equals("여")) m.setGender("F");
		System.out.print("이메일 입력 : ");
		m.setEmail(sc.next());
		sc.nextLine();
		System.out.print("주소 입력 : ");
		m.setAddress(sc.nextLine());
		System.out.print("전화번호(-빼고) 입력 : ");
		m.setPhone(sc.next());
		System.out.print("취미(,로 공백없이 나열) 입력 : ");
		m.setHobby(sc.next());

		System.out.println(new MemberController().insertMember(m));

	}

	private void updateMember() {
		Member m = null;
		
		System.out.print("회원정보 변경할 아이디 입력 : ");
		String memberId = sc.next();
		
		m = new MemberController().selectId(memberId);
		if(m==null)
		{
			System.out.println("회원정보가 없습니다.");
		}
		else
		{
			System.out.println("수정할 정보 입력");
			System.out.print("암호 입력 : ");
			m.setMemberPwd(sc.next());
			System.out.print("이메일 입력 : ");
			m.setEmail(sc.next());
			System.out.print("전화번호(-빼고) 입력 : ");
			m.setPhone(sc.next());
			sc.nextLine();
			System.out.print("주소 입력 : ");
			m.setAddress(sc.nextLine());
			System.out.println(new MemberController().updateMember(m));
		}

	}
	
	private void deleteMember() {
		Member m = null;
		
		System.out.print("삭제할 회원 ID 입력 : ");
		String memberId = sc.next();
		
		m = new MemberController().selectId(memberId);
		if(m==null)
		{
			System.out.println(memberId+" ID는 존재하지 않습니다.");
		}
		else
		{
			System.out.print("정말로 삭제하시겠습니까?(y,n)");
			if(sc.next().toUpperCase().charAt(0)=='Y')
			{
				System.out.print("비밀번호를 입력해 주세요 : ");
				m.setMemberPwd(sc.next());
				System.out.println(new MemberController().deleteMember(m));
			}
		}
	}

}
