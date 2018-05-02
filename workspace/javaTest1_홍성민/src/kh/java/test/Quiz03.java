package kh.java.test;

public class Quiz03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0, i=0;
		
		while(i<100)
		{
			++i;
			sum += i;
		}
		System.out.printf("ÇÕ°è : %f \n",(double)sum);
		System.out.printf("Æò±Õ : %f",(double)sum/i);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
