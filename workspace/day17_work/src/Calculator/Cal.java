package Calculator;

import java.util.Scanner;

public class Cal implements Calculator{

	@Override
	public int add(String su1, String su2) {
		// TODO Auto-generated method stub
		return Integer.parseInt(su1)+Integer.parseInt(su2);
	}

	@Override
	public int subtract(String su1, String su2) {
		// TODO Auto-generated method stub
		return Integer.parseInt(su1)-Integer.parseInt(su2);
	}

	@Override
	public int multiply(String su1, String su2) {
		// TODO Auto-generated method stub
		return Integer.parseInt(su1)*Integer.parseInt(su2);
	}

	@Override
	public double divide(String su1, String su2) {
		// TODO Auto-generated method stub
		return Integer.parseInt(su1)/Double.parseDouble(su2);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		char op;
		String num1, num2;
		System.out.print("������ �Է�(+,-,*,/) : ");
		op = sc.next().charAt(0);
		System.out.print("ù��° ���� �Է� : ");
		num1 = sc.next();
		System.out.print("�ι�° ���� �Է� : ");
		num2 = sc.next();
		switch(op)
		{
		case '+':
			System.out.printf("%s + %s = %d",num1,num2,add(num1,num2));
			break;
		case '-':
			System.out.printf("%s + %s = %d",num1,num2,subtract(num1,num2));
			break;
		case '*':
			System.out.printf("%s + %s = %d",num1,num2,multiply(num1,num2));
			break;
		case '/':
			System.out.printf("%s + %s = %.2f",num1,num2,divide(num1,num2));
			break;
			
		}
	}

}
