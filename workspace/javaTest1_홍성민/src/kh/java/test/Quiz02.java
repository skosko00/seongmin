package kh.java.test;

public class Quiz02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=2; i<=5;i++)
		{
			for(int j=1;j<=9;j++)
			{
				if(i*j%2==1)
				{
					System.out.printf("%d*%d=%d\n",i,j,i*j);
				}
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
