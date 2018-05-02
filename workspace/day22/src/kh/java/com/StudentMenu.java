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
			System.out.println("1.�����Է�");
			System.out.println("2.�������");
			System.out.println("3.��������(save)");
			System.out.println("4.�����ҷ�����(load)");
			System.out.println("0.����");
			System.out.print("���� : ");
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
				System.out.println("�߸������ϼ̽��ϴ�.");
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
				System.out.println("�ε� �Ǿ����ϴ� ��������� Ȯ���غ�����");
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
			System.out.println("���� ������ �����ϴ�.");			
		}
		else
		{
			System.out.println("�̸� : "+name);
			System.out.println("���� : "+age);
			System.out.println("�ּ� : "+addr);
		}		
	}

	private void save() {
		FileWriter fw = null;
		try {
			fw = new FileWriter("student.txt");
			fw.write(name+"/"+age+"/"+addr);
			System.out.println("���� �Ϸ� �Ǿ����ϴ�.");
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
		System.out.print("�̸��� �Է��ϼ��� : ");
		name = sc.next();
		System.out.print("���̸� �Է��ϼ��� : ");
		age = sc.nextInt();
		sc.nextLine();
		System.out.print("�ּҸ� �Է��ϼ��� : ");
		addr = sc.nextLine();		
	}
}
