package kh.com.java;

import java.util.StringTokenizer;

public class St {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ȫ�浿/20/��⵵ ��õ";
		StringTokenizer sT = new StringTokenizer(str,"/");
		String [] str2 = new String[3];
		for(int i=0; i<str2.length;i++)
		{
			str2[i] = sT.nextToken();
		}
		
		System.out.println(str2[1]);

//		System.out.println("��ū�� ���� : " + sT.countTokens());
//		System.out.println("ù��° ��ū : " + sT.nextToken());
//		System.out.println("��ū ���� ���� : " + sT.hasMoreTokens());
//		System.out.println();
//		
//		System.out.println("��ū�� ���� : " + sT.countTokens());
//		System.out.println("ù��° ��ū : " + sT.nextToken());
//		System.out.println("��ū ���� ���� : " + sT.hasMoreTokens());
//		System.out.println();
//		
//		System.out.println("��ū�� ���� : " + sT.countTokens());
//		System.out.println("ù��° ��ū : " + sT.nextToken());
//		System.out.println("��ū ���� ���� : " + sT.hasMoreTokens());
//		System.out.println();
	}

}
