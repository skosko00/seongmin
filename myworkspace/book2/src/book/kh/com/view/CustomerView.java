package book.kh.com.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.kh.com.controller.CustomerController;
import book.kh.com.model.dao.CustomerDAO;
import book.kh.com.model.vo.Customer;

public class CustomerView {

	Scanner sc = new Scanner(System.in);
	CustomerController cc = new CustomerController();

	public CustomerView() {}

	public void menu()
	{

		while(true)
		{
			System.out.println("= = = = = 회원 관리 = = = = =");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 회원 이름으로 조회");
			System.out.println("3. 회원 아이디로 조회");
			System.out.println("4. 회원 가입");
			System.out.println("5. 회원 정보 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("7. 메인 메뉴로 이동");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:
				allCustomer();
				break;
			case 2:
				searchName();
				break;
			case 3:
				searchId();
				break;
			case 4:
				insertCustomer();
				break;
			case 5:
				updateCustomer();
				break;
			case 6:
				deleteCustomer();
				break;
			case 7:
				return;
			}
		}

	}

	private void deleteCustomer() {
		Customer c = null;

		System.out.println("= = = = = 회원 탈퇴 = = = = =");
		System.out.print("탍퇴할 ID 입력 : ");
		String id = sc.next();

		c = cc.searchId(id);

		if(c==null)
		{
			System.out.println("일치하는 ID가 없습니다.");
		}else
		{
			System.out.print("정말로 탈퇴하시겠습니까?(y,n)");
			if(sc.next().toUpperCase().charAt(0)=='Y')
			{
				System.out.println(cc.deleteCustomer(c));
			}
		}

	}

	private void updateCustomer() {
		Customer c = null;

		System.out.println("= = = = = 회원 정보 수정 = = = = =");
		System.out.print("정보를 변경할 ID 입력 : ");
		String id = sc.next();

		c = cc.searchId(id);

		if(c==null)
		{
			System.out.println("일치하는 ID가 없습니다.");
		}else
		{
			System.out.print("변경할 이름 입력 : ");
			c.setUserName(sc.next());
			sc.nextLine();
			System.out.print("변경할 주소 입력 : ");
			c.setAddr(sc.nextLine());
			System.out.println(cc.updateCustomer(c));
		}

	}

	private void insertCustomer() {
		Customer c = new Customer();
		System.out.println("= = = = = = 회원 추가 = = = = = =");
		System.out.print("회원 번호 입력 : ");
		c.setUserNo(sc.nextInt());
		System.out.print("회원 ID 입력 : ");
		c.setUserId(sc.next());
		System.out.print("회원 이름 입력 : ");
		c.setUserName(sc.next());
		System.out.print("회원 나이 입력 : ");
		c.setUserAge(sc.nextInt());
		sc.nextLine();
		System.out.print("회원 주소 입력 : ");
		c.setAddr(sc.nextLine());
		System.out.print("회원 성별 입력(남/여) : ");
		String gender = sc.next();
		if(gender.equals("남")) c.setGender("M");
		else if(gender.equals("여")) c.setGender("F");
		System.out.println(cc.insertCustomer(c));
	}

	private void searchId() {
		System.out.print("조회할 ID를 입력하세요 : ");
		String memberId = sc.next();

		Customer c = cc.searchId(memberId);

		if(c==null)
		{
			System.out.println("ID가 "+memberId+"인 회원이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = 회원 ID 조회 = = = = =");
			System.out.println(c);
		}

	}

	private void searchName() {
		System.out.print("조회할 이름을 입력하세요 : ");
		String name = sc.next();

		ArrayList<Customer> list = cc.searchName(name);
		if(list==null)
		{
			System.out.println("조회된 회원이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = 회원 이름 조회 = = = = =");
			System.out.println("회원번호    회원 아이디    회원 이름    회원 나이    회원 주소    회원성별    가입날짜");
			for(Customer c : list)
			{
				System.out.println(c);
			}
		}
	}

	private void allCustomer() {
		ArrayList<Customer> list = cc.allCustomer();
		if(list==null)
		{
			System.out.println("조회된 회원이 없습니다.");
		}
		else
		{
			System.out.println("= = = = = 전체 회원 조회 = = = = =");
			System.out.println("회원번호    회원 아이디    회원 이름    회원 나이    회원 주소    회원성별    가입날짜");
			for(Customer c : list)
			{
				System.out.println(c);
			}
		}
	}

}
