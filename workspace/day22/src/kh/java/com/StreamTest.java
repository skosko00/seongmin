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
		System.out.println("1. 학생 정보 입력 ");
		System.out.println("2. 학생 정보 출력 ");
		System.out.println("3. 저장 ");
		System.out.println("4. 불러오기 ");
		System.out.println("0. 종료");
		System.out.print("선택 : ");
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
		try(ObjectInputStream oIs = new ObjectInputStream(new FileInputStream("object.txt")))	//객체(Object) 타입의 아웃풋 해 줄 수 있는 ObjectInputStream 보조 스트림
		{
			try {
				al = (ArrayList<Student>) oIs.readObject();
				System.out.println("로드 완료");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	private void save() {

		try(ObjectOutputStream oOs = new ObjectOutputStream(new FileOutputStream("object.txt")))	//객체(Object) 타입의 아웃풋 해 줄 수 있는 ObjectOutputStream 보조 스트림 
		{
			
			oOs.writeObject(al);
			
			System.out.println("저장 완료");
		}catch (IOException e) {
			e.printStackTrace();
		}		
	}
	private void ouput() {
		System.out.printf("%s \t %s \t %s \t\n","이름","나이","주소");

		for(Student i : al)
		{
			System.out.println(i);
		}
		
	}
	private void input() {
		s = new Student();
		System.out.print("이름 입력 : ");
		s.setName(sc.next());
		System.out.print("나이 입력 : ");
		s.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("주소 입력 : ");
		s.setAddr(sc.nextLine());
		
		al.add(s);
		
	}
}
