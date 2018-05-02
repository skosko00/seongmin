package kh.java.pay.controller;

import kh.java.pay.model.vo.Pay;

public class PayMgr {
	private Pay [] p = new Pay[10];
	private int index;
	
	public void insertData(Pay p)
	{
		this.p[index++] = p;
	}
	
	public void showData()
	{
		System.out.println("= = = = = 직원 급여 출력 = = = = =");
		System.out.printf("%s \t%s \t%s\n", "이름", "분류", "급여");
		for(int i=0; i<index; i++)
		{
			System.out.printf("%s \t%s \t%d\n",p[i].getName(),p[i].getDivision(),p[i].getPay());
		}
	}

}
