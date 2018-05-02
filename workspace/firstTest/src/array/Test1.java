package array;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		int [][] array = {{12, 41, 36, 56},
				{82, 10, 12, 61},
				{14, 16, 18, 78},
				{45, 26, 72, 23}}; 

		double total = 0;

		int index = 0;

		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array[i].length;j++)
			{
				total += array[i][j];
				index++;
			}
		}
		double avg = total/index;
		System.out.println("ÇÕ°è:"+total);
		System.out.println("Æò±Õ:"+avg);

	}
}
