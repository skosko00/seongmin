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
		case 1: ch = '��';	break;
		case 2: ch = '��';	break;
		case 3: ch = 'ȭ';	break;
		case 4: ch = '��';	break;
		case 5: ch = '��';	break;
		case 6: ch = '��';	break;
		case 7: ch = '��';	break;
		}
		String str1 = year + "�� " + month +"�� " + day + "�� " + ch + "���� " + hour + "�� " + minute + "�� " + second + "��";
		StringBuffer str2 = new StringBuffer();
		str2.append(year+"��");
		str2.append(" "+month+"��");
		str2.append(" "+day+"��");
		str2.append(" "+ch+"����");
		str2.append(" "+hour+"��");
		str2.append(" "+minute+"��");
		str2.append(" "+second+"��");
		
		System.out.println(str1);
		
		System.out.println(str2);
		
		System.out.printf("%d�� %d�� %d�� %c���� %d�� %d�� %d��",year,month,day,ch,hour,minute,second);
		
	}

}
