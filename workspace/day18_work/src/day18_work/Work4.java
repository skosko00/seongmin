package day18_work;

import java.util.Scanner;

public class Work4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
		  try {
		  System.out.print("ù��° �� �Է� : ");
		  int su1 = sc.nextInt();
		  System.out.print("�ι�° �� �Է� : ");
		  int su2 = sc.nextInt();
		  System.out.printf("%d + %d = %d \n",su1,su2,su1+su2);
		 }catch (Exception e) {
			System.out.println("������ �Է����ּ���");
		}finally {
			System.out.println("�����ϼ̽��ϴ�.");
		}
		  
	}

}
