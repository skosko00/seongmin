package kh.java.com;

import java.util.Random;
import java.util.Scanner;

public class TestMain {
	public void home1()
	{
		Scanner sc = new Scanner(System.in);
		int [] num = new int [5];
		int tmp;

		for(int i=0;i<num.length;i++)
		{
			System.out.print((i+1)+"��° �����Է� : ");
			num[i] = sc.nextInt();
		}
		for(int i=0;i<num.length;i++)
		{
			for(int j=0;j<num.length-1-i;j++)
			{
				if(num[j]>num[j+1])
				{
					tmp = num[j+1];
					num[j+1]=num[j];
					num[j]=tmp;
				}
			}
		}
		for(int i=0; i<num.length;i++)
		{
			System.out.print(num[i]+"\t");
		}
	}

	public void home2()
	{
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [10];
		// 0���� �ʱ�ȭ
		// ������ ������ ���� -> �����Ⱚ
		// new ��� �����ڸ� ���Ͽ�
		// ������ ������ 0(int)
		// 0.0(double), false(boolean)
		int menu, room;
		System.out.println("���� ���� ���α׷� v1.0");
		while(true)
		{
			System.out.println("1.�Խ�	2.���	3.�溸��	4.����");
			System.out.println("���� >");
			menu = sc.nextInt();
			if(menu==4)
			{
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
			if(1<=menu && menu<=3)
			{
				switch(menu)
				{
				case 1:
					System.out.println("����濡 �Խ��Ͻðڽ��ϱ�?");
					room = sc.nextInt();
					if(arr[room-1]==1)
					{
						System.out.println("�̹� �濡 �մ��� ��ʴϴ�.");
					}
					else
					{
						System.out.println(room+"�濡 �Խ��Ͽ����ϴ�.");
						arr[room-1] = 1;
					}
					break;
				case 2:
					System.out.println("����濡�� ����Ͻðڽ��ϱ�?");
					room = sc.nextInt();
					if(arr[room-1]==0)
					{
						System.out.println("�濡 �մ��� �Ȱ�ʴϴ�.");
					}
					else
					{
						System.out.println(room+"�濡 ����Ͽ����ϴ�.");
						arr[room-1] = 0;
					}
					break;
				default:
					for(int i=0; i<arr.length;i++)
					{
						if(arr[i]==0)
						{
							System.out.println(i+1+"�� ���� ���� ����ֽ��ϴ�.");
						}
						else
						{
							System.out.println(i+1+"�� �濡�� ���� �մ����ֽ��ϴ�.");
						}
					}

				}
			}
			else
			{
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
			}
			try {
				Thread.sleep(700);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}

	public void home3()
	{
		String str;
		char ch;
		int count=0;
		Scanner sc = new Scanner(System.in);

		System.out.print("�Է� �� : ");
		str = sc.nextLine();
		char [] arr = new char[str.length()];
		for(int i=0; i<str.length();i++)
		{
			arr[i]=str.charAt(i);		
		}
		System.out.print("�˻� �� : ");
		ch = sc.next().charAt(0);
		if('a'<=ch && ch<='z')
		{
			for(int i=0; i<arr.length;i++)
			{
				if(arr[i]==ch)
				{
					count++;
				}
			}
		}
		else
		{
			System.out.println("a~z �Ǵ� A~Z�� �Է� �����մϴ�.");
		}
		System.out.printf("�Է��Ͻ� ���ڿ� %s���� ã���ô� ���� %c�� %d�� �Դϴ�.",str,ch,count);
	}

	public void home4()
	{
		Scanner sc = new Scanner(System.in);
		String phone;

		System.out.print("�޴��� ��ȣ�� �Է��ϼ��� : ");
		phone = sc.nextLine();
		char [] num = new char[phone.length()];
		char [] num1 = new char[num.length];
		for(int i=0; i<num.length; i++)
		{
			num[i]=phone.charAt(i);
		}
		num1 = num.clone();
		for(int i=4;i<=7;i++)
		{
			num1[i]='*';
		}
		for(int i=0; i<num1.length;i++)
		{
			System.out.print(num1[i]);
		}
	}

	public void array1()
	{
		int [][] arr = new int [5][5];
		int k=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=4;j>=0;j--)
			{
				arr[i][j]=k++;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}

	public void array2()
	{
		int [][] arr = new int [5][5];
		int k=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[j][i]=k++;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}

	public void array3()
	{
		int [][] arr = new int [5][5];
		int k=1;
		for(int i=0; i<arr.length;i++)
		{
			for(int j=4;j>=0;j--)
			{
				arr[j][i]=k++;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}

	public void array4()
	{
		int [][] arr = new int [5][5];
		int k=1;

		for(int i=0; i<arr.length; i++)
		{
			for(int j=0;j<arr[i].length; j++)
			{
				if(i%2==0)
				{
					arr[i][j]=k++;
				}
			}
			for(int j=4;j>=0;j--)
			{
				if(i%2==1)
				{
					arr[i][j]=k++;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();		
		}
	}

	public void array5()
	{
		int [][] arr = new int [5][5];
		int k=1;
		for(int i=0; i<arr.length; i++)
		{
			for(int j=4;j>=0; j--)
			{
				if(i%2==0)
				{
					arr[i][j]=k++;
				}
			}
			for(int j=0;j<arr.length;j++)
			{
				if(i%2==1)
				{
					arr[i][j]=k++;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();		
		}
	}

	public void array6()
	{
		int [][] arr = new int [5][5];
		int k=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				if(i%2==0)
				{
					arr[j][i]=k++;
				}
			}
			for(int j=4;j>=0;j--)
			{
				if(i%2==1)
				{
					arr[j][i]=k++;
				}
			}

		}


		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}

	public void array7()
	{
		int [][] arr = new int [5][5];
		int k=1;
		for(int i=0; i<arr.length;i++)
		{
			for(int j=4;j>=0;j--)
			{
				if(i%2==0)
				{
					arr[j][i]=k++;
				}
			}
			for(int j=0;j<arr.length;j++)
			{
				if(i%2==1)
				{
					arr[j][i]=k++;
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				System.out.printf("%5d",arr[i][j]);
			}
			System.out.println();
		}
	}

	public void array8()
	{
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int num1, num2;
		while(true)
		{
			System.out.print("�������� ������ �Է��ϼ���(1~10) ==>");
			num1= sc.nextInt();
			if (1<=num1&&num1<=10)
			{
				System.out.print("���ο��� ������ �Է��ϼ���(1~10) ==>");
				num2 = sc.nextInt();
				if(1<=num2&&num2<=10)
				{
					int [][] arr = new int [num1][num2];
					for(int i=0;i<arr.length;i++)
					{
						for(int j=0; j<arr[i].length;j++)
						{
							arr[i][j]=r.nextInt(26)+97;
						}
					}
					for(int i=0;i<arr.length;i++)
					{
						for(int j=0;j<arr[i].length;j++)
						{
							System.out.printf("%5c",arr[i][j]);
						}
						System.out.println();
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				{
					System.out.println("���ο��� ������ �߸� �Է��Ͽ����ϴ�.");
				}
			}
			else
			{
				System.out.println("�������� ������ �߸� �Է��Ͽ����ϴ�.");
			}
		}


	}

	public void home5()
	{
		Random r = new Random();
		int [] lotto = new int [6];
		{
			for(int i=0; i<lotto.length; i++)
			{				
				lotto[i] = r.nextInt(45)+1;
			}
			for(int i=0; i<lotto.length-1;i++)
			{
				if(lotto[i]==lotto[i+1])
				{
					lotto[i+1]=r.nextInt(45)+1;
				}
			}

			for(int i=0; i<lotto.length; i++)
			{
				System.out.println(lotto[i]);
			}
		}
	}
}
