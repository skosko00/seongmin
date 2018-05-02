package kh.java.com;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int menu, choice, num=0;
		int value=0, total=0;
		char ch;
		String menuName="";
		do {
			System.out.println("±è¹ä·ù==================");
			System.out.println("1.¿øÁ¶±è¹ä==========1000¿ø");
			System.out.println("2.Ä¡Áî±è¹ä==========1200¿ø");
			System.out.println("3.ÂüÄ¡±è¹ä==========2000¿ø");
			System.out.println("¶ó¸é====================");
			System.out.println("4.±×³É¶ó¸é==========1200¿ø");
			System.out.println("5.Ä¡Áî¶ó¸é==========1500¿ø");
			System.out.println("6.Â«»Í¶ó¸é==========2000¿ø");
			System.out.println("±âÅ¸=====================");
			System.out.println("7.Æ¢±è=============2000¿ø");
			System.out.println("8.¼ø´ë=============2000¿ø");
			System.out.println("9.¿Àµ­=============2000¿ø");
			System.out.println("10.À½·á¼ö===========2000¿ø");

			System.out.print("¸Þ´º¼±ÅÃ : ");
			menu = sc.nextInt();
			if(1<=menu && menu<=10)
			{
				switch(menu)
				{
				case 1:
					menuName = "¿øÁ¶±è¹ä";
					value = 1000;
					break;
				case 2:
					menuName = "Ä¡Áî±è¹ä";
					value = 1200;
					break;
				case 3:
					menuName = "ÂüÄ¡±è¹ä";
					value = 2000;
					break;
				case 4:
					menuName = "±×³É¶ó¸é";
					value = 1200;
					break;
				case 5:
					menuName = "Ä¡Áî¶ó¸é";
					value = 1500;
					break;
				case 6:
					menuName = "Â«»Í¶ó¸é";
					value = 2000;
					break;
				case 7:
					menuName = "Æ¢±è";
					value = 2000;
					break;
				case 8:
					menuName = "¼ø´ë";
					value = 2000;
					break;
				case 9:
					menuName = "¿Àµ­";
					value = 2000;
					break;
				default:
					menuName = "À½·á¼ö";
					value = 2000;
					break;
				}
			}
			System.out.print("¼ö·®¼±ÅÃ : ");
			choice = sc.nextInt();
			num = value * choice;
			total += num;
			System.out.println(menuName+"À» "+choice+"°³ ÁÖ¹®ÇÏ¼Ì½À´Ï´Ù.");

			System.out.print("Ãß°¡ÁÖ¹®ÇÏ½Ã°Ú½À´Ï±î?");
			ch = sc.next().charAt(0);
		}

		while(ch=='y');

		System.out.println("ÁöºÒÇÏ½Ç ±Ý¾×Àº ÃÑ" +total+" ÀÔ´Ï´Ù");		
	}

}
