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
		
		System.out.println("---------- D-day ���� ----------");
		System.out.print("D-Day [�⵵] �Է� : ");
		int year = sc.nextInt();
		System.out.print("D-Day [��] �Է� : ");
		int month = sc.nextInt()-1;
		System.out.print("D-Day [��] �Է� : ");
		int day = sc.nextInt();
		Calendar dDay = new GregorianCalendar(year,month,day);
		
		System.out.println(today.getTimeInMillis());
		System.out.println(dDay.getTimeInMillis());
		
		long result = today.getTimeInMillis()/1000 - dDay.getTimeInMillis()/1000;
		//����� 0�̸� D-Day, ������ ������, ����� ������
		int date = (int) (result/(1*60*60*24));
		if(result>0) //������ 
		{
			System.out.println(date+ "�� �������ϴ�.");
		}
		else if(result>0)	//������
		{
			System.out.println(date+ "�� ���ҽ��ϴ�.");
		}
		else 				// D-Day
		{
			System.out.println("D-day�Դϴ�");
		}
	}

}
