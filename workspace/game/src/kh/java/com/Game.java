package kh.java.com;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GameTest g = new GameTest();
		Scanner sc = new Scanner(System.in);
//		g.game1();
//		g.game2();
//		g.game3();
//		g.gmae4();
//		g.game5();
//		g.game6();
//		
		System.out.println("1.동전 앞뒤 맞추기 게임");
		System.out.println("2.가위바위보 게임");
		System.out.println("3.묵찌빠 게임");
		System.out.println("4.업다운 게임");
		System.out.println("5.종료");
		int a = sc.nextInt();
		
		switch(a)
		{
		case 1:
			g.game1();
			break;
		case 2:
			g.game2();
			break;
		case 3:
			g.game3();
			break;
		case 4:
			g.game6();
			break;
		case 5:
			return;			
		}
		
	}

}

