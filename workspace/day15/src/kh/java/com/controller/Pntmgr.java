package kh.java.com.controller;

import kh.java.com.model.vo.Gold;
import kh.java.com.model.vo.Silver;
import kh.java.com.model.vo.Vip;
import kh.java.com.model.vo.Vvip;

public class Pntmgr {
	
	private Silver [] s = new Silver[10];
	private Gold [] g = new Gold[10];
	private Vip [] v = new Vip[10];
	private Vvip [] vv = new Vvip[10];
	private int s_index, g_index, v_index, vv_index;
	
	public void insertData(Silver s)
	{
		this.s[s_index++] = s;
	}
	public void insertData(Gold g)
	{
		this.g[g_index++] = g;
	}
	public void insertData(Vip v)
	{
		this.v[v_index++] = v;
	}
	public void insertData(Vvip vv)
	{
		this.vv[vv_index++] = vv;
	}
	
	public void printData()
	{
		System.out.println("이름 \t등급 \t포인트 \t이자포인트");
		for(int i=0; i<s_index; i++)
		{
			System.out.printf("%s \t%s \t%d \t%.2f\n",s[i].getName(), s[i].getGrade(),s[i].getPoint(),s[i].getIPoint());
		}
		for(int i=0; i<g_index; i++)
		{
			System.out.printf("%s \t%s \t%d \t%.2f\n",g[i].getName(), g[i].getGrade(),g[i].getPoint(),g[i].getIPoint());
		}
		for(int i=0; i<v_index; i++)
		{
			System.out.printf("%s \t%s \t%d \t%.2f\n",v[i].getName(), v[i].getGrade(),v[i].getPoint(),v[i].getIPoint());
		}
		for(int i=0; i<vv_index; i++)
		{
			System.out.printf("%s \t%s \t%d \t%.2f\n",vv[i].getName(), vv[i].getGrade(),vv[i].getPoint(),vv[i].getIPoint());
		}
	}

}
