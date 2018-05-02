package kh.com.gif;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class GifStream {
	public void fileLoad()
	{		
		
			try(BufferedReader bfr = new BufferedReader(new FileReader("quiz.txt"))) {
//				System.out.println(bfr.readLine());
				StringTokenizer sT = new StringTokenizer(bfr.readLine(), " ");
				ArrayList<Byte> al = new ArrayList<>();
				
				while(sT.hasMoreTokens())
				{
				al.add((byte)Integer.parseInt(sT.nextToken(),16));
				}
				
				FileOutputStream fOut = new FileOutputStream("quiz.gif");
				for(byte i : al)
				{
				fOut.write(i);
				}				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
}
