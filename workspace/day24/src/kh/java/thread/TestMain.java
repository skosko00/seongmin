package kh.java.thread;

public class TestMain {

	public static void main(String[] args) {

		/*
		TestClass t1 = new TestClass();
		TimeAdd t2 = new TimeAdd();
		t1.start();
		t2.start();
		������� �޾��� ���
	
		TestClass t1 = new TestClass();
		TimeAdd t2 = new TimeAdd();
		Thread a = new Thread(t1);
		Thread b = new Thread(t2);	
		a.start();
		b.start();		
		
		Thread a = new Thread(new TestClass());	// Runnable �������̽��� �޾������
		Thread b = new Thread(new TimeAdd());	// Runnable �������̽��� �޾������
		//Runnable �������̽��� �޾������
	*/
		
		Table t = new Table();	//1��
		Thread t1 = new MyThread1(t);
		Thread t2 = new MyThread2(t);
		t1.start();
		t2.start();
		


		
	}

}
