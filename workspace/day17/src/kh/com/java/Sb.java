package kh.com.java;

public class Sb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer str = new StringBuffer("Hello World");
		System.out.println("���� String Buffer�� ���� : " + str.capacity());
		System.out.println("����� ���ڿ��� ���� : " + str.length());
		str.reverse();	//���ڿ� �Ųٷ� ��ġ
		System.out.println(str);
		str.reverse();	//���ڿ� �Ųٷ� ��ġ(2���ϸ� ���󺹱�)
		System.out.println(str);
		
		str.insert(5,  " Java");
		System.out.println(str);
		
		str.delete(4,  5);
		System.out.println(str);
		
		str.replace(9, 14, " coffee");
		System.out.println(str);
	}

}
