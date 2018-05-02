package kh.java.member.view;


import java.util.Scanner;

import kh.java.com.Student;
import kh.java.member.controller.MemberController;
import kh.java.member.model.vo.Member;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	private MemberController mbCon = new MemberController(); 

	public void mainMenu()		// 메인 메뉴
	{
		while(true)
		{
			System.out.println("---------- 회원 관리 프로그램 ----------\n");
			System.out.println("1. 회원 가입");
			System.out.println("2. 회원 가입여부 확인");
			System.out.println("3. 회원 정보 보기(1명)");
			System.out.println("4. 회원 정보 변경하기");
			System.out.println("5. 회원 삭제 하기");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:memberJoin();break;
			case 2:memberCheck();break;
			case 3:memberSelect();break;
			case 4:memberModify();break;
			case 5:memberDelete();break;
			case 0:System.exit(0);
			default:
				System.out.println("0~5까지 선택해주세요.");
			}
		}
	}

	private void memberDelete() {
		System.out.println("======= 회원 삭제 하기 =======\n");
		System.out.print("삭제할 회원 아이디를 입력하세요 : ");
		String userId = sc.next();
		if(mbCon.memberDelete(userId))
		{
			System.out.println(userId+"님이 삭제 되었습니다.");
		}
		else
		{
			System.out.println("삭제 실패하였습니다. 아이디 재확인 바람");
		}
	}

	private void memberModify() {
		System.out.println("======= 회원 정보 변경 하기 =======\n");
		Member m = new Member();
		System.out.print("변경하실 회원의 아이디를 입력하세요 : ");
		String userId = sc.next();
		m.setUserId(userId);
		sc.nextLine();
		System.out.print("비밀번호(new) : ");
		m.setUserPwd(sc.nextLine());
		System.out.print("이름 (new) : ");
		m.setUserName(sc.next());
		System.out.print("나이(new)  : ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("폰 번호(new) : ");
		m.setPhoneNumber(sc.next());
		if(mbCon.memberModify(m))
		{
			System.out.println("회원 정보 변경이 완료되었습니다.");
		}
		else
		{
			System.out.println("해당 회원이 존재하지 않습니다.");
		}
	}

	private void memberSelect() {
		System.out.println("======= 회원 정보 보기 =======\n");
		System.out.print("조회할 회원 아이디를 입력하세요 : ");
		String userId = sc.next();
		Member s = mbCon.memberSelect(userId);
		if(s==null)
		{
			System.out.println("해당 회원이 존재하지 않습니다.");
		}
		else
		{
			System.out.println("조회 성공!");
			System.out.println("아이디 : "+s.getUserId());
			System.out.println("비밀번호 : "+s.getUserPwd());
			System.out.println("이름 : "+s.getUserName());
			System.out.println("나이 : "+s.getAge());
			System.out.println("폰번호 : "+s.getPhoneNumber());

		}

	}

	private void memberCheck() {
		System.out.println("======= 회원 가입 여부 확인 =======\n");
		System.out.print("회원 아이디를 입력하세요 : ");
		String userId = sc.next();
		System.out.println(mbCon.memberCheck(userId));
		if(mbCon.memberCheck(userId)==true)
		{
			System.out.println(userId+"회원은 현재 존재합니다. 다른 아이디를 사용해주세요");
		}
		else
		{
			System.out.println("회원이 존재하지 않습니다.");
		}
	}

	private void memberJoin() {
		sc.nextLine();
		Member m = new Member();
		System.out.println("======= 회원 가입 하기 =======");
		System.out.print("회원 아이디 입력 : ");
		m.setUserId(sc.next());
		sc.nextLine();
		System.out.print("회원 비밀번호 입력 : ");
		m.setUserPwd(sc.nextLine());
		System.out.print("회원 이름 입력 : ");
		m.setUserName(sc.next());
		System.out.print("회원 나이 입력 : ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("회원 폰 번호 입력 : ");
		m.setPhoneNumber(sc.next());
		if(mbCon.memberJoin(m)) {
			System.out.println("회원가입을 하였습니다.");
		}
		else
		{
			System.out.println("이미 아이디가 중복됩니다.");
		}



	}

}
