package kh.java.point.controller;

import java.util.Scanner;

import kh.java.point.model.vo.Gold;
import kh.java.point.model.vo.Grade;
import kh.java.point.model.vo.Silver;
import kh.java.point.model.vo.Vip;

public class PntMgr implements PntMgrInterface{

	Scanner sc = new Scanner(System.in);

	Grade [] g = new Grade[20];
	int index=0, r_index;
	String name;
	String grade;


	@Override
	public void insertData() {
		System.out.println("======= 회원 추가 서비스 ======\n");
		System.out.print("등급 입력<Silver/Gold/Vip> : ");
		grade = sc.next();
		switch(grade)
		{
		case "Silver":
			g[index] = new Silver();
			break;
		case "Gold":
			g[index] = new Gold();
			break;
		case "Vip":
			g[index] = new Vip();
			break;
		default :
			System.out.println("잘못 입력하셨습니다. 회원추가를 종료합니다");
			return;
		}
		g[index].setGrade(grade);

		System.out.print("이름 입력 : ");
		g[index].setName(sc.next());

		System.out.print("포인트 입력 : ");
		g[index++].setPoint(sc.nextInt());
		sc.nextLine();

	}

	@Override
	public void start() {
		while(true)
		{
			System.out.println("========== 회원 관리 시스템 ==========\n");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 출력");
			System.out.println("3. 회원 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택 : ");
			switch(sc.nextInt())
			{
			case 1:
				insertData();
				break;
			case 2:
				printData();
				break;
			case 3:
				modifyData();
				break;
			case 4:
				deleteData();
				break;
			case 0:
				stop();
				break;
			}
		}
	}

	@Override
	public int searchData() {

		for(int i=0; i<index; i++)
		{
			if(g[i].getName().equals(name))
			{
				r_index = i;
				break;
			}
			else
			{
				r_index = index+1;
			}
		}		
		
		return r_index;
	}

	@Override
	public void modifyData() {
		
		System.out.print("검색될 회원 이름 입력 : ");
		name = sc.next();
		searchData();
		if(0<=r_index && r_index<index)
		{
			System.out.print("수정될 등급 입력<Silver/Gold/Vip");
			grade = sc.next();
			switch(grade)
			{
			case "Silver":
				g[r_index] = new Silver();
				break;
			case "Gold":
				g[r_index] = new Gold();
				break;
			case "Vip":
				g[r_index] = new Vip();
				break;
			default :
				System.out.println("잘못 입력하셨습니다. 회원수정을 종료합니다");
				return;
			}
			
			g[r_index].setGrade(grade);

			System.out.print("수정 될 이름 입력 : ");
			g[r_index].setName(sc.next());

			System.out.print("수정 될 포인트 입력 : ");
			g[r_index].setPoint(sc.nextInt());
			sc.nextLine();			
		}
		else
		{
			System.out.println("검색된 회원이 없습니다.");
		}
		

	}

	@Override
	public void deleteData() {
		System.out.print("검색될 회원 이름 입력 : ");
		name = sc.next();
		searchData();
		
		if(0<=r_index && r_index<index)
		{
			for(;r_index<index-1;r_index++)
			{
				g[r_index] = g[r_index+1];
			}
			g[r_index+1]=null;
			index--;
			System.out.println("회원 정보가 삭제되었습니다.");
		}
		
		else
		{
			System.out.println("검색된 회원이 없습니다.");
		}

	}

	@Override
	public void printData() {
		System.out.println("========== information ==========");
		System.out.printf("%s \t%s \t%s \t%s \n","이름","등급","포인트","이자포인트");
		for(int i=0;i<index;i++)
		{
			System.out.printf("%s \t%s \t%d \t%.1f \n",g[i].getName(), g[i].getGrade(), g[i].getPoint(), g[i].getInterest());
		}

	}

	public void stop()
	{
		System.err.println("프로그램을 종료합니다.");
		System.exit(0);
	}

}
