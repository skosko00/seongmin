package kh.java.com;

import java.util.Random;
import java.util.Scanner;

public class GameTest {
	public void game1() 
	{
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int num1, num2, bating, money=500, win=0,fail=0;
		char ch;
		while(true)
		{
			System.out.println("동전 앞/뒤 맞추기");
			System.out.printf("배팅하세요(현재 소지금 : %d원/배당금 2배) \n",money);
			System.out.print("\t배팅금 : ");
			bating = sc.nextInt();
			System.out.print("숫자를 입력해주세요(1.앞면 / 2.뒷면)");
			num1 = sc.nextInt();
			num2 = r.nextInt(2)+1;

			if(num1==num2)
			{
				System.out.println("맞췄습니다^^");
				money = money + bating * 2;
				System.out.println(bating*2+"원을 얻으셨습니다.");
				win++;
			}
			else
			{			
				System.out.println("땡! 틀렸습니다!");
				money = money - bating;
				System.out.println(bating + "을 잃으셨습니다.");
				fail++;
			}
			if(money==0)
			{
				System.out.println("파산되셔서 종료합니다.");
				break;
			}
			System.out.println("게임을 다시 하시겠습니까?(y,n)");
			ch = sc.next().charAt(0);
			if(ch=='n')
			{
				System.out.printf("총 %d전 %d승 %d패 하셨습니다.",win+fail,win,fail);
				System.out.println("게임을 종료합니다.");
				break;
			}
			System.out.println("----------------------->restart");
		}
	}

	public void game2()
	{
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		int win=0, fail=0, draw=0, num1, num2;
		char ch;
		while(true)
		{
			System.out.print("1.가위/2.바위/3.보/4.종료 : ");
			num1 = sc.nextInt();
			if(num1==4)
			{
				System.out.println("게임을 종료합니다.");
				break;
			}
			if(num1!=1 && num1!=2 && num1!=3)
			{
				System.out.println("잘못 입력하셨습니다.");
				continue;
			}
			num2 = r.nextInt(3)+1;

			if(num1==1 && num2==1)		//가위, 가위 비김
			{
				System.out.println("사용자는 가위를 냈습니다.");
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("==================");
				System.out.println("비겼습니다.");
				draw++;
			}
			else if(num1==1 && num2==2)		//가위, 바위 졌음
			{
				System.out.println("사용자는 가위를 냈습니다.");
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("==================");
				System.out.println("졌습니다.");
				fail++;
			}
			else if(num1==1 && num2==3)		//가위, 보 이김
			{
				System.out.println("사용자는 가위를 냈습니다.");
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("==================");
				System.out.println("이겼습니다.");
				win++;
			}
			else if(num1==2 && num2==1)		//바위, 가위 이김
			{
				System.out.println("사용자는 바위를 냈습니다.");
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("==================");
				System.out.println("이겼습니다.");
				win++;
			}
			else if(num1==2 && num2==2)		//바위 , 바위 비김
			{
				System.out.println("사용자는 바위를 냈습니다.");
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("==================");
				System.out.println("비겼습니다.");
				draw++;
			}
			else if(num1==2 && num2==3)		//바위, 보 짐
			{
				System.out.println("사용자는 바위를 냈습니다.");
				System.out.println("컴퓨터는 보를 냈습니다.");
				System.out.println("==================");
				System.out.println("졌습니다.");
				fail++;
			}
			else if(num1==3 && num2==1)		//보, 가위  졌음
			{
				System.out.println("사용자는 보를 냈습니다.");
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("==================");
				System.out.println("졌습니다.");
				fail++;
			}
			else if(num1==3 && num2==2)		//보, 가위  이김
			{
				System.out.println("사용자는 보를 냈습니다.");
				System.out.println("컴퓨터는 바위를 냈습니다.");
				System.out.println("==================");
				System.out.println("이겼습니다.");
				win++;
			}
			else if(num1==3 && num2==3)		//보, 가위  이김
			{
				System.out.println("사용자는 보를 냈습니다.");
				System.out.println("컴퓨터는 가위를 냈습니다.");
				System.out.println("==================");
				System.out.println("비겼습니다.");
				draw++;
			}

			System.out.printf("현재 전적 %d전 %d승 %d무 %d패 입니다.\n",win+draw+fail,win,draw,fail);


			System.out.println("게임을 더 하시겠습니까?(y,n)");
			ch = sc.next().charAt(0);
			if(ch=='n')
			{
				System.out.println("게임을 종료합니다.");
				break;
			}
		}	
	}
	public void game3()
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int num1, num2, win;

		System.out.println("= = = = = = 묵 찌 빠 게임 ver2.0 = = = = = = =\n");
		while(true)
		{
			System.out.println("우선 가위바위보를 합시다");
			System.out.println("1.가위/2.바위/3.보");
			System.out.print("선택 : ");
			num1 = sc.nextInt();
			num2 = r.nextInt(3)+1;

			if(1<=num1 && num1<=3)
			{
				switch(num1)
				{
				case 1:
					System.out.println("당신은 가위를 냈습니다.");
					break;
				case 2:
					System.out.println("당신은 바위를 냈습니다.");
					break;
				default :
					System.out.println("당신은 보를 냈습니다.");
					break;
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(num2)
				{
				case 1:
					System.out.println("컴퓨터는 가위를 냈습니다.");
					break;
				case 2:
					System.out.println("컴퓨터는 바위를 냈습니다.");
					break;
				default :
					System.out.println("컴퓨터는 보를 냈습니다.");
					break;
				}
				System.out.println("--------- 공 격 권 ---------");
				if(num1==num2)
				{
					System.out.println("비겼습니다 다시 가위 바위 보");
					continue;
				}
				else if(num1==1 && num2==2)
				{
					System.out.println("컴퓨터가 공격권을 가져갑니다");
					win=0;
					break;
				}
				else if(num1==1 && num2==3)
				{
					System.out.println("당신이 공격권을 가져갑니다");
					win=1;
					break;
				}
				else if(num1==2 && num2==1)
				{
					System.out.println("당신 공격권을 가져갑니다");
					win=1;
					break;
				}
				else if(num1==2 && num2==3)
				{
					System.out.println("컴퓨터 공격권을 가져갑니다");
					win=0;
					break;
				}
				else if(num1==3 && num2==1)
				{
					System.out.println("컴퓨터가 공격권을 가져갑니다");
					win=0;
					break;
				}
				else if(num1==3 && num2==2)
				{
					System.out.println("당신이 공격권을 가져갑니다");
					win=1;
					break;
				}
			}
		}
		while(true)
		{
			switch(win)
			{
			case 0: 
				System.out.println("컴퓨터의 공격 입니다!");
				System.out.println("1.묵 / 2.찌 / 3.빠");
				System.out.print("선택 : ");
				num1 = sc.nextInt();
				num2 = r.nextInt(3)+1;
				switch(num1)
				{
				case 1:
					System.out.println("당신 : 묵!!!");
					break;
				case 2:
					System.out.println("당신 : 찌!!!");
					break;
				default :
					System.out.println("당신 : 빠!!!");
					break;
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(num2)
				{
				case 1:
					System.out.println("컴퓨터 : 묵!!!");
					break;
				case 2:
					System.out.println("컴퓨터 : 찌!!!");
					break;
				default :
					System.out.println("컴퓨터 : 빠!!!");
					break;
				}
				if(num1==num2)
				{
					System.out.println("컴퓨터가 승리했습니다!");
					win = 3;
					break;
				}
				else if(num1==1 && num2==2)
				{
					System.out.println("당신이 공격권을 가져갑니다");
					win=1;
					continue;
				}
				else if(num1==1 && num2==3)
				{
					System.out.println("컴퓨터가 공격권을 가져갑니다");
					win=0;
					continue;
				}
				else if(num1==2 && num2==1)
				{
					System.out.println("컴퓨터 공격권을 가져갑니다");
					win=0;
					continue;
				}
				else if(num1==2 && num2==3)
				{
					System.out.println("당신 공격권을 가져갑니다");
					win=1;
					continue;
				}
				else if(num1==3 && num2==1)
				{
					System.out.println("당신이 공격권을 가져갑니다");
					win=1;

					continue;
				}
				else if(num1==3 && num2==2)
				{
					System.out.println("컴퓨터가 공격권을 가져갑니다");
					win=0;
					continue;
				}
				for (int i=0; i<=10;i++) 
				{
					System.out.println();
				}
				break;
			case 1:
				System.out.println("당신의 공격 입니다!");
				System.out.println("1.묵 / 2.찌 / 3.빠");
				System.out.print("선택 : ");
				num1 = sc.nextInt();
				num2 = r.nextInt(3)+1;
				switch(num1)
				{
				case 1:
					System.out.println("당신 : 묵!!!");
					break;
				case 2:
					System.out.println("당신 : 찌!!!");
					break;
				default :
					System.out.println("당신 : 빠!!!");
					break;
				}
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				switch(num2)
				{
				case 1:
					System.out.println("컴퓨터 : 묵!!!");
					break;
				case 2:
					System.out.println("컴퓨터 : 찌!!!");
					break;
				default :
					System.out.println("컴퓨터 : 빠!!!");
					break;
				}
				if(num1==num2)
				{
					System.out.println("당신이 승리했습니다!");
					win = 3;
					break;
				}
				else if(num1==1 && num2==2)
				{
					System.out.println("당신이 공격권을 가져갑니다");
					win=1;
					continue;
				}
				else if(num1==1 && num2==3)
				{
					System.out.println("컴퓨터가 공격권을 가져갑니다");
					win=0;
					continue;
				}
				else if(num1==2 && num2==1)
				{
					System.out.println("컴퓨터 공격권을 가져갑니다");
					win=0;
					continue;
				}
				else if(num1==2 && num2==3)
				{
					System.out.println("당신 공격권을 가져갑니다");
					win=1;
					continue;
				}
				else if(num1==3 && num2==1)
				{
					System.out.println("당신이 공격권을 가져갑니다");
					win=1;

					continue;
				}
				else if(num1==3 && num2==2)
				{
					System.out.println("컴퓨터가 공격권을 가져갑니다");
					win=0;
					continue;
				}
				for (int i=0; i<=10;i++) 
				{
					System.out.println();
				}
			default:
				break;
			}
			break;
		}

	}
	public void gmae4()
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int num, ran, input, count=0;

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
			ran = r.nextInt(100)+1;
			if(1<=num && num<=2)
			{
				while(true)
				{
					switch(num)
					{
					case 1:
						System.out.println("1~100까지 입력 : ");
						input = sc.nextInt();
						if(ran<input)
						{
							System.out.println("Down!!!");
							count++;
						}
						else if(ran>input)
						{
							System.out.println("Up!!!");
							count++;
						}
						else
						{
							System.out.println("정답입니다!!!");
							num = 3;
						}
						break;
					case 2:
						System.out.println("최고 기록은 "+count+" 번 입니다.");
						break;
					case 3:
						break;
					}
					System.out.println(ran);
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

	public void game5()
	{
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
			ran = r.nextInt(100)+1;
			if(1<=num && num<=2)
			{
				while(true)
				{
					switch(num)
					{
					case 1:
						System.out.println("1~100까지 입력 : ");
						input = sc.nextInt();
						if(ran<input)
						{
							System.out.println("Down!!!");						
						}
						else if(ran>input)
						{
							System.out.println("Up!!!");
						}
						else
						{
							System.out.println("사용자가 정답입니다!!!");
							userWin++;
							num = 3;
						}
						comRan = r.nextInt(100)+1;
						System.out.println("Computer : ");
						System.out.println(comRan);
						if(ran<comRan)
						{
							System.out.println("Down!!!");						
						}
						else if(ran>comRan)
						{
							System.out.println("Up!!!");
						}
						else
						{
							System.out.println("컴퓨터가 정답입니다!!!");
							comWin++;
							num = 3;
						}
						break;
					case 2:
						System.out.printf("사용자 : %d 승 %d 패 \n", userWin, comWin);
						System.out.printf("컴퓨터 : %d 승 %d 패\n", comWin, userWin);
						num = 3;
						break;
					case 3:						
						break;

					}
					break;
				}
			}
			else
			{
				System.out.println("번호를 잘못입력하셨습니다.");
				continue;
			}

		}
	}

	public void game6()
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int num, ran, input, comWin=0, userWin=0;
		int max=100,min=0, sw=0;
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
