package kh.java.com.controller;

import kh.java.com.model.vo.Grade;

public class Pntmgr {
	
	private Grade [] g = new Grade[10];
	private int index;
	
	public void insertData(Grade g)
	{
		this.g[index++] = g;
	}

	
	public void printData()
	{
		System.out.println("�̸� \t��� \t����Ʈ \t��������Ʈ");
		for(int i=0; i<index; i++)
		{
			System.out.printf("%s \t%s \t%d \t%.2f\n",g[i].getName(), g[i].getGrade(),g[i].getPoint(),g[i].getInterest());
		}
	}

}
