package kh.java.com;

import java.util.ArrayList;
import java.util.Collections;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Member> a = new ArrayList<Member>();
		a.add(new Member(180510,"ȫ�浿",20,"��⵵"));
		a.add(new Member(981405,"�踻��",30,"�����"));
		a.add(new Member(120761,"��浿",40,"��õ��"));
		
		a.add(new Member(141314,"������", 21, "���ﵿ"));
		
		Collections.sort(a);
		
		for(Member i : a)
		{
			System.out.println(i);
		}


	}

}
