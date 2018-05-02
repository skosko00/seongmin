package kh.java.point.controller;

import kh.java.point.model.vo.Grade;

public class PntMgr {
	
	private Grade [] g = new Grade[30];
	private int index;
	
	public void insertData(Grade g)
	{
		this.g[index++] = g;
	}
	
	public void printData()
	{
		System.out.println("======================information=======================");
		System.out.printf("%s \t%s \t%s \t%s\n","이름", "등급", "포인트", "이자포인트");
		for(int i=0; i<index; i++)
		{
			System.out.printf("%s \t%s \t%d \t%.1f\n",g[i].getName(),g[i].getGrade(),g[i].getPoint(),g[i].getInterest());
		}
	}

}
