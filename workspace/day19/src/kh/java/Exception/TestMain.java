package kh.java.Exception;

import java.io.FileNotFoundException;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExceptionTest e1 = new ExceptionTest();
		
		try {
				e1.sum(00,200);
		}catch (NoZeroException e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
