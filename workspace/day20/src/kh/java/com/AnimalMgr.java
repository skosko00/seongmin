package kh.java.com;

public class AnimalMgr <T extends Animal>{
	public T data;
	public AnimalMgr(T data)
	{
		this.data=data;
	}
	
}
