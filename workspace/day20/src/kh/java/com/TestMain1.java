package kh.java.com;

import java.util.ArrayList;
import java.util.Collections;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Member> a = new ArrayList<Member>();
		a.add(new Member(180510,"È«±æµ¿",20,"°æ±âµµ"));
		a.add(new Member(981405,"±è¸»¶Ë",30,"¼­¿ï½Ã"));
		a.add(new Member(120761,"°í±æµ¿",40,"ÀÎÃµ½Ã"));
		
		a.add(new Member(141314,"±èÁö¶Ë", 21, "¿ª»ïµ¿"));
		
		Collections.sort(a);
		
		for(Member i : a)
		{
			System.out.println(i);
		}


	}

}
