package com.exception.number;

public class NumberProcess {
	public NumberProcess() {}
	public boolean checkDouble(int a, int b)
	{
		if(!(0<a && a<101 && 0<b && b<101))
		{
			throw new NumberRangeException("1~100 사이의 값이 아닙니다.");
		}
		else if(a%b==0)
		{
			return true;
		}
		return false;
	}
}
