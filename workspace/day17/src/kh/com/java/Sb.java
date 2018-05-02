package kh.com.java;

public class Sb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("Hello World");
		System.out.println("실제 String Buffer의 길이 : " + str.capacity());
		System.out.println("저장된 문자열의 길이 : " + str.length());
		str.reverse();	//문자열 거꾸로 배치
		System.out.println(str);
		str.reverse();	//문자열 거꾸로 배치(2번하면 원상복귀)
		System.out.println(str);
		
		str.insert(5,  " Java");
		System.out.println(str);
		
		str.delete(4,  5);
		System.out.println(str);
		
		str.replace(9, 14, " coffee");
		System.out.println(str);
	}

}
