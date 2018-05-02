package kh.java.point.controller;

import kh.java.point.model.vo.Gold;
import kh.java.point.model.vo.Silver;
import kh.java.point.model.vo.Vip;

public class Pntmgr {
	
	private Silver [] s = new Silver[10];
	private Gold [] g = new Gold[10];
	private Vip [] v = new Vip[10];
	private int count1=0, count2=0, count3=0;
	
	public Pntmgr()
	{
		
	}

	public void inserData(Silver s)
	{
		this.s[count1++] = s;
	}
	
	public void inserData(Gold g)
	{
		this.g[count2++] = g;
	}
	
	public void inserData(Vip v)
	{
		this.v[count3++] = v;
	}
	
	public void printData()
	{
		System.out.println("<< ================information================ >>");
		System.out.printf("%s \t%s \t%s \t%s\n","이름","등급","포인트","이자포인트");
		for(int i=0; i<count1; i++)
		{
		System.out.printf("%s \t%s \t%d \t%.1f\n",s[i].getName(),s[i].getGrade(),s[i].getPoint(),s[i].getPoint2());
		}
		for(int i=0; i<count2; i++)
		{
		System.out.printf("%s \t%s \t%d \t%.1f\n",g[i].getName(),g[i].getGrade(),g[i].getPoint(),g[i].getPoint2());
		}
		for(int i=0; i<count3; i++)
		{
		System.out.printf("%s \t%s \t%d \t%.1f\n",v[i].getName(),v[i].getGrade(),v[i].getPoint(),v[i].getPoint2());
		}
	}
}
