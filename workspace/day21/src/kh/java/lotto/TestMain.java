package kh.java.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Random r = new Random();
		ArrayList<Integer> al = new ArrayList<>();
		LottoInputProcess lp = new LottoInputProcess();
		Scanner sc = new Scanner(System.in);
		int num;
		int total=0;

		for(int i=0;i<6;i++)
		{
			try {
				System.out.print(i+1+"번째 값 입력 : ");
				num = sc.nextInt();
				lp.LottoInput1(num);
				al.add(num);
			}catch (LottoInputException e) {
				System.out.println(e.getMessage());
				i--;
			}
		}

		while(true)
		{
			HashSet<Integer> hs = new HashSet();
			int count=0;
			while(true)
			{
				if(hs.add(r.nextInt(45)+1))
				{
					count++;
				}
				if(count==6)
				{
					break;
				}
			}
			
			ArrayList <Integer> lo = new ArrayList(hs);
			Collections.sort(al);
			Collections.sort(lo);

			count = 0;
			System.out.println(al);
			System.out.println(lo);
			total++;
			for(int i = 0;i<lo.size();i++)
			{
				for(int j = 0; j<lo.size(); j++)
				{
					if(al.get(i)==lo.get(j))
					{
						count++;
					}
				}
			}

			switch(count)
			{
			case 4:
				System.out.println("#################\t#################");
				System.out.println("                #\t#                 ");
				System.out.println("                #\t#                ");
				System.out.println("                #\t#                ");
				System.out.println("                #\t#################");
				System.out.println("#################");
				System.out.println("                #\t###################");
				System.out.println("                #");
				System.out.println("                #\t ###############");
				System.out.println("                #\t#\t\t#");
				System.out.println("#################\t ###############");
				System.out.println(total+"회차");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
				}
				break;
			case 5:
				System.out.println("#################\t#################");
				System.out.println("                #\t#                 ");
				System.out.println("                #\t#                ");
				System.out.println("                #\t#                ");
				System.out.println("                #\t#################");
				System.out.println("#################");
				System.out.println("#                \t###################");
				System.out.println("#                ");
				System.out.println("#                \t ###############");
				System.out.println("#                \t#\t\t#");
				System.out.println("#################\t ###############");
				System.out.println(total+"회차");
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
				}
				break;
			case 6:
				System.out.println("        #        \t#################");
				System.out.println("        #        \t#                 ");
				System.out.println("        #        \t#                ");
				System.out.println("        #        \t#                ");
				System.out.println("        #        \t#################");
				System.out.println("        #");
				System.out.println("        #        \t###################");
				System.out.println("        #       ");
				System.out.println("        #        \t ###############");
				System.out.println("        #        \t#\t\t#");
				System.out.println("        #        \t ###############");				
			}
			
			System.out.println(total+"회차 "+count+"개 맞았습니다.");
			
			if(count==6)
			{
				break;
			}
		}
	}

}