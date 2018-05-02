package kh.java.com;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calender2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calendar today = Calendar.getInstance();
		Scanner sc = new Scanner(System.in);
		today.set(Calendar.HOUR,0);
		today.set(Calendar.MINUTE,0);
		today.set(Calendar.SECOND,0);
		today.set(Calendar.MILLISECOND,0);
		today.set(Calendar.AM_PM,0);
		
		System.out.println("---------- D-day 계산기 ----------");
		System.out.print("D-Day [년도] 입력 : ");
		int year = sc.nextInt();
		System.out.print("D-Day [월] 입력 : ");
		int month = sc.nextInt()-1;
		System.out.print("D-Day [일] 입력 : ");
		int day = sc.nextInt();
		Calendar dDay = new GregorianCalendar(year,month,day);
		
		System.out.println(today.getTimeInMillis());
		System.out.println(dDay.getTimeInMillis());
		
		long result = today.getTimeInMillis()/1000 - dDay.getTimeInMillis()/1000;
		//결과가 0이면 D-Day, 음수면 남았음, 양수면 지났음
		int date = (int) (result/(1*60*60*24));
		if(result>0) //지낫음 
		{
			System.out.println(date+ "일 지났습니다.");
		}
		else if(result>0)	//남았음
		{
			System.out.println(date+ "일 남았습니다.");
		}
		else 				// D-Day
		{
			System.out.println("D-day입니다");
		}
	}

}
