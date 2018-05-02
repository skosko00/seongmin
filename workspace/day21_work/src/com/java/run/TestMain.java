package com.java.run;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestMain {
	private static Properties prop = new Properties();
	public static void main(String[] args) {
		try {
			prop.load(new FileReader("resource/test.Properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(prop.getProperty("OS"));
		System.out.println(prop.getProperty("User"));
		System.out.println(prop.getProperty("Password"));
	}
	

}
