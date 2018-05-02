package net.kh.member.controller;

import java.util.Random;
import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Member m = new Member();
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int num, ran, input, comWin=0, userWin=0;

		int comRan;

		while(true)
		{
			System.out.println("1.Game Start");
			System.out.println("2.Game Score");
			System.out.println("3.Game Exit");
			num = sc.nextInt();
			if(num==3)
			{
				break;
			}
			ran = r.nextInt(99)+1;
			if(1<=num && num<=2)
			{
				int max=100,min=1, sw=0;
				while(true)
				{
					switch(num)
					{
					case 1:
						System.out.printf("%d ~ %d 까지 입력 : ",min,max);
						input = sc.nextInt();

						if(min<input && input<max)
						{
							if(ran<input)
							{
								System.out.println("Down!!!");
								if(max>input)
								{
									max=input;
								}
							}
							else if(ran>input)
							{
								System.out.println("Up!!!");
								if(input>min)
								{
									min=input;
								}
							}
							else if(ran==input)
							{
								System.out.println("사용자가 정답입니다!!!");
								userWin++;
								num = 3;
								break;
							}
						}
						else
						{
							System.out.println("범위 잘못 입력!");
							continue;
						}
						comRan = r.nextInt(max-min)+min+1;
						{
							System.out.println("Computer : ");
							System.out.println(comRan);

							if(ran<comRan)
							{
								System.out.println("Down!!!");            
								if(max>comRan)
								{
									max=comRan;
								}
							}
							else if(ran>comRan)
							{
								System.out.println("Up!!!");
								if(comRan>min)
								{
									min=comRan;
								}
							}
							else if(ran==comRan)
							{
								System.out.println("컴퓨터가 정답입니다!!!");
								comWin++;
								num = 3;
								break;
							}
						}
						break;
					case 2:
						System.out.printf("사용자 : %d 승 %d 패 \n", userWin, comWin);
						System.out.printf("컴퓨터 : %d 승 %d 패\n", comWin, userWin);
						num = 3;
						break;
					default :                        
						break;
					}
					if(num==3)
					{
						break;
					}
				}
			}
			else
			{
				System.out.println("번호를 잘못입력하셨습니다.");
				continue;
			}
		}
	}

}


