package day18_work;

import java.util.Calendar;
import java.util.Scanner;

public class Work2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Calendar today = Calendar.getInstance();
		Calendar dDay = Calendar.getInstance();
		System.out.println("## 입력 및 출력 ##");
		System.out.print("D-Day[년도]입력 : ");
		dDay.set(Calendar.YEAR, sc.nextInt());
		System.out.print("D-Day[월]입력 : ");
		dDay.set(Calendar.MONTH, sc.nextInt()-1);
		System.out.print("D-Day[일]입력 : ");
		dDay.set(Calendar.DATE, sc.nextInt());
		System.out.println("오늘 날짜 : " + today.get(Calendar.YEAR)+"년 "+(today.get(Calendar.MONTH)+1)+"월 " + today.get(Calendar.DATE)+"일");
		System.out.printf("D-Day 날짜 : %d년 %d월 %d일\n",dDay.get(Calendar.YEAR),(dDay.get(Calendar.MONTH))+1,dDay.get(Calendar.DATE));
		long d_Day = (dDay.getTimeInMillis()/1000-today.getTimeInMillis()/1000)/(60*60*24);
		if(d_Day==0)
		{
			System.out.printf("D-Day 입니다.");
		}
		else if(0<d_Day)
		{
			System.out.printf("%s일 남았습니다.",d_Day);
		}
		else
		{
			System.out.printf("%s일 지났습니다.",Math.abs(d_Day));
		}
	}

}
