package kh.java.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class TestMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList a = new ArrayList<>();
		a.add(100);
		a.add(58);
		a.add(25);
		a.add(79);
		a.add(87);
		a.add(10);
		a.add(53);
		a.add(76);
		a.add(24);
		a.add(97);
		a.add(34);
		a.add(77);
		a.add(5);
		
		Collections.sort(a);
		
		for(Object i : a)
		{
			System.out.print(i + " ");
		}
		}

}
