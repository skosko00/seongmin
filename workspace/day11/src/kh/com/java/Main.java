package kh.com.java;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<Integer.parseInt(args[0]);i++)
		{
			try {
				Thread.sleep(Integer.parseInt(args[1])*1000);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello"+"("+Integer.parseInt(args[1])+"ÃÊµÚ)");			
		}
	}

}
