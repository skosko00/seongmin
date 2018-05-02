package kh.java.test;

public class Test1 {
	public void testMethod()
	{
		System.out.println("안녕하세요 테스트 메소드 입니다.");
	}
	public void testMethod(int a)
	{
		System.out.println("호출 값은 "+ a + "입니다.");
	}
	public void testMethod(int a, int b)
	{
		System.out.println("2개의 값은 "+a+"과"+b+"이며 합한 값은 "+(a+b)+"입니다.");
	}
}
