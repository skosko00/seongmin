package kh.java.com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentMenu {
	Scanner sc = new Scanner(System.in);
	private String name;
	private int age;
	private String addr;

	public void start()
	{
		while(true)
		{
			System.out.println("1.정보입력");
			System.out.println("2.정보출력");
			System.out.println("3.정보저장(save)");
			System.out.println("4.정보불러오기(load)");
			System.out.println("0.종료");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 0:
				System.exit(0);
			case 1:
				insert();
				break;
			case 2:
				print();
				break;
			case 3:
				save();
				break;
			case 4:
				load();
				break;
			default:
				System.out.println("잘못선택하셨습니다.");
			}
		}
	}

	private void load() {
		BufferedReader bfr;
		try {
			bfr = new BufferedReader(new FileReader("student.txt"));
			String str;
			try {
				str = bfr.readLine();
				StringTokenizer sT = new StringTokenizer(str,"/");
				name = sT.nextToken();
				age = Integer.parseInt(sT.nextToken());
				addr = sT.nextToken();
				System.out.println("로드 되었습니다 정보출력을 확인해보세요");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void print() {
		if(name==null)
		{
			System.out.println("현재 정보가 없습니다.");			
		}
		else
		{
			System.out.println("이름 : "+name);
			System.out.println("나이 : "+age);
			System.out.println("주소 : "+addr);
		}		
	}

	private void save() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("student.txt");
			fw.write(name+"/"+age+"/"+addr);
			System.out.println("저장 완료 되었습니다.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void insert() {
		System.out.print("이름을 입력하세요 : ");
		name = sc.next();
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("주소를 입력하세요 : ");
		addr = sc.nextLine();		
	}
}
