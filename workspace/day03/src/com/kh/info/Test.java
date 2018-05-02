package com.kh.info;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int a = 40, b= 20;
//		a+=b;
//		System.out.printf("a : %d, b : %d \n",a,b);
//		a-=b;
//		System.out.printf("a : %d, b : %d \n",a,b);
//		b*=a;
//		System.out.printf("a : %d, b : %d \n",a,b);
//		b/=a;
//		System.out.printf("a : %d, b : %d \n",a,b);
//		
		   int a = 10, b = 20, c = 30, d = 40;
		   boolean result1, result2;
		   result1 = ((a<20 && b>10) && (c==20||d==40));
		   result2 = ((a==10 && b!=2*10) || (c==30&&d!=40));
		   System.out.printf("첫번째 결과값 : %b \n", result1);
		   System.out.printf("두번째 결과값 : %b \n", result2);
	}

}
