package kh.java.test;

public class Quiz04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		switch(args[1].charAt(0))
		{
		case '+' :
			System.out.println("�� : " + (Integer.parseInt(args[0])+Integer.parseInt(args[2])));
			break;
		case '-' :
			System.out.println("�� : " + (Integer.parseInt(args[0])-Integer.parseInt(args[2])));
			break;
		case 'x' :
			System.out.println("�� : " + (Integer.parseInt(args[0])*Integer.parseInt(args[2])));
			break;
		case '/' :
			System.out.println("������ : " + (Double.parseDouble(args[0])/Integer.parseInt(args[2])));
			break;
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
