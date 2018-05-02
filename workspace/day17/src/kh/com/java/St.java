package kh.com.java;

import java.util.StringTokenizer;

public class St {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "홍길동/20/경기도 부천";
		StringTokenizer sT = new StringTokenizer(str,"/");
		String [] str2 = new String[3];
		for(int i=0; i<str2.length;i++)
		{
			str2[i] = sT.nextToken();
		}
		
		System.out.println(str2[1]);

//		System.out.println("토큰의 개수 : " + sT.countTokens());
//		System.out.println("첫번째 토큰 : " + sT.nextToken());
//		System.out.println("토큰 존재 여부 : " + sT.hasMoreTokens());
//		System.out.println();
//		
//		System.out.println("토큰의 개수 : " + sT.countTokens());
//		System.out.println("첫번째 토큰 : " + sT.nextToken());
//		System.out.println("토큰 존재 여부 : " + sT.hasMoreTokens());
//		System.out.println();
//		
//		System.out.println("토큰의 개수 : " + sT.countTokens());
//		System.out.println("첫번째 토큰 : " + sT.nextToken());
//		System.out.println("토큰 존재 여부 : " + sT.hasMoreTokens());
//		System.out.println();
	}

}
