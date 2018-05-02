package kh.java.com;

public class GenericEx <T,E>{
	public T data1;
	public E data2;
	public GenericEx(T data1, E data2)
	{
		this.data1=data1;
		this.data2=data2;
	}
	public T getData1() {return this.data1;}
	public E getData2() {return this.data2;}

}
