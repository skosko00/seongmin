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
			System.out.print((i+1)+"번째 숫자 입력 : ");
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
		// 0으로 초기화
		// 기존에 생성한 변수 -> 쓰레기값
		// new 라는 연산자를 통하여
		// 생성된 변수는 0(int)
		// 0.0(double), false(boolean)
		int menu, room;
		System.out.println("모텔 관리 프로그램 v1.0");
		while(true)
		{
			System.out.println("1.입실	2.퇴실	3.방보기	4.종료");
			System.out.println("선택 >");
			menu = sc.nextInt();
			if(menu==4)
			{
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			if(1<=menu && menu<=3)
			{
				switch(menu)
				{
				case 1:
					System.out.println("몇번방에 입실하시겠습니까?");
					room = sc.nextInt();
					if(arr[room-1]==1)
					{
						System.out.println("이미 방에 손님이 계십니다.");
					}
					else
					{
						System.out.println(room+"방에 입실하였습니다.");
						arr[room-1] = 1;
					}
					break;
				case 2:
					System.out.println("몇번방에서 퇴실하시겠습니까?");
					room = sc.nextInt();
					if(arr[room-1]==0)
					{
						System.out.println("방에 손님이 안계십니다.");
					}
					else
					{
						System.out.println(room+"방에 퇴실하였습니다.");
						arr[room-1] = 0;
					}
					break;
				default:
					for(int i=0; i<arr.length;i++)
					{
						if(arr[i]==0)
						{
							System.out.println(i+1+"번 방이 현재 비어있습니다.");
						}
						else
						{
							System.out.println(i+1+"번 방에는 현재 손님이있습니다.");
						}
					}

				}
			}
			else
			{
				System.out.println("번호를 잘못 입력하셨습니다.");
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
