package kh.com.java;

import java.util.Scanner;

public class Test {
	public void test1()
	{
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [5];
		int tmp;

		for(int i=0; i<arr.length; i++)
		{
			System.out.print((i+1)+"��° ���� �Է� : ");
			arr[i] = sc.nextInt();
		}

		for(int i=0; i<arr.length;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1])
				{
					tmp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=tmp;
				}
			}
		}

		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public void test2()
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

	public void test3()
	{
		int [] arr1 = {1,2,3,4,5};
		int [] arr2 = new int[arr1.length];
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);

		arr2[2] = 999;
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println(arr1[i]);
		}
	}

	public void test4()
	{
		int [][] arr = {{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16},
				{17,18,19,20}};

		System.out.println(arr[2][3]+arr[4][3]);
	}

	public void test5()
	{
		int [][] arr = new int [5][5];
		int k=1;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[i].length;j++)
			{
				arr[i][j] = k++;
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

	public void test6()
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

	public void test7()
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

	public void test8()
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

	public void test9()
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

	public void test10()
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

	public void test11()
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

	public void test12()
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
}
