package kh.java.member.view;


import java.util.Scanner;

import kh.java.com.Student;
import kh.java.member.controller.MemberController;
import kh.java.member.model.vo.Member;

public class MemberView {

	private Scanner sc = new Scanner(System.in);
	private MemberController mbCon = new MemberController(); 

	public void mainMenu()		// ���� �޴�
	{
		while(true)
		{
			System.out.println("---------- ȸ�� ���� ���α׷� ----------\n");
			System.out.println("1. ȸ�� ����");
			System.out.println("2. ȸ�� ���Կ��� Ȯ��");
			System.out.println("3. ȸ�� ���� ����(1��)");
			System.out.println("4. ȸ�� ���� �����ϱ�");
			System.out.println("5. ȸ�� ���� �ϱ�");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� : ");
			switch(sc.nextInt())
			{
			case 1:memberJoin();break;
			case 2:memberCheck();break;
			case 3:memberSelect();break;
			case 4:memberModify();break;
			case 5:memberDelete();break;
			case 0:System.exit(0);
			default:
				System.out.println("0~5���� �������ּ���.");
			}
		}
	}

	private void memberDelete() {
		System.out.println("======= ȸ�� ���� �ϱ� =======\n");
		System.out.print("������ ȸ�� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		if(mbCon.memberDelete(userId))
		{
			System.out.println(userId+"���� ���� �Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("���� �����Ͽ����ϴ�. ���̵� ��Ȯ�� �ٶ�");
		}
	}

	private void memberModify() {
		System.out.println("======= ȸ�� ���� ���� �ϱ� =======\n");
		Member m = new Member();
		System.out.print("�����Ͻ� ȸ���� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		m.setUserId(userId);
		sc.nextLine();
		System.out.print("��й�ȣ(new) : ");
		m.setUserPwd(sc.nextLine());
		System.out.print("�̸� (new) : ");
		m.setUserName(sc.next());
		System.out.print("����(new)  : ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("�� ��ȣ(new) : ");
		m.setPhoneNumber(sc.next());
		if(mbCon.memberModify(m))
		{
			System.out.println("ȸ�� ���� ������ �Ϸ�Ǿ����ϴ�.");
		}
		else
		{
			System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
		}
	}

	private void memberSelect() {
		System.out.println("======= ȸ�� ���� ���� =======\n");
		System.out.print("��ȸ�� ȸ�� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		Member s = mbCon.memberSelect(userId);
		if(s==null)
		{
			System.out.println("�ش� ȸ���� �������� �ʽ��ϴ�.");
		}
		else
		{
			System.out.println("��ȸ ����!");
			System.out.println("���̵� : "+s.getUserId());
			System.out.println("��й�ȣ : "+s.getUserPwd());
			System.out.println("�̸� : "+s.getUserName());
			System.out.println("���� : "+s.getAge());
			System.out.println("����ȣ : "+s.getPhoneNumber());

		}

	}

	private void memberCheck() {
		System.out.println("======= ȸ�� ���� ���� Ȯ�� =======\n");
		System.out.print("ȸ�� ���̵� �Է��ϼ��� : ");
		String userId = sc.next();
		System.out.println(mbCon.memberCheck(userId));
		if(mbCon.memberCheck(userId)==true)
		{
			System.out.println(userId+"ȸ���� ���� �����մϴ�. �ٸ� ���̵� ������ּ���");
		}
		else
		{
			System.out.println("ȸ���� �������� �ʽ��ϴ�.");
		}
	}

	private void memberJoin() {
		sc.nextLine();
		Member m = new Member();
		System.out.println("======= ȸ�� ���� �ϱ� =======");
		System.out.print("ȸ�� ���̵� �Է� : ");
		m.setUserId(sc.next());
		sc.nextLine();
		System.out.print("ȸ�� ��й�ȣ �Է� : ");
		m.setUserPwd(sc.nextLine());
		System.out.print("ȸ�� �̸� �Է� : ");
		m.setUserName(sc.next());
		System.out.print("ȸ�� ���� �Է� : ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("ȸ�� �� ��ȣ �Է� : ");
		m.setPhoneNumber(sc.next());
		if(mbCon.memberJoin(m)) {
			System.out.println("ȸ�������� �Ͽ����ϴ�.");
		}
		else
		{
			System.out.println("�̹� ���̵� �ߺ��˴ϴ�.");
		}



	}

}
