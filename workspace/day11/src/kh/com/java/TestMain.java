package kh.com.java;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args[1].charAt(0)=='+')
		{
			System.out.println("Result : "+((Integer.parseInt(args[0]))+(Integer.parseInt(args[2]))));
		}
		else if(args[1].charAt(0)=='-')
		{
			System.out.println("Result : "+((Integer.parseInt(args[0]))-(Integer.parseInt(args[2]))));
		}
		else if(args[1].charAt(0)=='*')
		{
			System.out.println("Result : "+((Integer.parseInt(args[0]))*(Integer.parseInt(args[2]))));
		}
		else if(args[1].charAt(0)=='/')
		{
			System.out.println("Result : "+((Double.parseDouble(args[0]))/(Integer.parseInt(args[2]))));
		}
		
		
	}

}
