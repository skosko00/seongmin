package kh.java.com;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int [] score = new int [5];
		int sum=0;
		for(int i=1;i<score.length+1;i++)
		{
			System.out.printf("%d 번째 학생의 성적 :",i);
			score[i-1] = sc.nextInt();
			sum += score[i-1];
		}
		System.out.printf("학생들의 총 합계 : %d \n",sum);
		System.out.printf("학생들의 평균 점수 : %.2f",(double)sum/score.length);
		
	}

}
