package kh.java.com;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Calender2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Calendar dDay = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		System.out.println("## �Է� �� ��� ##\n");
		System.out.print("D-Day [�⵵]�Է� : ");
		dDay.set(Calendar.YEAR, sc.nextInt());
		System.out.print("D-day [��]�Է� : ");
		dDay.set(Calendar.MONTH, sc.nextInt()-1);
		System.out.print("D-day [��]�Է� : ");
		dDay.set(Calendar.DATE, sc.nextInt());

		dDay.set(Calendar.HOUR_OF_DAY,0);
		dDay.set(Calendar.MINUTE, 0);
		dDay.set(Calendar.SECOND, 0);
		dDay.set(Calendar.MILLISECOND, 0);
		today.set(Calendar.HOUR_OF_DAY,0);
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		System.out.println("���� ��¥ : " + today.get(Calendar.YEAR)+"�� "+(today.get(Calendar.MONTH)+1)+"�� " + today.get(Calendar.DATE)+"��");
		System.out.printf("D-Day ��¥ : %d�� %d�� %d��\n",dDay.get(Calendar.YEAR),(dDay.get(Calendar.MONTH))+1,dDay.get(Calendar.DATE));
		long d_Day = ((dDay.getTimeInMillis()/1000)-(today.getTimeInMillis()/1000))/60/60/24;
		
		
		if(d_Day==0)
		{
			System.out.printf("D-Day �Դϴ�.");
		}
		else if(0<d_Day)
		{
			System.out.printf("%s�� ���ҽ��ϴ�.",d_Day);
		}
		else
		{
			System.out.printf("%s�� �������ϴ�.",Math.abs(d_Day));
		}
		
	}

}
