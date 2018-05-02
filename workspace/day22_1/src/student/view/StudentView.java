package student.view;

import java.util.ArrayList;
import java.util.Scanner;

import student.controller.StudentController;
import student.vo.Student;

public class StudentView {

	private Scanner sc = new Scanner(System.in);
	private StudentController stuCtl = new StudentController();

	public void mainMenu()	//�޴�
	{
		while(true)	{
			System.out.println("======= �л� ���� ���α׷� ver 1.0 =======");
			System.out.println("1. �л� ��ü ���� ���");
			System.out.println("2. �л� ���� ��ȸ(�й�)");
			System.out.println("3. �л� ���� �Է�");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ����");
			System.out.println("6. ����(Save)");
			System.out.println("7. �ҷ�����(Load");
			System.out.println("0. ���α׷� ����");
			System.out.print("���� : ");
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
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);

			}
		}
	}

	private void load() {
		System.out.println("������ �ҷ����ðڽ��ϱ�?");
		System.out.print("(1.yes/2.no)");
		switch(sc.nextInt())
		{
		case 1:
			if(stuCtl.load())
			{
				System.out.println("������ �ҷ��Խ��ϴ�.");
			}else
			{
				System.out.println("���� �ҷ����⿡ �����Ͽ����ϴ�.");
			}
			break;
		case 2:
			System.out.println("������ �ҷ����� �ʽ��ϴ�.");
			break;
		}

	}

	private void save() {
		System.out.println("���� ����(save) �Ͻðھ��ϱ�?");
		System.out.print("���� ������ ���� �˴ϴ�.(1.yes/2.no) : ");
		switch(sc.nextInt())
		{
		case 1:
			if(stuCtl.save())
			{
				System.out.println("���� �Ǿ����ϴ�.");
			}
			else
			{
				System.out.println("���忡 �����Ͽ����ϴ�.");
			}
			break;
		case 2:
			System.out.println("�������� �ʽ��ϴ�.");
			break;
		}
	}

	private void deleteStudent() {	//�л� ���� ����
		System.out.print("���� �� �й� �Է� : ");
		int number = sc.nextInt();
		int index = stuCtl.searchStuent(number);

		if(index>=0)
		{
			stuCtl.deleteStudent(index);
			System.out.println("�ش� �л� ������ �����Ͽ����ϴ�.");
		}
		else
		{
			System.out.println("�ش� �л��� ã�� ���Ͽ����ϴ�.");
		}
	}

	private void updateStudent() {	//�л� ���� ����
		System.out.println("- - - - - �л� ���� ���� - - - - -");
		Student s = new Student();
		System.out.print("���� �� �й� �Է� : ");
		int number = sc.nextInt();
		int index = stuCtl.searchStuent(number);

		if(index>=0)
		{
			System.out.print("���� �� �й� �Է� : ");
			s.setClassNumber(sc.nextInt());
			System.out.print("���� �� �̸� �Է� : ");
			s.setName(sc.next());
			System.out.print("���� �� ���� �Է� : ");
			s.setAge(sc.nextInt());
			sc.nextLine();		// ���� �����
			System.out.print("���� �� �ּ� �Է� : ");
			s.setAddr(sc.nextLine());
			System.out.print("���� �� ���� �Է� : ");
			s.setGrade(sc.nextDouble());

			stuCtl.updateStudent(s, index);
		}
		else
		{
			System.out.println("�ش� �л��� �˻����� ���Ͽ����ϴ�.");
		}
	}

	private void insertStudent() {	//�л� ���� �Է�
		Student s = new Student();
		System.out.println("- - - - - �Է� �� �л� ������ �ۼ��ϼ��� - - - - -");

		System.out.print("�й� �Է� : ");
		s.setClassNumber(sc.nextInt());
		System.out.print("�̸� �Է� : ");
		s.setName(sc.next());
		System.out.print("���� �Է� : ");
		s.setAge(sc.nextInt());
		sc.nextLine();		// ���� �����
		System.out.print("�ּ� �Է� : ");
		s.setAddr(sc.nextLine());
		System.out.print("���� �Է� : ");
		s.setGrade(sc.nextDouble());
		if(stuCtl.insertStudent(s))
		{
			System.out.println("�л� ������ ���������� �ԷµǾ����ϴ�.");
		}
		else
		{
			System.out.println("�л� ���� �Է��� ���� �Ͽ����ϴ�.");
		}

	}

	private void selectOne() {		//�л� �� �� ���� ���
		System.out.println("- - - - -�л� ���� ��� - - - - -");
		System.out.print("��ȸ �� �й��� �Է��ϼ��� : ");
		int num = sc.nextInt();
		int index = stuCtl.searchStuent(num);
		if(index>=0)
		{
			Student s = stuCtl.selectOne(index);
			System.out.println("\n\n===== �л� 1�� ���� ��� ======");
			System.out.println("�й� \t\t �̸� \t\t ���� \t\t �ּ� \t\t ����");
			System.out.println(s);
		}
		else
		{
			System.out.println("�ش� �л��� ��ȸ���� ���Ͽ����ϴ�.");
		}
	}

	private void selectAll() {

		ArrayList<Student> s = stuCtl.selectAll();
		System.out.println("\n\n========== �л� ���� ��ü ��� ========");
		System.out.println("�й� \t\t �̸� \t\t ���� \t\t �ּ� \t\t ����");
		for(Student i : s)
		{
			System.out.println(i);
		}

	}
}
