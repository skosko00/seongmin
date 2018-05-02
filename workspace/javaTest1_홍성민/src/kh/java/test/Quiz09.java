package kh.java.test;

public class Quiz09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] array = {10, 82, 12, 61, 39, 22, 44, 55, 11}; 
		int min=array[0], max=array[0];
		for (int i=0;i<array.length;i++)
		{
			if(max<array[i])
			{
				max=array[i];
			}
			if(min>array[i])
			{
				min=array[i];
			}			
		}
		System.out.println("가장 큰 값 : "+max);
		System.out.println("가장 작은 값 : "+min);
	}
}
