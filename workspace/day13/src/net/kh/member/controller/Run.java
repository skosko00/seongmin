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
						System.out.printf("%d ~ %d ���� �Է� : ",min,max);
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
								System.out.println("����ڰ� �����Դϴ�!!!");
								userWin++;
								num = 3;
								break;
							}
						}
						else
						{
							System.out.println("���� �߸� �Է�!");
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
								System.out.println("��ǻ�Ͱ� �����Դϴ�!!!");
								comWin++;
								num = 3;
								break;
							}
						}
						break;
					case 2:
						System.out.printf("����� : %d �� %d �� \n", userWin, comWin);
						System.out.printf("��ǻ�� : %d �� %d ��\n", comWin, userWin);
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
				System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�.");
				continue;
			}
		}
	}

}


