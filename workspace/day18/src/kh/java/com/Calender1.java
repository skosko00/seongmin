package kh.java.com;

import java.util.Calendar;

public class Calender1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar today = Calendar.getInstance();
		char ch=0;
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int day = today.get(Calendar.DATE);
		int hour = today.get(Calendar.HOUR);
		int minute = today.get(Calendar.MINUTE);
		int second = today.get(Calendar.SECOND);
		switch(today.get(Calendar.DAY_OF_WEEK))
		{
		case 1: ch = '일';	break;
		case 2: ch = '월';	break;
		case 3: ch = '화';	break;
		case 4: ch = '수';	break;
		case 5: ch = '목';	break;
		case 6: ch = '금';	break;
		case 7: ch = '토';	break;
		}
		String str1 = year + "년 " + month +"월 " + day + "일 " + ch + "요일 " + hour + "시 " + minute + "분 " + second + "초";
		StringBuffer str2 = new StringBuffer();
		str2.append(year+"년");
		str2.append(" "+month+"월");
		str2.append(" "+day+"일");
		str2.append(" "+ch+"요일");
		str2.append(" "+hour+"시");
		str2.append(" "+minute+"분");
		str2.append(" "+second+"초");
		
		System.out.println(str1);
		
		System.out.println(str2);
		
		System.out.printf("%d년 %d월 %d일 %c요일 %d시 %d분 %d초",year,month,day,ch,hour,minute,second);
		
	}

}
