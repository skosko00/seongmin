package day18_work;

import java.util.Calendar;

public class Wrok1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int day = today.get(Calendar.DATE);
		int hour = today.get(Calendar.HOUR);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		
		String str = year + "년 " + month + "월 " + day +"일 " + hour + "시 " + minute +"분 " + second + "초";
		System.out.println(str);
		
	}

}
