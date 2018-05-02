package com.exception.number;

public class NumberRangeException extends RuntimeException{
	public NumberRangeException()
	{
		super();
	}
	public NumberRangeException(String measage)
	{
		super(measage);
	}
}
