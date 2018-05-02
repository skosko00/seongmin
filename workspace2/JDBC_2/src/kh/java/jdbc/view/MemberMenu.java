package kh.java.jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.GroupLayout.SequentialGroup;

import kh.java.jdbc.controller.MemberController;
import kh.java.jdbc.model.vo.Member;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);

	public MemberMenu() {}	// 기본 생성자
	public void mainMenu()
	{
		while(true)
		{
			int select;
			System.out.println("\n = = = = = = 회원 관리 프로그램 = = = = = =");
			System.out.println("1. 회원 정보 전체 조회 ");
			System.out.println("2. 회원 아이디 조회");
			System.out.println("3. 회원 이름으로 조회");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택(0~6) : ");
			select = sc.nextInt();
			sc.nextLine();
			switch(select)
			{
			case 1: selectAll(); break;
			case 2: selectOneId(); break;
			case 3: selectName(); break;
			case 4: insertMember(); break;
			case 5: updateMember(); break;
			case 6:deleteMember(); break;
			case 0:
				System.out.print("정말 끝내시겠습니까?(y.n)");
				if(sc.next().toUpperCase().charAt(0)=='Y')
				{
					System.out.println("종료 되었습니다.");
					System.exit(0);
				}
			default : System.out.println("번호를 잘못 선택하셨씁니다.");
			}
		}

	}

	public void selectAll()	// 회원 전체 정보 조회 메소드
	{
		ArrayList<Member> list = new MemberController().selectAll();
		// 회원 전체 정보를 컨트롤러에게 요청

		if(list==null)
		{
			System.out.println("요청한 정보가 없습니다.");
		}
		else
		{
			System.out.println("= = = = = = 전체 회원 조회 = = = = = =");
			System.out.println("아이디  이름  비밀번호 성별  나이 이메일  전화번호  주소  취미  가입일");
			for(Member m : list)
			{
				System.out.println(m);
			}
		}
	}

	public void selectOneId()	// 회원 아이디로 한명 검색
	{
		System.out.print("조회할 회원 아이디 입력 : ");
		String memberId = sc.next();
		Member m = new MemberController().selectOneId(memberId);
		if(m==null)
		{
			System.out.println(memberId+"조회 실패!");
		}
		else
		{
			System.out.println("아이디 : " + m.getMemberId());
			System.out.println("비밀번호 : " + m.getMemberPwd());
			System.out.println("이름 : " + m.getMemberName());
			System.out.println("나이 : " + m.getAge());
			System.out.print("성별 : ");
			if(m.getGender().equals("M"))System.out.println("남");
			else System.out.println("여");
			System.out.println("이메일 : " + m.getEmail());
			System.out.println("휴대폰 : " + m.getPhone());
			System.out.println("주소 : " + m.getAddress());
			System.out.println("취미 : " + m.getHobby());
			System.out.println("가입일 : " + m.getEnrollDate());

		}
	}

	public void selectName()	// 회원 이름으로 검색(동일한 회원은 모두 검색)
	{
		System.out.print("조회할 회원 이름 검색 : ");
		String memberName = sc.next();
		ArrayList<Member> list = new MemberController().selectName(memberName);

		if(list==null)
		{
			System.out.println(memberName+"회원이 없습니다.");
		}
		else
		{
			System.out.println(memberName + "회원 조회");
			System.out.println("아이디  이름  비밀번호 성별  나이 이메일  전화번호  주소  취미  가입일");
			for(Member m : list)
				System.out.println(m);
		}
	}

	public void insertMember()	// 회원 가입
	{
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

	public void updateMember()	// 정보 수정
	{
		Member m = null;
		System.out.print("조회할 아이디 입력 : ");
		String id = sc.next();


		m = new MemberController().selectOneId(id);

		if(m==null)
		{
			System.out.println("검색된 회원이 없습니다.");
		}else
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
			if(new MemberController().updateMember(m))
			{
				System.out.println("회원정보가 수정되었습니다.");
			}
			else
			{
				System.out.println("회원정보가 실패하였습니다.");
			}
		}
	}



	public void deleteMember()	// 회원 탈퇴
	{
		Member m = null;
		System.out.print("회원 탈퇴할 아이디를 입력하세요 : ");
		String id = sc.next();
		m = new MemberController().selectOneId(id);

		if(m==null)
		{
			System.out.println("회원이 존재하지 않습니다.");
		}else
		{
			System.out.print("정말로 탈퇴하시겠습니까?(y,n)");
			if(sc.next().toUpperCase().charAt(0)=='Y')
			{
				m.setMemberId(id);
				System.out.print("비밀번호를 입력해 주세요 : ");
				m.setMemberPwd(sc.next());
				if(new MemberController().deleteMember(m))
				{
					System.out.println(id+"회원이 삭제되었습니다.");
				}
				else
				{
					System.out.println("회원 삭제를 처리하지 못 했습니다.");
				}
			}else
			{
				System.out.println("탈퇴를 취소합니다.");
			}
		}
	}

}
