package kh.java.test;

public class Quiz08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] array = {{12, 41, 36, 56},
				{82, 10, 12, 61},
				{14, 16, 18, 78},
				{45, 26, 72, 23}}; 
		int sum = 0;
		
		for(int i=0;i<array.length;i++)
		{
			for(int j=0; j<array.length;j++)
			{
				sum += array[i][j];
			}
		}
		
		System.out.println("ÇÕ°è : " + sum);
		System.out.println("Æò±Õ : " + ((double)sum/(array.length*array[0].length)));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
