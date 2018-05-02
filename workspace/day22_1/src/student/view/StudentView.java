package student.view;

import java.util.ArrayList;
import java.util.Scanner;

import student.controller.StudentController;
import student.vo.Student;

public class StudentView {

	private Scanner sc = new Scanner(System.in);
	private StudentController stuCtl = new StudentController();

	public void mainMenu()	//메뉴
	{
		while(true)	{
			System.out.println("======= 학생 관리 프로그램 ver 1.0 =======");
			System.out.println("1. 학생 전체 정보 출력");
			System.out.println("2. 학생 정보 조회(학번)");
			System.out.println("3. 학생 정보 입력");
			System.out.println("4. 학생 정보 변경");
			System.out.println("5. 학생 삭제");
			System.out.println("6. 저장(Save)");
			System.out.println("7. 불러오기(Load");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:selectAll();break;
			case 2:selectOne();break;
			case 3:insertStudent(); break;
			case 4:updateStudent(); break;
			case 5:deleteStudent(); break;
			case 6:save(); break;
			case 7:load(); break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			}
		}
	}

	private void load() {
		System.out.println("파일을 불러오시겠습니까?");
		System.out.print("(1.yes/2.no)");
		switch(sc.nextInt())
		{
		case 1:
			if(stuCtl.load())
			{
				System.out.println("파일을 불러왔습니다.");
			}else
			{
				System.out.println("파일 불러오기에 실패하였습니다.");
			}
			break;
		case 2:
			System.out.println("파일을 불러오지 않습니다.");
			break;
		}

	}

	private void save() {
		System.out.println("저장 저장(save) 하시겠씁니까?");
		System.out.print("기존 데이터 삭제 됩니다.(1.yes/2.no) : ");
		switch(sc.nextInt())
		{
		case 1:
			if(stuCtl.save())
			{
				System.out.println("저장 되었습니다.");
			}
			else
			{
				System.out.println("저장에 실패하였습니다.");
			}
			break;
		case 2:
			System.out.println("저장하지 않습니다.");
			break;
		}
	}

	private void deleteStudent() {	//학생 정보 삭제
		System.out.print("삭제 될 학번 입력 : ");
		int number = sc.nextInt();
		int index = stuCtl.searchStuent(number);

		if(index>=0)
		{
			stuCtl.deleteStudent(index);
			System.out.println("해당 학생 정보를 삭제하였습니다.");
		}
		else
		{
			System.out.println("해당 학생을 찾지 못하였습니다.");
		}
	}

	private void updateStudent() {	//학생 정보 변경
		System.out.println("- - - - - 학생 정보 변경 - - - - -");
		Student s = new Student();
		System.out.print("수정 될 학번 입력 : ");
		int number = sc.nextInt();
		int index = stuCtl.searchStuent(number);

		if(index>=0)
		{
			System.out.print("수정 될 학번 입력 : ");
			s.setClassNumber(sc.nextInt());
			System.out.print("수정 될 이름 입력 : ");
			s.setName(sc.next());
			System.out.print("수정 될 나이 입력 : ");
			s.setAge(sc.nextInt());
			sc.nextLine();		// 버퍼 비우기용
			System.out.print("수정 될 주소 입력 : ");
			s.setAddr(sc.nextLine());
			System.out.print("수정 될 학점 입력 : ");
			s.setGrade(sc.nextDouble());

			stuCtl.updateStudent(s, index);
		}
		else
		{
			System.out.println("해당 학생을 검색하지 못하였습니다.");
		}
	}

	private void insertStudent() {	//학생 정보 입력
		Student s = new Student();
		System.out.println("- - - - - 입력 될 학생 정보를 작성하세요 - - - - -");

		System.out.print("학번 입력 : ");
		s.setClassNumber(sc.nextInt());
		System.out.print("이름 입력 : ");
		s.setName(sc.next());
		System.out.print("나이 입력 : ");
		s.setAge(sc.nextInt());
		sc.nextLine();		// 버퍼 비우기용
		System.out.print("주소 입력 : ");
		s.setAddr(sc.nextLine());
		System.out.print("학점 입력 : ");
		s.setGrade(sc.nextDouble());
		if(stuCtl.insertStudent(s))
		{
			System.out.println("학생 정보가 정상적으로 입력되었습니다.");
		}
		else
		{
			System.out.println("학생 정보 입력이 실패 하였습니다.");
		}

	}

	private void selectOne() {		//학생 한 명 정보 출력
		System.out.println("- - - - -학생 정보 출력 - - - - -");
		System.out.print("조회 할 학번을 입력하세요 : ");
		int num = sc.nextInt();
		int index = stuCtl.searchStuent(num);
		if(index>=0)
		{
			Student s = stuCtl.selectOne(index);
			System.out.println("\n\n===== 학생 1명 정보 출력 ======");
			System.out.println("학번 \t\t 이름 \t\t 나이 \t\t 주소 \t\t 학점");
			System.out.println(s);
		}
		else
		{
			System.out.println("해당 학생을 조회하지 못하였습니다.");
		}
	}

	private void selectAll() {

		ArrayList<Student> s = stuCtl.selectAll();
		System.out.println("\n\n========== 학생 정보 전체 출력 ========");
		System.out.println("학번 \t\t 이름 \t\t 나이 \t\t 주소 \t\t 학점");
		for(Student i : s)
		{
			System.out.println(i);
		}

	}
}
