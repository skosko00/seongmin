package kh.java.thread;

public class MyThread2 extends Thread{
	Table t;
	public MyThread2(Table t)
	{
		this.t = t;
	}
	@Override
	public void run()
	{
		t.dataPrint(100);
	}
}
