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
			System.out.println("���� ��/�� ���߱�");
			System.out.printf("�����ϼ���(���� ������ : %d��/���� 2��) \n",money);
			System.out.print("\t���ñ� : ");
			bating = sc.nextInt();
			System.out.print("���ڸ� �Է����ּ���(1.�ո� / 2.�޸�)");
			num1 = sc.nextInt();
			num2 = r.nextInt(2)+1;

			if(num1==num2)
			{
				System.out.println("������ϴ�^^");
				money = money + bating * 2;
				System.out.println(bating*2+"���� �����̽��ϴ�.");
				win++;
			}
			else
			{			
				System.out.println("��! Ʋ�Ƚ��ϴ�!");
				money = money - bating;
				System.out.println(bating + "�� �����̽��ϴ�.");
				fail++;
			}
			if(money==0)
			{
				System.out.println("�Ļ�Ǽż� �����մϴ�.");
				break;
			}
			System.out.println("������ �ٽ� �Ͻðڽ��ϱ�?(y,n)");
			ch = sc.next().charAt(0);
			if(ch=='n')
			{
				System.out.printf("�� %d�� %d�� %d�� �ϼ̽��ϴ�.",win+fail,win,fail);
				System.out.println("������ �����մϴ�.");
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
			System.out.print("1.����/2.����/3.��/4.���� : ");
			num1 = sc.nextInt();
			if(num1==4)
			{
				System.out.println("������ �����մϴ�.");
				break;
			}
			if(num1!=1 && num1!=2 && num1!=3)
			{
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				continue;
			}
			num2 = r.nextInt(3)+1;

			if(num1==1 && num2==1)		//����, ���� ���
			{
				System.out.println("����ڴ� ������ �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�����ϴ�.");
				draw++;
			}
			else if(num1==1 && num2==2)		//����, ���� ����
			{
				System.out.println("����ڴ� ������ �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�����ϴ�.");
				fail++;
			}
			else if(num1==1 && num2==3)		//����, �� �̱�
			{
				System.out.println("����ڴ� ������ �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�̰���ϴ�.");
				win++;
			}
			else if(num1==2 && num2==1)		//����, ���� �̱�
			{
				System.out.println("����ڴ� ������ �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�̰���ϴ�.");
				win++;
			}
			else if(num1==2 && num2==2)		//���� , ���� ���
			{
				System.out.println("����ڴ� ������ �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�����ϴ�.");
				draw++;
			}
			else if(num1==2 && num2==3)		//����, �� ��
			{
				System.out.println("����ڴ� ������ �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�����ϴ�.");
				fail++;
			}
			else if(num1==3 && num2==1)		//��, ����  ����
			{
				System.out.println("����ڴ� ���� �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�����ϴ�.");
				fail++;
			}
			else if(num1==3 && num2==2)		//��, ����  �̱�
			{
				System.out.println("����ڴ� ���� �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�̰���ϴ�.");
				win++;
			}
			else if(num1==3 && num2==3)		//��, ����  �̱�
			{
				System.out.println("����ڴ� ���� �½��ϴ�.");
				System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
				System.out.println("==================");
				System.out.println("�����ϴ�.");
				draw++;
			}

			System.out.printf("���� ���� %d�� %d�� %d�� %d�� �Դϴ�.\n",win+draw+fail,win,draw,fail);


			System.out.println("������ �� �Ͻðڽ��ϱ�?(y,n)");
			ch = sc.next().charAt(0);
			if(ch=='n')
			{
				System.out.println("������ �����մϴ�.");
				break;
			}
		}	
	}
	public void game3()
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int num1, num2, win;

		System.out.println("= = = = = = �� �� �� ���� ver2.0 = = = = = = =\n");
		while(true)
		{
			System.out.println("�켱 ������������ �սô�");
			System.out.println("1.����/2.����/3.��");
			System.out.print("���� : ");
			num1 = sc.nextInt();
			num2 = r.nextInt(3)+1;

			if(1<=num1 && num1<=3)
			{
				switch(num1)
				{
				case 1:
					System.out.println("����� ������ �½��ϴ�.");
					break;
				case 2:
					System.out.println("����� ������ �½��ϴ�.");
					break;
				default :
					System.out.println("����� ���� �½��ϴ�.");
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
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					break;
				case 2:
					System.out.println("��ǻ�ʹ� ������ �½��ϴ�.");
					break;
				default :
					System.out.println("��ǻ�ʹ� ���� �½��ϴ�.");
					break;
				}
				System.out.println("--------- �� �� �� ---------");
				if(num1==num2)
				{
					System.out.println("�����ϴ� �ٽ� ���� ���� ��");
					continue;
				}
				else if(num1==1 && num2==2)
				{
					System.out.println("��ǻ�Ͱ� ���ݱ��� �������ϴ�");
					win=0;
					break;
				}
				else if(num1==1 && num2==3)
				{
					System.out.println("����� ���ݱ��� �������ϴ�");
					win=1;
					break;
				}
				else if(num1==2 && num2==1)
				{
					System.out.println("��� ���ݱ��� �������ϴ�");
					win=1;
					break;
				}
				else if(num1==2 && num2==3)
				{
					System.out.println("��ǻ�� ���ݱ��� �������ϴ�");
					win=0;
					break;
				}
				else if(num1==3 && num2==1)
				{
					System.out.println("��ǻ�Ͱ� ���ݱ��� �������ϴ�");
					win=0;
					break;
				}
				else if(num1==3 && num2==2)
				{
					System.out.println("����� ���ݱ��� �������ϴ�");
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
				System.out.println("��ǻ���� ���� �Դϴ�!");
				System.out.println("1.�� / 2.�� / 3.��");
				System.out.print("���� : ");
				num1 = sc.nextInt();
				num2 = r.nextInt(3)+1;
				switch(num1)
				{
				case 1:
					System.out.println("��� : ��!!!");
					break;
				case 2:
					System.out.println("��� : ��!!!");
					break;
				default :
					System.out.println("��� : ��!!!");
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
					System.out.println("��ǻ�� : ��!!!");
					break;
				case 2:
					System.out.println("��ǻ�� : ��!!!");
					break;
				default :
					System.out.println("��ǻ�� : ��!!!");
					break;
				}
				if(num1==num2)
				{
					System.out.println("��ǻ�Ͱ� �¸��߽��ϴ�!");
					win = 3;
					break;
				}
				else if(num1==1 && num2==2)
				{
					System.out.println("����� ���ݱ��� �������ϴ�");
					win=1;
					continue;
				}
				else if(num1==1 && num2==3)
				{
					System.out.println("��ǻ�Ͱ� ���ݱ��� �������ϴ�");
					win=0;
					continue;
				}
				else if(num1==2 && num2==1)
				{
					System.out.println("��ǻ�� ���ݱ��� �������ϴ�");
					win=0;
					continue;
				}
				else if(num1==2 && num2==3)
				{
					System.out.println("��� ���ݱ��� �������ϴ�");
					win=1;
					continue;
				}
				else if(num1==3 && num2==1)
				{
					System.out.println("����� ���ݱ��� �������ϴ�");
					win=1;

					continue;
				}
				else if(num1==3 && num2==2)
				{
					System.out.println("��ǻ�Ͱ� ���ݱ��� �������ϴ�");
					win=0;
					continue;
				}
				for (int i=0; i<=10;i++) 
				{
					System.out.println();
				}
				break;
			case 1:
				System.out.println("����� ���� �Դϴ�!");
				System.out.println("1.�� / 2.�� / 3.��");
				System.out.print("���� : ");
				num1 = sc.nextInt();
				num2 = r.nextInt(3)+1;
				switch(num1)
				{
				case 1:
					System.out.println("��� : ��!!!");
					break;
				case 2:
					System.out.println("��� : ��!!!");
					break;
				default :
					System.out.println("��� : ��!!!");
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
					System.out.println("��ǻ�� : ��!!!");
					break;
				case 2:
					System.out.println("��ǻ�� : ��!!!");
					break;
				default :
					System.out.println("��ǻ�� : ��!!!");
					break;
				}
				if(num1==num2)
				{
					System.out.println("����� �¸��߽��ϴ�!");
					win = 3;
					break;
				}
				else if(num1==1 && num2==2)
				{
					System.out.println("����� ���ݱ��� �������ϴ�");
					win=1;
					continue;
				}
				else if(num1==1 && num2==3)
				{
					System.out.println("��ǻ�Ͱ� ���ݱ��� �������ϴ�");
					win=0;
					continue;
				}
				else if(num1==2 && num2==1)
				{
					System.out.println("��ǻ�� ���ݱ��� �������ϴ�");
					win=0;
					continue;
				}
				else if(num1==2 && num2==3)
				{
					System.out.println("��� ���ݱ��� �������ϴ�");
					win=1;
					continue;
				}
				else if(num1==3 && num2==1)
				{
					System.out.println("����� ���ݱ��� �������ϴ�");
					win=1;

					continue;
				}
				else if(num1==3 && num2==2)
				{
					System.out.println("��ǻ�Ͱ� ���ݱ��� �������ϴ�");
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
						System.out.println("1~100���� �Է� : ");
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
							System.out.println("�����Դϴ�!!!");
							num = 3;
						}
						break;
					case 2:
						System.out.println("�ְ� ����� "+count+" �� �Դϴ�.");
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
				System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�.");
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
						System.out.println("1~100���� �Է� : ");
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
							System.out.println("����ڰ� �����Դϴ�!!!");
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
							System.out.println("��ǻ�Ͱ� �����Դϴ�!!!");
							comWin++;
							num = 3;
						}
						break;
					case 2:
						System.out.printf("����� : %d �� %d �� \n", userWin, comWin);
						System.out.printf("��ǻ�� : %d �� %d ��\n", comWin, userWin);
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
				System.out.println("��ȣ�� �߸��Է��ϼ̽��ϴ�.");
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
