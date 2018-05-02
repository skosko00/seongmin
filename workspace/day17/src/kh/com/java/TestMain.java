package kh.com.java;

import java.util.StringTokenizer;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "J a v a P r o g r a m";
		StringBuffer str2 = new StringBuffer();
		String str3 = "";
		StringTokenizer sT = new StringTokenizer(str, " ");
		char [] a = new char [sT.countTokens()];
		
//		for(int i=0; i<a.length;i++)
//		{
//			if('a' <= a[i] && a[i] <= 'z')
//			{
//				a[i] -= 32;
//			}
//		}
		for(int i=0; i<a.length;i++)
		{
			a[i] = (sT.nextToken().toUpperCase().charAt(0));
			str2.append(a[i]);
			str3 += a[i];
		}
		System.out.println(str2);
		System.out.println(str3);		
		
	}

}
