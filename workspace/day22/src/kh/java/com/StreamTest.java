package kh.java.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StreamTest {
	private Student s;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Student> al = new ArrayList<>();
	public StreamTest() {}
	public void start()
	{
		while(true)
		{
		System.out.println("1. �л� ���� �Է� ");
		System.out.println("2. �л� ���� ��� ");
		System.out.println("3. ���� ");
		System.out.println("4. �ҷ����� ");
		System.out.println("0. ����");
		System.out.print("���� : ");
		switch(sc.nextInt())
		{
		case 1: input();break;
		case 2: ouput();break;
		case 3: save();break;
		case 4: load();break;
		case 0:System.exit(0);
		}
		}
	}
	private void load() {
		try(ObjectInputStream oIs = new ObjectInputStream(new FileInputStream("object.txt")))	//��ü(Object) Ÿ���� �ƿ�ǲ �� �� �� �ִ� ObjectInputStream ���� ��Ʈ��
		{
			try {
				al = (ArrayList<Student>) oIs.readObject();
				System.out.println("�ε� �Ϸ�");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	private void save() {

		try(ObjectOutputStream oOs = new ObjectOutputStream(new FileOutputStream("object.txt")))	//��ü(Object) Ÿ���� �ƿ�ǲ �� �� �� �ִ� ObjectOutputStream ���� ��Ʈ�� 
		{
			
			oOs.writeObject(al);
			
			System.out.println("���� �Ϸ�");
		}catch (IOException e) {
			e.printStackTrace();
		}		
	}
	private void ouput() {
		System.out.printf("%s \t %s \t %s \t\n","�̸�","����","�ּ�");

		for(Student i : al)
		{
			System.out.println(i);
		}
		
	}
	private void input() {
		s = new Student();
		System.out.print("�̸� �Է� : ");
		s.setName(sc.next());
		System.out.print("���� �Է� : ");
		s.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("�ּ� �Է� : ");
		s.setAddr(sc.nextLine());
		
		al.add(s);
		
	}
}
